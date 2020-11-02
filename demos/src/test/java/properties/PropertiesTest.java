package properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PropertiesTest {

    @TempDir
    Path tempDir;

    @Test
    public void testProperties() {
        Properties p = new Properties();
        p.setProperty("host", "training360.com");

        assertEquals("training360.com", p.getProperty("host"));
        assertNull(p.getProperty("port"));
        assertEquals("80", p.getProperty("port", "80"));
    }

    @Test
    public void testSaveThenLoad() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("host", "training360.com");
        properties.setProperty("port", "80");

        Path file = Files.createFile(tempDir.resolve("config.properties"));
        try (Writer writer = Files.newBufferedWriter(file)){
            properties.store(writer, null);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot save file", ioe);
        }

        try (Reader reader = Files.newBufferedReader(file)) {
            properties.load(reader);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }

        String value = properties.getProperty("host");
        assertEquals("training360.com", value);
    }

    @Test
    public void testLoad() {
        Properties p = new Properties();
        try (InputStream is = PropertiesTest.class.getResourceAsStream("/welcome.properties")) {
            p.load(is);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }

        String value = p.getProperty("welcome.message");
        assertEquals("Hello World!", value);
    }
}
