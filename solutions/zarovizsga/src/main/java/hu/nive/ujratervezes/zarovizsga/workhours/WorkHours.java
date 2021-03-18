package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class WorkHours {
//    public String minWork(String path) {
//        try {
//            List<String> lines = Files.readAllLines(Path.of(path));
//
//            return findMin(lines);
//        } catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file", ioe);
//        }
//    }
//
//    private String findMin(List<String> lines) {
//        int minHours = 25;
//        String result = null;
//        for (String line: lines) {
//            String[] parts = line.split(",");
//            String name = parts[0];
//            int hours = Integer.parseInt(parts[1]);
//            String date = parts[2];
//
//            if (minHours > hours) {
//                minHours = hours;
//                result = name + ": " + date;
//            }
//        }
//        return result;
//    }

    public String minWork(String path) {
        try (Stream<String> lines = Files.lines(Path.of(path)))
        {
            WorkHour minWorkHour = lines
                    .map(WorkHour::parseLine)
                    .min(Comparator.comparing(WorkHour::getHours))
                    .orElseThrow(() -> new IllegalArgumentException("Empty file"));
            return minWorkHour.toExpectedString();
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read lines", ioe);
        }
    }
}
