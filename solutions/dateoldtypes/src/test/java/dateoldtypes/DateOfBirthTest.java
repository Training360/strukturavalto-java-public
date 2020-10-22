package dateoldtypes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateOfBirthTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void illegalMonthOrDayShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        // When
        new DateOfBirth(2016, 12, 42);
    }

    @Test
    public void illegalDateStringShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal date string");
        // When
        new DateOfBirth("", "yyyy-MM-dd");
    }

    @Test
    public void illegalPatternStringShouldThrowException() throws IllegalArgumentException {
        // Given
        String pattern = "yyyy-MM-dd";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal pattern string");
        // When
        new DateOfBirth("1987-10-17", "");
    }

    @Test
    public void nullLocaleShouldThrowException() throws NullPointerException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null!");
        // When
        new DateOfBirth("1987-10-17", "yyyy-MM-dd", null);
    }

    @Test
    public void nullLocaleShouldThrowExceptionInDayOfWeekForBirthDateMethod() throws NullPointerException {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null!");
        // When
        new DateOfBirth("1987-10-17", "yyyy-MM-dd", new Locale("hu", "HU")).findDayOfWeekForBirthDate(null);
    }

    @Test
    public void testFindDayOfWeekForBirthDate() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertThat(dateOfBirth.findDayOfWeekForBirthDate(new Locale("hu", "HU")), equalTo("szombat"));
    }

    @Test
    public void illegalPatternStringShouldThrowExceptionInToStringMethod() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal pattern string");
        // When
        new DateOfBirth("1987-10-17", "yyyy-MM-dd", new Locale("hu", "HU")).toString("");
    }

    @Test
    public void testToString() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertThat(dateOfBirth.toString("yyyy-MM-dd"), equalTo("1987-10-17"));
    }

    @Test
    public void testIsWeekDay() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertThat(dateOfBirth.isWeekDay(), is(false));
    }
}
