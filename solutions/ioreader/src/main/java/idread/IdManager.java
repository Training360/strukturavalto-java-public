package idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids = new ArrayList<>();


    public void readIdsFromFile(String fileName) {

        Path file = Path.of("src/main/resources/" + fileName);

        try (BufferedReader br = Files.newBufferedReader(file)) {

            String line;
            while ((line = br.readLine()) != null) {
                ids.add(line);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }

    }


    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}

