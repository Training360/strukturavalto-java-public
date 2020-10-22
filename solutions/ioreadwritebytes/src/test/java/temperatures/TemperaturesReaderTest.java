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

public class TemperaturesReaderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private byte[] data = new byte[365];
    private String pathString;

    @Before
    public void init() throws IOException {
        Random random = new Random(5);
        random.nextBytes(data);
        Path path = folder.newFile("temperatures2019.dat").toPath();
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
