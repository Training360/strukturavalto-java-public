package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine())  != null) {
            String[] parts = line.split("=");
            String county = parts[0];
            Integer count = Integer.parseInt(parts[1]);
            owls.put(county, count);
        }
//        System.out.println(owls);
    }

    public int getNumberOfOwls(String county) {
        return owls.get(county);
    }
}
