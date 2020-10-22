package controlselection.month;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DayInMonthTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNumberOfDays() {
        assertThat(new DayInMonth().numberOfDays(2017, "május"), equalTo(31));
        assertThat(new DayInMonth().numberOfDays(2017, "június"), equalTo(30));
        assertThat(new DayInMonth().numberOfDays(2017, "február"), equalTo(28));
        assertThat(new DayInMonth().numberOfDays(1900,"február"),equalTo(28));
    }

    @Test
    public void testCase() {
        assertThat(new DayInMonth().numberOfDays(2017, "MáJuS"), equalTo(31));
    }

    @Test
    public void testLeapYear() {
        assertThat(new DayInMonth().numberOfDays(2012, "február"), equalTo(29));
    }

    @Test
    public void testIllegalMonth() {
        expectedException.expect(IllegalArgumentException.class);
        new DayInMonth().numberOfDays(2012, "abc");
    }
}
