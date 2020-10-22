package exceptionresource.accesscontrol;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccessLogTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    private static final String SAMPLE_FILENAME="sample.txt";
    private static final String[] lines = {
        "2010.02.25. 12:00:00,id1,IN",
        "2010.02.25. 12:05:00,id2,IN",
        "2010.02.25. 12:06:00,id3,IN",
        "2010.02.25. 14:05:00,id2,OUT",
        "2010.02.25. 14:06:00,id4,IN",
        "2010.02.25. 15:00:00,id1,OUT",
        "2010.02.25. 16:00:00,id2,IN",
        "2010.02.25. 16:50:00,id2,OUT"
    };

    private File file;

    @Before
    public void createFile() throws IOException {
        this.file = folder.newFile(SAMPLE_FILENAME);
        Files.write(this.file.toPath(), Arrays.asList(lines));
    }

    @Test
    public void inAtTimeShouldThrowException() {
        AccessLog accessLog = new AccessLog("nofile");

        exception.expect(LogException.class);

        accessLog.inAtTime(LocalDateTime.of(2010,2,25,14,0,0));
    }

    @Test
    public void inAtTime() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<String> expected = Collections.emptyList();
        assertThat(accessLog.inAtTime(LocalDateTime.of(2010, 2, 25, 11, 0, 0)), equalTo(expected));

        expected = Arrays.asList("id1", "id3", "id4");
        List<String> actual = accessLog.inAtTime(LocalDateTime.of(2010, 2, 25, 14, 10, 0));
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void loginsByIdShouldThrowException() {
        AccessLog accessLog = new AccessLog("nofile");

        exception.expect(LogException.class);

        accessLog.loginsById("id1");
    }

    @Test
    public void loginsByIdShouldReturnEmptyList() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<LocalDateTime> expected = Collections.emptyList();

        assertThat(accessLog.loginsById("id0"), equalTo(expected));
    }

    @Test
    public void loginsById() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<LocalDateTime> expected = new ArrayList<>();
        expected.add(LocalDateTime.of(2010,2,25,12,5,0));
        expected.add(LocalDateTime.of(2010,2,25,16,0,0));

        assertThat(accessLog.loginsById("id2"), equalTo(expected));
    }

}