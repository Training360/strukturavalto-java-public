package dateoldtypes;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class DateOfBirthTest {


    @Test
    public void illegalMonthOrDayShouldThrowException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new DateOfBirth(2016, 12, 42));
    }

    @Test
    public void illegalDateStringShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new DateOfBirth("", "yyyy-MM-dd");
        });
        assertEquals("Illegal date string, cannot parse: ", ex.getMessage());

    }

    @Test
    public void illegalPatternStringShouldThrowException() throws IllegalArgumentException {

        String pattern = "yyyy-MM-dd";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new DateOfBirth("1987-10-17", "");
        });
        assertEquals("Illegal pattern string, cannot use: ", ex.getMessage());
    }

    @Test
    public void nullLocaleShouldThrowException() throws NullPointerException {

        Exception ex = assertThrows(NullPointerException.class, () -> {
            new DateOfBirth("1987-10-17", "yyyy-MM-dd", null);
        });
        assertEquals("Locale must not be null!", ex.getMessage());
    }


    @Test
    public void nullLocaleShouldThrowExceptionInDayOfWeekForBirthDateMethod() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new DateOfBirth("1987-10-17", "yyyy-MM-dd", new Locale("hu", "HU")).findDayOfWeekForBirthDate(null);
        });
        assertEquals("Locale must not be null!", ex.getMessage());
    }

    @Test
    public void testFindDayOfWeekForBirthDate() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertEquals("szombat", dateOfBirth.findDayOfWeekForBirthDate(new Locale("hu", "HU")));
    }

    @Test
    public void illegalPatternStringShouldThrowExceptionInToStringMethod() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new DateOfBirth("1987-10-17", "yyyy-MM-dd", new Locale("hu", "HU")).toString("");
        });
        assertEquals("Illegal pattern string, cannot use: ", ex.getMessage());
    }

    @Test
    public void testToString() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertEquals("1987-10-17", dateOfBirth.toString("yyyy-MM-dd"));
    }

    @Test
    public void testIsWeekDay() {
        // Given
        DateOfBirth dateOfBirth = new DateOfBirth(1987, 10, 17);
        //Then
        assertFalse(dateOfBirth.isWeekDay());
    }
}
