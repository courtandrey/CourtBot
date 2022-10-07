package courtandrey.courtbot.core.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ResourceRetriever {
    private static final String PATH_TO_RESOURCES = "./src/main/resources/";
    public static String retrieve(String resource) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(PATH_TO_RESOURCES + resource))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
