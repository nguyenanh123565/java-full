import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HealthServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8081), 0);
        server.createContext("/", exchange -> {
            int status;
            String body;
            if (!exchange.getRequestURI().getPath().equals("/health")) {
                status = 404; body = "{\"error\":\"not found\"}";
            } else if (!exchange.getRequestMethod().equals("GET")) {
                status = 405; body = "{\"error\":\"method not allowed\"}";
                exchange.getResponseHeaders().set("Allow", "GET");
            } else {
                status = 200; body = "{\"status\":\"ok\"}";
            }
            byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
            exchange.sendResponseHeaders(status, bytes.length);
            try (var out = exchange.getResponseBody()) { out.write(bytes); }
            finally { exchange.close(); }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));
        server.start();
        System.out.println("http://localhost:8081/health — Ctrl+C to stop");
    }
}
