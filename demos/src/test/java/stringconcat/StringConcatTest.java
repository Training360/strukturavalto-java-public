package stringconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConcatTest {

    @Test
    public void testConcat() {
        String s = "John";
        // s = s.concat(" Doe");
        s = s + " Doe";
        assertEquals("John Doe", s);

        assertEquals("value12", "value" + 1 + 2);
        assertEquals("3value", 1 + 2 + "value");

        int i = 8;
        String t = Integer.toString(i);
        assertEquals("8", t);
    }
}
