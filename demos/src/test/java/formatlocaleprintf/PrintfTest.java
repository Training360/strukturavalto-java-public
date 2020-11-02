package formatlocaleprintf;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintfTest {

    @Test
    public void testPrintf() {
        String s = String.format("Hello %s and %s!", "Jack", "Joe");
        assertEquals("Hello Jack and Joe!", s);

        String s1 = String.format("The value is %d", 500);
        assertEquals("The value is 500", s1);

        String s2 = String.format(new Locale("hu", "HU"),
                "The value is %8.2f", 10_000.0 / 3);
        assertEquals("The value is  3333,33", s2);
    }
}
