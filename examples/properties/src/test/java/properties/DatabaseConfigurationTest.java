package properties;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DatabaseConfigurationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testFromResource() {
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
        assertThat(databaseConfiguration.getHost(), equalTo("localhost"));
        assertThat(databaseConfiguration.getPort(), equalTo(1021));
        assertThat(databaseConfiguration.getSchema(), equalTo("árvíztűrő"));
    }

    @Test
    public void testInvalid() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Cannot read file");

        new DatabaseConfiguration(new File("/2351354154.properties"));
    }

    @Test
    public void testExternalFile() throws IOException {
        File file = temporaryFolder.newFile();
        try (
                PrintWriter printWriter = new PrintWriter(file, "UTF-8");
                ) {
            printWriter.println("db.host = 192.168.10.20");
            printWriter.println("db.port = 1111");
            printWriter.println("db.schema = ütvefúrógép");
        }

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(file);
        assertThat(databaseConfiguration.getHost(), equalTo("192.168.10.20"));
        assertThat(databaseConfiguration.getPort(), equalTo(1111));
        assertThat(databaseConfiguration.getSchema(), equalTo("ütvefúrógép"));
    }
}
