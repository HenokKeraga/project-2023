import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class BasicHttpServerExample {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer
                .create(new InetSocketAddress(8500), 0);

        HttpContext context = server.createContext("/");
        context.setHandler(BasicHttpServerExample::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        Path path = Path.of("/Users/henokkeraga/Documents/project-2023/project-2023/simple-java/net/src/main/resources/app.json");

        var bytes = Files.readAllBytes(path);

        exchange.sendResponseHeaders(200, bytes.length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}
