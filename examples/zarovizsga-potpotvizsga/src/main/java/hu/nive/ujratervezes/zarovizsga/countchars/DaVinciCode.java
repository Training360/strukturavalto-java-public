package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DaVinciCode {
    public int encode(String path, char charToFind) {

        if (!List.of('0', '1', 'x').contains(charToFind)) {
            throw new IllegalArgumentException("Invalid char");
        }

        try (Stream<String> lines = Files.lines(Path.of(path))) {
            return (int) lines
                    .flatMapToInt(s -> s.chars())
                    .filter(i -> (char) i == charToFind)
                    .count();
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}
