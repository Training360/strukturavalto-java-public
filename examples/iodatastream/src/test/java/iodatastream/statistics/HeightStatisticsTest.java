package iodatastream.statistics;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class HeightStatisticsTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testSaveHeights() throws IOException {
        Path path = folder.newFile().toPath();
        HeightStatistics statistics = new HeightStatistics();

        List<Integer> heights = List.of(198, 201, 211, 195, 214, 208, 203, 198);
        statistics.saveHeights(heights, path);

        byte[] original = this.getClass().getResourceAsStream("/statistics.dat").readAllBytes();
        byte[] saved = Files.readAllBytes(path);

        assertArrayEquals(original, saved);
    }
}
