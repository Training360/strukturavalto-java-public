package iofiles;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class InstallerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testInstall() {
        String targetDirectory = folder.getRoot().getPath();

        Installer installer = new Installer();

        installer.install(targetDirectory);

        Path targetPath = folder.getRoot().toPath();

        assertTrue(Files.exists(targetPath.resolve("bin")));
        assertTrue(Files.exists(targetPath.resolve("data")));
        assertTrue(Files.exists(targetPath.resolve("bin/binfile.txt")));
        assertTrue(Files.exists(targetPath.resolve("data/data1.dat")));
        assertTrue(Files.exists(targetPath.resolve("data/data2.dat")));
    }

    @Test
    public void testInstallWithFileTarget() throws IOException {
        String target = folder.newFile().getPath();

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The given directory doesn't exist");

        new Installer().install(target);
    }
}
