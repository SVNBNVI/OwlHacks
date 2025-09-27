import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class OwlHacksP {
    public static void main(String[] args) throws IOException {
        // Start server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create API endpoint at /hello
        server.createContext("/hello", (HttpExchange exchange) -> {
            String response = "Hello from Java backend 👋";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        // Start server
        server.start();
        System.out.println("Server running at http://localhost:8080/hello");
    }
  }

