import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

/** Phục vụ đúng một trang test để browser có origin riêng. */
public class CorsClientServer {
    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 3000;
        if (port < 1 || port > 65535) throw new IllegalArgumentException("Port phải trong 1..65535");
        Path page = Path.of(args.length > 1 ? args[1] : "lab-server/cors-demo.html");
        byte[] html = Files.readAllBytes(page);
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", port), 0);
        server.createContext("/", exchange -> {
            try {
                String method = exchange.getRequestMethod();
                if (!method.equals("GET") && !method.equals("HEAD")) {
                    exchange.getResponseHeaders().set("Allow", "GET, HEAD");
                    exchange.sendResponseHeaders(405, -1);
                } else if (!exchange.getRequestURI().getPath().equals("/")) {
                    exchange.sendResponseHeaders(404, -1);
                } else {
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
                    exchange.getResponseHeaders().set("Cache-Control", "no-store");
                    if (method.equals("HEAD")) {
                        exchange.getResponseHeaders().set("Content-Length", String.valueOf(html.length));
                        exchange.sendResponseHeaders(200, -1);
                    } else {
                        exchange.sendResponseHeaders(200, html.length);
                        exchange.getResponseBody().write(html);
                    }
                }
            } finally { exchange.close(); }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));
        server.start();
        System.out.println("CORS browser demo: http://localhost:" + port + " (Ctrl+C to stop)");
    }
}
