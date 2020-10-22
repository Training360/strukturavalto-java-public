package introexception.patient;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PatientTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void invalidSsn() {
        expectedException.expect(IllegalArgumentException.class);
        new Patient("John Doe", "abc", 2000);
    }

    @Test
    public void validSsn() {
        Patient patient = new Patient("John Doe", "123456788", 2000);
        assertThat(patient.getName(), equalTo("John Doe"));
        assertThat(patient.getSocialSecurityNumber(), equalTo("123456788"));
        assertThat(patient.getYearOfBirth(), equalTo(2000));
    }
}
