package controlselection.week;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayOfWeeksTest {


    @Test
    public void testWhichDay() {
        assertEquals("hét eleje", new DayOfWeeks().whichDay("hétfő"));
        assertEquals("hét közepe", new DayOfWeeks().whichDay("szerda"));
        assertEquals("majdnem hétvége", new DayOfWeeks().whichDay("péntek"));
        assertEquals("hét vége", new DayOfWeeks().whichDay("vasárnap"));
    }

    @Test
    public void testCase() {
        assertEquals("hét eleje", new DayOfWeeks().whichDay("hÉtfŐ"));
    }

    @Test
    public void testIllegalDay() {


        assertThrows(IllegalArgumentException.class, () -> new DayOfWeeks().whichDay("abc"));
    }
}
