package school;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegisterTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Register register = new Register();

    @Test
    public void newMarkTestIfNotExists() throws IOException {
        Path file = temporaryFolder.newFile().toPath();
        register.newMark(file, 5);
        List<String> testList = Files.readAllLines(file);

        assertEquals(1, testList.size());
        assertEquals("5", testList.get(0));
    }

    @Test
    public void newMarkTestIfExists() throws IOException {
        Path file = temporaryFolder.newFile().toPath();
        register.newMark(file, 4);
        register.newMark(file, 2);


        register.newMark(file, 3);
        List<String> testList = Files.readAllLines(file);

        assertEquals(3, testList.size());
    }

    @Test
    public void averageTest() throws IOException {
        Path file = temporaryFolder.newFile().toPath();
        Files.writeString(file, "5\n");
        Files.writeString(file, "3\n", StandardOpenOption.APPEND);
        Files.writeString(file, "4\n", StandardOpenOption.APPEND);

        register.average(file);

        List<String> avgTestList = Files.readAllLines(file);
        assertEquals(4, avgTestList.size());
        assertEquals("average: 4.0", avgTestList.get(avgTestList.size() - 1));

    }

}
