package properties;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PropertiesTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testProperties() {
        Properties p = new Properties();
        p.setProperty("host", "training360.com");

        assertThat(p.getProperty("host"), equalTo("training360.com"));
        assertThat(p.getProperty("port"), equalTo(null));
        assertThat(p.getProperty("port", "80"), equalTo("80"));
    }

    @Test
    public void testSaveThenLoad() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("host", "training360.com");
        properties.setProperty("port", "80");

        Path file = folder.newFile("config.properties").toPath();
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
        assertThat(value, equalTo("training360.com"));
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
        assertThat(value, equalTo("Hello World!"));
    }
}
