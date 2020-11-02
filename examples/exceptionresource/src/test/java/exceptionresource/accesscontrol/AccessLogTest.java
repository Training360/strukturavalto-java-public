package exceptionresource.accesscontrol;


import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccessLogTest {


    @TempDir
    public File folder;
    private File file;

    private static final String SAMPLE_FILENAME = "sample.txt";
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


    @BeforeEach
    public void createFile() throws IOException {
        this.file = new File(folder, SAMPLE_FILENAME);
        Files.write(this.file.toPath(), Arrays.asList(lines));
    }

    @Test
    public void inAtTimeShouldThrowException() {
        AccessLog accessLog = new AccessLog("nofile");

        assertThrows(LogException.class, () ->
                accessLog.inAtTime(LocalDateTime.of(2010, 2, 25, 14, 0, 0)));
    }

    @Test
    public void inAtTime() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<String> expected = Collections.emptyList();
        assertEquals(expected, accessLog.inAtTime(LocalDateTime.of(2010, 2, 25, 11, 0, 0)));

        expected = Arrays.asList("id1", "id3", "id4");
        List<String> actual = accessLog.inAtTime(LocalDateTime.of(2010, 2, 25, 14, 10, 0));
        assertEquals(expected, actual);
    }

    @Test
    public void loginsByIdShouldThrowException() {
        AccessLog accessLog = new AccessLog("nofile");


        assertThrows(LogException.class, () -> accessLog.loginsById("id1"));
    }

    @Test
    public void loginsByIdShouldReturnEmptyList() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<LocalDateTime> expected = Collections.emptyList();

        assertEquals(expected, accessLog.loginsById("id0"));
    }

    @Test
    public void loginsById() {
        AccessLog accessLog = new AccessLog(this.file.getAbsolutePath());

        List<LocalDateTime> expected = new ArrayList<>();
        expected.add(LocalDateTime.of(2010, 2, 25, 12, 5, 0));
        expected.add(LocalDateTime.of(2010, 2, 25, 16, 0, 0));

        assertEquals(expected, accessLog.loginsById("id2"));
    }

}