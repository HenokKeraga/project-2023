import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

public class HttpClientMain {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
      //  var uri = HttpClientMain.class.getResource("./app.json").toURI();

         Path path = Path.of("/Users/henokkeraga/Documents/project-2023/project-2023/simple-java/net/src/main/resources/app.json");
        // Path path = Path.of("net/src/main/resources/app.json");
       // Path path = Path.of("simple-java/net/src/main/resources/app.json");

        System.out.println(   path.relativize(path));

        System.out.println("::: "+Files.readAllLines(path));


        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
//                .uri(URI.create("http://localhost:8090/demo"))
//                .header("Authorization", basicAuth("henok","12345"))
                .build();


        var httpResponse = httpClient
                .send(request, HttpResponse.BodyHandlers.ofFile(path.toAbsolutePath(),StandardOpenOption.CREATE,StandardOpenOption.WRITE));
        System.out.println(httpResponse.statusCode());
//        System.out.println(httpResponse.body());
//        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofFile(path, StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE))
//                .thenApply(HttpResponse::body).thenAccept(System.out::println)
//                .exceptionally(throwable -> {
//                    throw new RuntimeException(" do not get data ");
//                }).join();


    }
    private static String basicAuth(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
