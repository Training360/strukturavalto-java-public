package stringbuilder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringBuilderTest {

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder("John");
        for (int i = 0; i < 3;i++) {
            sb.append(" Doe");
        }
        String s = sb.toString();
        assertThat(s, equalTo("John Doe Doe Doe"));

        sb.insert(1, "xxx");
        assertThat(sb.toString(), equalTo("Jxxxohn Doe Doe Doe"));

        sb.delete(1, 3);
        assertThat(sb.toString(), equalTo("Jxohn Doe Doe Doe"));

        assertThat(sb.reverse().toString(), equalTo("eoD eoD eoD nhoxJ"));

    }
}
