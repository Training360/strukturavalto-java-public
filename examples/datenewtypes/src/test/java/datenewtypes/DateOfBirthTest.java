package datenewtypes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DateOfBirthTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyPatternShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty pattern string");
        // When
        new DateOfBirth("1987-10-17", "", Locale.ENGLISH);
    }

    @Test
    public void emptyPatternWithoutLocaleShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty pattern string");
        // When
        new DateOfBirth("1987-10-17", "");
    }

    @Test
    public void nullParameterShouldThrowException() {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        new DateOfBirth("1987-10-17", "yyyy-MM-dd", null);
    }

    @Test
    public void testConstructor() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        //Then
        assertThat(dob.toString("yyyy-MM-dd"), equalTo("1987-10-17"));
    }

    @Test
    public void testFindDayOfWeekForBirthDate() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        //Then
        assertThat(dob.findDayOfWeekForBirthDate(Locale.ENGLISH), equalTo("Saturday"));
    }

    @Test
    public void testFindDayOfWeekForLaterBirthDate() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        LocalDate later = dob.getDateOfBirth().plusYears(2);
        //Then
        assertThat(dob.findDayOfWeekForBirthDate(Locale.ENGLISH, later), equalTo("Tuesday"));
    }

    @Test
    public void nullParameterShouldThrowExceptionInFindDayOfWeekMethod() {
        // Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        new DateOfBirth("1987-10-17", "yyyy-MM-dd", Locale.ENGLISH).findDayOfWeekForBirthDate(null);
    }

    @Test
    public void testCountDaysSinceBirth() {
        // Given
        DateOfBirth dob = new DateOfBirth(2000, 1, 1);
        LocalDate now = LocalDate.of(2017, 10, 2);
        //Then
        assertThat(dob.countDaysSinceBirth(now), equalTo(6484));
    }

    @Test
    public void futureBirthDateShouldThrowException() {
        // Given
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Birthdate is in the future");
        // When
        new DateOfBirth(2018, 1, 1).countDaysSinceBirth(LocalDate.of(2017, 10, 2));
    }

    @Test
    public void testCountDaysBetween() {
        // Given
        DateOfBirth dob = new DateOfBirth(2017, 2, 1);
        //Then
        assertThat(dob.countDaysBetween(new DateOfBirth(2017, 3, 1)), equalTo(28));
    }

    @Test
    public void testToString() {
        // Given
        DateOfBirth dob = new DateOfBirth(2017, 2, 1);
        //Then
        assertThat(dob.toString("dd/MM/yyyy"), equalTo("01/02/2017"));
    }

    @Test
    public void emptyPatternInToStringMethodShouldThrowException() {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty pattern string");
        // When
        new DateOfBirth(2018, 2, 1).toString("");
    }
}
