package hu.nive.ujratervezes.longestword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord {

  public String findLongestWord(String filename) {
    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get(filename));
    } catch (IOException ioException) {
      return "";
    }

    List<String> words = new ArrayList<>();
    for (String line : lines) {
      words.addAll(Arrays.asList(line.split(" ")));
    }

    return words.stream()
        .max(Comparator.comparingInt(String::length))
        .orElseGet(() -> "");
  }
}
