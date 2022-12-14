import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Authenticator;
import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        HttpClient httpClient =HttpClient.newHttpClient();
        Path path = Path.of("/Users/henokkeraga/Documents/project-2023/project-2023/simple-java/net/src/main/resources/app1.json");

        try(var bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);) {


            //bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
