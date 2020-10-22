package controlselection.week;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DayOfWeeksTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testWhichDay() {
        assertThat(new DayOfWeeks().whichDay("hétfő"), equalTo("hét eleje"));
        assertThat(new DayOfWeeks().whichDay("szerda"), equalTo("hét közepe"));
        assertThat(new DayOfWeeks().whichDay("péntek"), equalTo("majdnem hétvége"));
        assertThat(new DayOfWeeks().whichDay("vasárnap"), equalTo("hét vége"));
    }

    @Test
    public void testCase() {
        assertThat(new DayOfWeeks().whichDay("hÉtfŐ"), equalTo("hét eleje"));
    }

    @Test
    public void testIllegalDay() {
        expectedException.expect(IllegalArgumentException.class);
        new DayOfWeeks().whichDay("abc");
    }
}
