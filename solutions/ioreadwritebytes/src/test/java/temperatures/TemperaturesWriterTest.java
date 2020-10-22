package temperatures;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class TemperaturesWriterTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private byte[] data = new byte[365];
    private Temperatures temperatures;

    @Before
    public void init() {
        Random random = new Random(5);
        random.nextBytes(data);
        temperatures = new Temperatures(data);
    }

    @Test
    public void testWriteTemperatures() throws IOException {
        String pathString = Path.of(folder.newFolder().toString(), "temp.dat").toString();
        TemperaturesWriter writer = new TemperaturesWriter();

        writer.writeTemperatures(temperatures, pathString);

        assertTrue(Files.exists(Path.of(pathString)));

        byte[] bytesInFile = Files.readAllBytes(Path.of(pathString));
        assertArrayEquals(data, bytesInFile);
    }
}
