package iowritebytes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ImageAssemblerTest {

    @TempDir
    public File folder;

    @Test
    public void testMakeImageFile() throws IOException {
        ImageAssembler imageAssembler = new ImageAssembler();

        byte[][] source = readImage();
        Path path = folder.toPath();

        imageAssembler.makeImageFile(source, path);

        byte[] original2 = this.getClass().getResourceAsStream("/face_smile.png").readAllBytes();
        byte[] madeImage = Files.readAllBytes(path.resolve("image.png"));

        assertArrayEquals(original2, madeImage);
    }

    private byte[][] readImage() {
        try (BufferedInputStream is = new BufferedInputStream(this.getClass().getResourceAsStream("/face_smile.png"))) {
            ArrayList<byte[]> parts = new ArrayList<>();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                parts.add(Arrays.copyOf(buffer, length));
            }
            return parts.toArray(new byte[0][]);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot find source file., e");
        }
    }
}
