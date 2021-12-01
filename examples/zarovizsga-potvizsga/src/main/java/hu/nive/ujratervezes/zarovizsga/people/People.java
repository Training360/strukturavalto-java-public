package hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class People {

    public int getNumberOfMales(String path) {
        try (Stream<String> lines = Files.lines(Path.of(path)))
        {
            return (int) lines
                    .map(People::getGender)
                    .skip(1)
                    .filter(s -> s.equals("Male"))
                    .count();
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read lines", ioe);
        }
    }

    private static String getGender(String s) {
        return s.split(",")[4];
    }
}
