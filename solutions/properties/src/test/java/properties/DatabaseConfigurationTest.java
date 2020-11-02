package properties;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DatabaseConfigurationTest {

    @TempDir
    public File folder;

    @Test
    public void testFromResource() {
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        assertEquals("localhost", databaseConfiguration.getHost());
        assertEquals(1021, databaseConfiguration.getPort());
        assertEquals("árvíztűrő", databaseConfiguration.getSchema());
    }

    @Test
    public void testInvalid() {


        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DatabaseConfiguration(new File("/2351354154.properties")));
        assertEquals("Cannot read file", ex.getMessage());

    }

    @Test
    public void testExternalFile() throws IOException {
        File file = new File(folder, "test.txt");
        try (
                PrintWriter printWriter = new PrintWriter(file, "UTF-8");
        ) {
            printWriter.println("db.host = 192.168.10.20");
            printWriter.println("db.port = 1111");
            printWriter.println("db.schema = ütvefúrógép");
        }

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(file);
        assertEquals("192.168.10.20", databaseConfiguration.getHost());
        assertEquals(1111, databaseConfiguration.getPort());
        assertEquals("ütvefúrógép", databaseConfiguration.getSchema());
    }
}
