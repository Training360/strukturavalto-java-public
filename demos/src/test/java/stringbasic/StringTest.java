package stringbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    public void testEquals() {
        String s = "John Doe";
        s = s.toUpperCase();
        assertEquals("JOHN DOE", s);

        String u = new String("John Doe");
        String t = new String("John Doe");
        assertEquals(t, u);
    }
}
