package thirdparty;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCounterMainTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayOutputStream err = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldPrintResult() {
        WordCounterMain.main(new String[]{});
        assertEquals("0", out.toString().trim());

        out.reset();

        WordCounterMain.main(new String[]{"foo"});
        assertEquals("1", out.toString().trim());

        out.reset();

        WordCounterMain.main(new String[]{"foo bar"});
        assertEquals("2", out.toString().trim());
    }

}
