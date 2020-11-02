package stringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBuilderTest {

    @Test
    public void testAppend() {
        StringBuilder sb = new StringBuilder("John");
        for (int i = 0; i < 3;i++) {
            sb.append(" Doe");
        }
        String s = sb.toString();
        assertEquals("John Doe Doe Doe", s);

        sb.insert(1, "xxx");
        assertEquals("Jxxxohn Doe Doe Doe", sb.toString());

        sb.delete(1, 3);
        assertEquals("Jxohn Doe Doe Doe", sb.toString());

        assertEquals("eoD eoD eoD nhoxJ", sb.reverse().toString());

    }
}
