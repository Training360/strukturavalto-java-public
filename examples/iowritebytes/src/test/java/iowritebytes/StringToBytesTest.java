package iowritebytes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class StringToBytesTest {

    @TempDir
    public File folder;

    @Test
    public void testWriteAsBytes() throws IOException {
        List<String> words = List.of("John", "_notes", "_Does not matter", "Jack", "Jane");
        Path path = new File(folder, "word.dat").toPath();
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
