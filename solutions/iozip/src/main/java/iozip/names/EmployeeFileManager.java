package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path path, List<String> employees) {
        try (ZipOutputStream os = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            os.putNextEntry(new ZipEntry("names.dat"));
            for (String name : employees) {
                os.write(name.getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write zip file.", e);
        }
    }
}
