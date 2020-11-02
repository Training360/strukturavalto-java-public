package temperatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TemperaturesReaderTest {


    @TempDir
    public File folder;

    private byte[] data = new byte[365];
    private String pathString;

    @BeforeEach
    public void init() throws IOException {
        Random random = new Random(5);
        random.nextBytes(data);
        Path path = new File(folder, "temperatures2019.dat").toPath();
        pathString = path.toString();

        Files.write(path, data);
    }

    @Test
    public void testReadTemperatures() {
        TemperaturesReader reader = new TemperaturesReader();

        Temperatures temperatures = reader.readTemperatures(pathString);

        assertArrayEquals(data, temperatures.getData());
    }
}
