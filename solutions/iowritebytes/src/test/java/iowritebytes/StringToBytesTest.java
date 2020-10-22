package iowritebytes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class StringToBytesTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testWriteAsBytes() throws IOException {
        List<String> words = List.of("John", "_notes", "_Does not matter", "Jack", "Jane");
        Path path = folder.newFile("words.dat").toPath();
        StringToBytes stringToBytes = new StringToBytes();

        stringToBytes.writeAsBytes(words, path);

        byte[] bytes = readBytes(path);
        byte[] content = "JohnJackJane".getBytes();

        assertArrayEquals(content, bytes);
    }

    private byte[] readBytes(Path path) throws IOException {
        return Files.readAllBytes(path);
    }
}
