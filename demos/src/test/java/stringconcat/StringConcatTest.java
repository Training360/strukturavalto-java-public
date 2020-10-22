package stringconcat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringConcatTest {

    @Test
    public void testConcat() {
        String s = "John";
        // s = s.concat(" Doe");
        s = s + " Doe";
        assertThat(s, equalTo("John Doe"));

        assertThat("value" + 1 + 2, equalTo("value12"));
        assertThat(1 + 2 + "value", equalTo("3value"));

        int i = 8;
        String t = Integer.toString(i);
        assertThat(t, equalTo("8"));
    }
}
