package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    private static final String SOURCE_DIRECTORY = "/install/";
    ;

    public void install(String pathString) {
        Path target = Path.of(pathString);
        if (!Files.exists(target) || !Files.isDirectory(target)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/install/install.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(target.resolve(line));
                } else {
                    Files.copy(this.getClass().getResourceAsStream(SOURCE_DIRECTORY + line), target.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot copy files.", ioe);
        }
    }
}
