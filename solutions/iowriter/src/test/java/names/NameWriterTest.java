package names;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NameWriterTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private NameWriter nameWriter;

    @Test
    public void testWrite() throws IOException {
        Path file = temporaryFolder.newFile().toPath();

        nameWriter = new NameWriter(file);
        nameWriter.addAndWrite("John Smith");

        List<String> actual = Files.readAllLines(file);

        assertEquals(List.of("John Smith"), actual);
    }

    @Test
    public void testAppend() throws IOException {
        Path file = temporaryFolder.newFile().toPath();

        nameWriter = new NameWriter(file);
        nameWriter.addAndWrite("John Smith");
        nameWriter.addAndWrite("John Doe");

        List<String> actual = Files.readAllLines(file);

        assertEquals(List.of("John Smith", "John Doe"), actual);
    }


}
