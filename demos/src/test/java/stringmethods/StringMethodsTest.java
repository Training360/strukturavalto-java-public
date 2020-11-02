package stringmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringMethodsTest {

    @Test
    public void testStringMethods() {
        assertEquals(4, "John".length());
        assertEquals(0, "".length());

        assertEquals('o', "John".charAt(1));
        assertEquals(1, "John".indexOf('o'));

        assertEquals("hn", "John".substring(2));
        assertEquals("o", "John".substring(1, 2));
        assertEquals("oh", "John".substring(1, 3));

        assertEquals("JOHN", "John".toUpperCase());
        assertEquals("john", "John".toLowerCase());

        assertTrue("John".equals("John"));
        assertFalse("JOhn".equals("John"));
        assertTrue("JOhn".equalsIgnoreCase("John"));

        assertTrue("John".startsWith("Jo"));
        assertTrue("John".endsWith("n"));

        assertTrue("John".contains("oh"));
        assertFalse("John".contains("ho"));

        assertEquals("Jxhn", "John".replace("o", "x"));
        assertEquals("Jn", "John".replace("oh", ""));

        assertEquals("John Doe", "   John Doe    ".trim());

        assertArrayEquals(new String[]{"Mr.", "John", "Doe"}, "Mr. John Doe".split(" "));

        assertEquals("HN DOE", "   John Doe   ".trim().toUpperCase().substring(2));

    }
}
