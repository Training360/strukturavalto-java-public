package names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NameWriter {

    private Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            bw.write(name + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file!", e);
        }
    }

}
