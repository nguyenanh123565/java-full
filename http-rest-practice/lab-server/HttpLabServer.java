import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Server quan sát HTTP bằng JDK, không triển khai bài CRUD hay xác thực. */
public class HttpLabServer {
    private static final String READ_METHODS = "GET, HEAD, OPTIONS";
    private static final String ECHO_METHODS = "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS";
    private static final String CORS_ORIGIN = "http://localhost:3000";
    private static final int BODY_LIMIT = 64 * 1024;
    private static final String PRODUCT = "{\"id\":10,\"name\":\"Robot Demo\","
            + "\"category\":\"robot\",\"price\":7500000,\"stock\":18}";
    private static final Set<Integer> SAMPLE_STATUSES = Set.of(
            200, 201, 204, 400, 401, 403, 404, 405, 406, 409, 413, 415, 422, 500, 503);
    private static final List<String> OBSERVED_HEADERS = List.of(
            "content-type", "accept", "authorization", "cookie", "origin", "x-lab-header");

    public static void main(String[] args) throws IOException {
        int port = args.length == 0 ? 8080 : Integer.parseInt(args[0]);
        if (port < 1 || port > 65535) throw new IllegalArgumentException("Port phải trong 1..65535");
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", port), 0);
        ExecutorService workers = Executors.newFixedThreadPool(4);
        server.setExecutor(workers);
        server.createContext("/", HttpLabServer::handle);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop(0);
            workers.shutdown();
        }));
        server.start();
        System.out.println("HTTP lab: http://localhost:" + port + " (Ctrl+C to stop)");
    }

    private static void handle(HttpExchange exchange) throws IOException {
        try {
            String path = exchange.getRequestURI().getPath();
            String method = exchange.getRequestMethod();
            if (path.equals("/echo")) {
                if (!allow(exchange, ECHO_METHODS)) return;
                if (method.equals("OPTIONS")) { noContent(exchange); return; }
                echo(exchange);
            } else if (path.equals("/cors")) {
                cors(exchange);
            } else if (path.equals("/health") || path.equals("/products") || path.equals("/products/10")) {
                if (!allow(exchange, READ_METHODS)) return;
                if (method.equals("OPTIONS")) { noContent(exchange); return; }
                if (path.startsWith("/products") && exchange.getRequestURI().getRawQuery() != null) {
                    error(exchange, 400, "QUERY_NOT_IMPLEMENTED", "Use /echo to observe query parameters");
                    return;
                }
                String body = path.equals("/health") ? "{\"status\":\"ok\"}"
                        : path.equals("/products") ? "{\"data\":[" + PRODUCT + "]}" : "{\"data\":" + PRODUCT + "}";
                json(exchange, 200, body);
            } else if (path.startsWith("/status/")) {
                if (!allow(exchange, READ_METHODS)) return;
                if (method.equals("OPTIONS")) { noContent(exchange); return; }
                sampleStatus(exchange, path.substring("/status/".length()));
            } else {
                error(exchange, 404, "NOT_FOUND", "This endpoint is not implemented by the lab");
            }
        } catch (RuntimeException e) {
            error(exchange, 500, "LAB_ERROR", "Unexpected lab error");
        } finally {
            exchange.close();
        }
    }

    private static boolean allow(HttpExchange exchange, String methods) throws IOException {
        if (List.of(methods.split(", ")).contains(exchange.getRequestMethod())) {
            if (exchange.getRequestMethod().equals("OPTIONS")) exchange.getResponseHeaders().set("Allow", methods);
            return true;
        }
        exchange.getResponseHeaders().set("Allow", methods);
        error(exchange, 405, "METHOD_NOT_ALLOWED", "Method is not supported for this lab endpoint");
        return false;
    }

    private static void echo(HttpExchange exchange) throws IOException {
        byte[] bytes = exchange.getRequestBody().readNBytes(BODY_LIMIT + 1);
        if (bytes.length > BODY_LIMIT) {
            error(exchange, 413, "BODY_TOO_LARGE", "Body exceeds the lab limit of 65536 bytes");
            return;
        }
        StringBuilder headersJson = new StringBuilder("{");
        boolean first = true;
        for (String name : OBSERVED_HEADERS) {
            List<String> values = exchange.getRequestHeaders().get(name);
            if (values == null) continue;
            if (!first) headersJson.append(',');
            headersJson.append(quote(name)).append(':').append(quote(String.join(", ", values)));
            first = false;
        }
        headersJson.append('}');
        // Body giữ dưới dạng string UTF-8: server KHÔNG parse/validate JSON đầu vào.
        // HEAD có metadata của GET tương ứng, không gửi body của chính HEAD.
        String representationMethod = exchange.getRequestMethod().equals("HEAD") ? "GET" : exchange.getRequestMethod();
        String body = "{\"method\":" + quote(representationMethod)
                + ",\"path\":" + quote(exchange.getRequestURI().getPath())
                + ",\"rawQuery\":" + quote(exchange.getRequestURI().getRawQuery())
                + ",\"headers\":" + headersJson
                + ",\"receivedBody\":" + quote(new String(bytes, StandardCharsets.UTF_8)) + "}";
        json(exchange, 200, body);
    }

    private static void sampleStatus(HttpExchange exchange, String value) throws IOException {
        int status;
        try { status = Integer.parseInt(value); }
        catch (NumberFormatException e) {
            error(exchange, 400, "INVALID_STATUS", "Use a supported numeric sample status");
            return;
        }
        if (!SAMPLE_STATUSES.contains(status)) {
            error(exchange, 400, "INVALID_STATUS", "This sample status is not supported");
            return;
        }
        Headers headers = exchange.getResponseHeaders();
        if (status == 401) headers.set("WWW-Authenticate", "Bearer realm=\"http-lab\"");
        if (status == 405) headers.set("Allow", READ_METHODS);
        if (status == 201) headers.set("Location", "/products/10");
        if (status == 204) { noContent(exchange); return; }
        if (status >= 400) error(exchange, status, "DEMO_" + status, "Sample status " + status);
        else json(exchange, status, "{\"status\":" + status + "}");
    }

    private static void cors(HttpExchange exchange) throws IOException {
        Headers response = exchange.getResponseHeaders();
        response.set("Vary", "Origin, Access-Control-Request-Method, Access-Control-Request-Headers");
        if (!allow(exchange, "GET, HEAD, POST, OPTIONS")) return;
        String origin = exchange.getRequestHeaders().getFirst("Origin");
        if (CORS_ORIGIN.equals(origin)) response.set("Access-Control-Allow-Origin", CORS_ORIGIN);
        if (exchange.getRequestMethod().equals("OPTIONS")) {
            String requestedMethod = exchange.getRequestHeaders().getFirst("Access-Control-Request-Method");
            String requestedHeaders = exchange.getRequestHeaders().getFirst("Access-Control-Request-Headers");
            if (CORS_ORIGIN.equals(origin) && requestedMethod != null) {
                if (!Set.of("GET", "HEAD", "POST").contains(requestedMethod)) {
                    error(exchange, 403, "PREFLIGHT_DENIED", "Requested method is not allowed");
                    return;
                }
                if (requestedHeaders != null) {
                    for (String header : requestedHeaders.split(",")) {
                        if (!header.trim().equalsIgnoreCase("Content-Type") && !header.trim().equalsIgnoreCase("X-Lab-Header")) {
                            error(exchange, 403, "PREFLIGHT_DENIED", "Requested header is not allowed");
                            return;
                        }
                    }
                }
                response.set("Access-Control-Allow-Methods", "GET, HEAD, POST");
                response.set("Access-Control-Allow-Headers", "Content-Type, X-Lab-Header");
            }
            noContent(exchange);
            return;
        }
        // Không có credentials/session; Origin ngoài allowlist vẫn nhận HTTP response,
        // nhưng browser không cho JavaScript đọc response nếu thiếu CORS headers.
        json(exchange, 200, "{\"message\":\"CORS lab\"}");
    }

    private static String quote(String value) {
        if (value == null) return "null";
        StringBuilder result = new StringBuilder("\"");
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            switch (ch) {
                case '"' -> result.append("\\\"");
                case '\\' -> result.append("\\\\");
                case '\n' -> result.append("\\n");
                case '\r' -> result.append("\\r");
                case '\t' -> result.append("\\t");
                default -> {
                    if (ch < 0x20) result.append(String.format("\\u%04x", (int) ch));
                    else result.append(ch);
                }
            }
        }
        return result.append('"').toString();
    }

    private static void error(HttpExchange exchange, int status, String code, String message) throws IOException {
        json(exchange, status, "{\"error\":{\"code\":" + quote(code) + ",\"message\":" + quote(message) + "}}");
    }

    private static void json(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        if (exchange.getRequestMethod().equals("HEAD")) {
            exchange.getResponseHeaders().set("Content-Length", String.valueOf(bytes.length));
            exchange.sendResponseHeaders(status, -1);
        } else {
            exchange.sendResponseHeaders(status, bytes.length);
            exchange.getResponseBody().write(bytes);
        }
    }

    private static void noContent(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        exchange.sendResponseHeaders(204, -1);
    }
}
