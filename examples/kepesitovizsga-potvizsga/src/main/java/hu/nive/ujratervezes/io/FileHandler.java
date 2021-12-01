package hu.nive.ujratervezes.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileHandler {

    public int sumIgnoreComments(String path) {
        try (Stream<String> lines = Files.lines(Path.of(path))) {
            return lines.filter(s -> !s.startsWith("//"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }

    }

}
