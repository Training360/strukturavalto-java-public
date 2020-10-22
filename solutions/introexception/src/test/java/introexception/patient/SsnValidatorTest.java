package introexception.patient;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SsnValidatorTest {

    @Test
    public void testSsnLength() {
        assertThat(new SsnValidator().isValidSsn("1234"), is(false));
    }

    @Test
    public void testSsnLetters() {
        assertThat(new SsnValidator().isValidSsn("abc"), is(false));
    }

    @Test
    public void testSsnInvalidCrc() {
        assertThat(new SsnValidator().isValidSsn("123456789"), is(false));
    }

    @Test
    public void testSsnValidCrc() {
        assertThat(new SsnValidator().isValidSsn("123456788"), is(true));
    }
}
