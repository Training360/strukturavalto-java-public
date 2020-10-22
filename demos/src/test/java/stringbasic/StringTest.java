package stringbasic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringTest {

    @Test
    public void testEquals() {
        String s = "John Doe";
        s = s.toUpperCase();
        assertThat(s, equalTo("JOHN DOE"));

        String u = new String("John Doe");
        String t = new String("John Doe");
        assertThat(u, equalTo(t));
    }
}
