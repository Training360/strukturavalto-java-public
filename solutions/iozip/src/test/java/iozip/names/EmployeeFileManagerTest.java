package iozip.names;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.assertArrayEquals;

public class EmployeeFileManagerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testSaveEmployees() throws IOException {
        List<String> employees = List.of("John Doe", "Jack Doe", "Jane Doe");
        Path path = folder.newFile("employees.zip").toPath();

        EmployeeFileManager manager = new EmployeeFileManager();

        manager.saveEmployees(path, employees);

        byte[] saved = readEmployees(path);
        byte[] asserted = "John DoeJack DoeJane Doe".getBytes();

        assertArrayEquals(asserted, saved);
    }

    private byte[] readEmployees(Path path) throws IOException {
        try (ZipFile zf = new ZipFile(path.toFile())) {
            ZipEntry ze = zf.getEntry("names.dat");
            try (InputStream is = zf.getInputStream(ze)) {
                return is.readAllBytes();
            }
        }
    }
}
