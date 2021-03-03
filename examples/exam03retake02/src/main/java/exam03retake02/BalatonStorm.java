package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public static final String LEVEL_PREFIX = "level";
    public static final String STATION_PREFIX = "allomas";

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> stations = new ArrayList<>();
        String line;
        String station = null;
        while ((line = reader.readLine()) != null) {
            if (isStation(line)) {
                station = extractStationName(line);
            }
            if (isStorm(line)) {
                stations.add(station);
            }
        }
        //Collections.sort(stations, Collator.getInstance(new Locale("hu", "HU")));
        stations.sort(Collator.getInstance(new Locale("hu", "HU")));
        return stations;
    }

    private boolean isStation(String line) {
        return line.contains(STATION_PREFIX);
    }

    private boolean isStorm(String line) {
        if (!line.contains(LEVEL_PREFIX)) {
            return false;
        }
        String part = line.substring(line.indexOf(": ") + 2, line.lastIndexOf(","));
        int level = Integer.parseInt(part);
        return level >= 3;
    }

    private String extractStationName(String line) {
        return line.substring(line.indexOf(": \"") + 3, line.lastIndexOf("\""));
    }

    public static void main(String[] args) {
        System.out.println(new BalatonStorm().extractStationName("\"allomas\": \"Balatonfüred\","));
    }
}
