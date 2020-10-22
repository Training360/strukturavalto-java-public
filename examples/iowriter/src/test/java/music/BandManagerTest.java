package music;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BandManagerTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private BandManager bandManager = new BandManager();

    @Test
    public void createOlderThanFile() throws IOException {
        Path inputFile = temporaryFolder.newFile().toPath();
        Files.copy(BandManagerTest.class.getResourceAsStream("bands_and_years.txt"), inputFile, StandardCopyOption.REPLACE_EXISTING);
        bandManager.readBandsFromFile(inputFile);

        Path outputFile = temporaryFolder.newFile().toPath();
        bandManager.writeBandsBefore(outputFile, 1990);

        List<String> lines = Files.readAllLines(outputFile);

        assertEquals(5, lines.size());
    }

}
