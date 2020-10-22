package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] imageParts, Path folder) {
        Path file = folder.resolve("image.png");
        try (BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] onePart : imageParts) {
                os.write(onePart);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }
}
