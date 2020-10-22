package thirdparty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WordCounterMainTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayOutputStream err = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldPrintResult() {
        WordCounterMain.main(new String[]{});
        assertThat(out.toString().trim(), equalTo("0"));

        out.reset();

        WordCounterMain.main(new String[]{"foo"});
        assertThat(out.toString().trim(), equalTo("1"));

        out.reset();

        WordCounterMain.main(new String[]{"foo bar"});
        assertThat(out.toString().trim(), equalTo("2"));
    }

}
