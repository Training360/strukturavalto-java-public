package formatlocaleprintf;

import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrintfTest {

    @Test
    public void testPrintf() {
        String s = String.format("Hello %s and %s!", "Jack", "Joe");
        assertThat(s, equalTo("Hello Jack and Joe!"));

        String s1 = String.format("The value is %d", 500);
        assertThat(s1, equalTo("The value is 500"));

        String s2 = String.format(new Locale("hu", "HU"),
                "The value is %8.2f", 10_000.0 / 3);
        assertThat(s2, equalTo("The value is  3333,33"));
    }
}
