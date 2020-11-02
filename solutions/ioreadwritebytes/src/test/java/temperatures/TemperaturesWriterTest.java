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
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TemperaturesWriterTest {


    @TempDir
    public File folder;

    private byte[] data = new byte[365];
    private Temperatures temperatures;

    @BeforeEach
    public void init() {
        Random random = new Random(5);
        random.nextBytes(data);
        temperatures = new Temperatures(data);
    }

    @Test
    public void testWriteTemperatures() throws IOException {
        String pathString = Path.of(folder.toString(), "temp.dat").toString();
        TemperaturesWriter writer = new TemperaturesWriter();

        writer.writeTemperatures(temperatures, pathString);

        assertTrue(Files.exists(Path.of(pathString)));

        byte[] bytesInFile = Files.readAllBytes(Path.of(pathString));
        assertArrayEquals(data, bytesInFile);
    }
}
