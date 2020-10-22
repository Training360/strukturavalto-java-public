package datenewtypes;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FamilyBirthdaysTest {

    @Test
    public void testIsFamilyBirthday() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 05, 05),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 06,15)
        );

        assertThat(LocalDate.of(2017, 05, 04).query(familyBirthdays::isFamilyBirthday), equalTo(false));
        assertThat(LocalDate.of(2017, 05, 05).query(familyBirthdays::isFamilyBirthday), equalTo(true));
        assertThat(LocalDate.of(2017, 06, 15).query(familyBirthdays::isFamilyBirthday), equalTo(true));
    }

    @Test
    public void testNextFamilyBirthDay() {
        FamilyBirthdays familyBirthdays = new FamilyBirthdays(
                LocalDate.of(2000, 05, 05),
                LocalDate.of(2010, 10, 20),
                LocalDate.of(1980, 06,15)
        );
        assertThat(LocalDate.of(2017, 05, 04).query(familyBirthdays::nextFamilyBirthDay), equalTo(1));
        assertThat(LocalDate.of(2017, 06, 10).query(familyBirthdays::nextFamilyBirthDay), equalTo(5));
        assertThat(LocalDate.of(2017, 10, 20).query(familyBirthdays::nextFamilyBirthDay), equalTo(0));
        assertThat(LocalDate.of(2017, 11, 10).query(familyBirthdays::nextFamilyBirthDay), equalTo(176));
    }


}
