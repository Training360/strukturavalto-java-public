package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString) {
        Path path = Path.of(pathString);
        try {
            Files.write(path, temperatures.getData());
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write file", e);
        }
    }
}
