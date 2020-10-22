package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class UsedCars {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 4) {
                continue;
            }
            if (parts[0].length() != 7 || !parts[0].contains("-")) {
                continue;
            }
            int year = Integer.parseInt(parts[1]);
            if (year < 1970 || year > 2019) {
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }
}
