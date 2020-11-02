package datenewtypes;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DateOfBirthTest {


    @Test
    public void emptyPatternShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DateOfBirth("1987-10-17", "", Locale.ENGLISH));
        assertEquals("Empty pattern string, cannot use: ", ex.getMessage());
    }

    @Test
    public void emptyPatternWithoutLocaleShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DateOfBirth("1987-10-17", ""));
        assertEquals("Empty pattern string, cannot use: ", ex.getMessage());
    }

    @Test
    public void nullParameterShouldThrowException() {
        Exception ex = assertThrows(NullPointerException.class, () -> new DateOfBirth("1987-10-17", "yyyy-MM-dd", null));
        assertEquals("Locale must not be null!", ex.getMessage());
    }

    @Test
    public void testConstructor() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        //Then
        assertEquals("1987-10-17", dob.toString("yyyy-MM-dd"));
    }

    @Test
    public void testFindDayOfWeekForBirthDate() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        //Then
        assertEquals("Saturday", dob.findDayOfWeekForBirthDate(Locale.ENGLISH));
    }

    @Test
    public void testFindDayOfWeekForLaterBirthDate() {
        // Given
        DateOfBirth dob = new DateOfBirth(1987, 10, 17);
        LocalDate later = dob.getDateOfBirth().plusYears(2);
        //Then
        assertEquals("Tuesday", dob.findDayOfWeekForBirthDate(Locale.ENGLISH, later));
    }

    @Test
    public void nullParameterShouldThrowExceptionInFindDayOfWeekMethod() {
        Exception ex = assertThrows(NullPointerException.class, () -> new DateOfBirth("1987-10-17", "yyyy-MM-dd", Locale.ENGLISH).findDayOfWeekForBirthDate(null));
        assertEquals("Locale must not be null!", ex.getMessage());
    }

    @Test
    public void testCountDaysSinceBirth() {
        // Given
        DateOfBirth dob = new DateOfBirth(2000, 1, 1);
        LocalDate now = LocalDate.of(2017, 10, 2);
        //Then
        assertEquals(6484, dob.countDaysSinceBirth(now));
    }

    @Test
    public void futureBirthDateShouldThrowException() {
        Exception ex = assertThrows(IllegalStateException.class, () -> new DateOfBirth(2018, 1, 1).countDaysSinceBirth(LocalDate.of(2017, 10, 2)));
        assertEquals("Birthdate is in the future!", ex.getMessage());
    }

    @Test
    public void testCountDaysBetween() {
        // Given
        DateOfBirth dob = new DateOfBirth(2017, 2, 1);
        //Then
        assertEquals(28, dob.countDaysBetween(new DateOfBirth(2017, 3, 1)));
    }

    @Test
    public void testToString() {
        // Given
        DateOfBirth dob = new DateOfBirth(2017, 2, 1);
        //Then
        assertEquals("01/02/2017", dob.toString("dd/MM/yyyy"));
    }

    @Test
    public void emptyPatternInToStringMethodShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DateOfBirth(2018, 2, 1).toString(""));
        assertEquals("Empty pattern string, cannot use: ", ex.getMessage());
    }
}
