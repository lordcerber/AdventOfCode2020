package adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdventureHelper {

    public static List<String> getFileByLines(String filename) {
        List<String> result = null;
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }
}
