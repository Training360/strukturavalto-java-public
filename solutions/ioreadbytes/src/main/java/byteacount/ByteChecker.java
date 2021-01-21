package byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName) {
        Path path = Path.of(fileName);
        int sumOfA = 0;
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    if (buffer[i] == (byte)'a') {
                        sumOfA++;
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't find file!", e);
        }
        return sumOfA;
    }
}
