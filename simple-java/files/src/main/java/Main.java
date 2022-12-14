import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
//        var aDefault = FileSystems.getDefault().supportedFileAttributeViews();
//
//        System.out.println(aDefault);
//
        // var uri = Main.class.getResource("/lyrics.txt").toURI();
        var url = Main.class.getResource("/lyrics.txt");
        // var p = "classpath:lyrics.txt";
        var path1 = Paths.get(url.toURI());
//        System.out.println(path1.getFileName());
//        System.out.println(Files.size(path1));
//        System.out.println(Files.size(path1));

        var lines = Files.readAllLines(path1);
        System.out.println(lines.size());
        lines.stream().forEach(System.out::println);

        var lines1 = Files.lines(path1);


        Files.newBufferedReader(path1).lines().forEach(Logger.getGlobal()::info);
//        var outputStream = Files.newOutputStream(Paths.get("simple-java/files/src/main/resources/ly.txt"));
//        Files.copy(path1,outputStream);

        Logger.getGlobal().info("");


    }
}
