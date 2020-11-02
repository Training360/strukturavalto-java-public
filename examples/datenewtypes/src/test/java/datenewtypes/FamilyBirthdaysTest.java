package datenewtypes;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyBirthdaysTest {

    @Test
    public void testIsFamilyBirthday() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 05, 05),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 06, 15)
        );

        assertFalse(LocalDate.of(2017, 05, 04).query(familyBirthdays::isFamilyBirthday));
        assertTrue(LocalDate.of(2017, 05, 05).query(familyBirthdays::isFamilyBirthday));
        assertTrue(LocalDate.of(2017, 06, 15).query(familyBirthdays::isFamilyBirthday));
    }

    @Test
    public void testNextFamilyBirthDay() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 05, 05),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 06, 15)
        );
        assertEquals(1, LocalDate.of(2017, 05, 04).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(5, LocalDate.of(2017, 06, 10).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(0, LocalDate.of(2017, 10, 20).query(familyBirthdays::nextFamilyBirthDay));
        assertEquals(176, LocalDate.of(2017, 11, 10).query(familyBirthdays::nextFamilyBirthDay));
    }


}
