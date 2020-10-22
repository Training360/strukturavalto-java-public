package stringmethods;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StringMethodsTest {

    @Test
    public void testStringMethods() {
        assertThat("John".length(), equalTo(4));
        assertThat("".length(), equalTo(0));

        assertThat("John".charAt(1), equalTo('o'));
        assertThat("John".indexOf('o'), equalTo(1));

        assertThat("John".substring(2), equalTo("hn"));
        assertThat("John".substring(1, 2), equalTo("o"));
        assertThat("John".substring(1, 3), equalTo("oh"));

        assertThat("John".toUpperCase(), equalTo("JOHN"));
        assertThat("John".toLowerCase(), equalTo("john"));

        assertThat("John".equals("John"), equalTo(true));
        assertThat("JOhn".equals("John"), equalTo(false));
        assertThat("JOhn".equalsIgnoreCase("John"), equalTo(true));

        assertThat("John".startsWith("Jo"), equalTo(true));
        assertThat("John".endsWith("n"), equalTo(true));

        assertThat("John".contains("oh"), equalTo(true));
        assertThat("John".contains("ho"), equalTo(false));

        assertThat("John".replace("o", "x"), equalTo("Jxhn"));
        assertThat("John".replace("oh", ""), equalTo("Jn"));

        assertThat("   John Doe    ".trim(), equalTo("John Doe"));

        assertThat("Mr. John Doe".split(" "), equalTo(new String[]{"Mr.", "John", "Doe"}));

        assertThat("   John Doe   ".trim().toUpperCase().substring(2), equalTo("HN DOE"));

    }
}
