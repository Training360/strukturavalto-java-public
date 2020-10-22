package talentshow;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultCalculatorTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private ResultCalculator rc = new ResultCalculator();

    private Path talentsFile;

    private Path votesFile;

    @Before
    public void initFiles() throws IOException {
        talentsFile = temporaryFolder.newFile().toPath();
        Files.copy(ResultCalculatorTest.class.getResourceAsStream("talents.txt"), talentsFile, StandardCopyOption.REPLACE_EXISTING);

        votesFile = temporaryFolder.newFile().toPath();
        Files.copy(ResultCalculatorTest.class.getResourceAsStream("votes.txt"), votesFile, StandardCopyOption.REPLACE_EXISTING);

    }

    @Test
    public void readProductionsTest() {
        rc.readTalents(talentsFile);

        assertEquals(12, rc.getProductions().size());
        assertEquals(6, rc.getProductions().get(5).getId());
        assertEquals("Magician", rc.getProductions().get(5).getName());
    }


    @Test
    public void calculateVotesTest() {
        rc.readTalents(talentsFile);
        rc.calculateVotes(votesFile);
        int testNum = 0;

        for (Vote v : rc.getVotes()) {
            if (v.getId() == 10) {
                testNum = v.getNumber();
            }
        }

        assertEquals(4, testNum);
    }


    @Test
    public void writeResultToFileTest() throws IOException {
        rc.readTalents(talentsFile);
        rc.calculateVotes(votesFile);

        Path resultFile = temporaryFolder.newFile().toPath();

        rc.writeResultToFile(resultFile);
        List<String> results = Files.readAllLines(resultFile);
        assertTrue(results.contains("9 Singer 6"));

        assertEquals("Winner: Actors_From_Shadow", results.get(results.size() - 1));
    }
}
