package introexception.patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SsnValidatorTest {

    @Test
    public void testSsnLength() {
        assertFalse(new SsnValidator().isValidSsn("1234"));
    }

    @Test
    public void testSsnLetters() {
        assertFalse(new SsnValidator().isValidSsn("abc"));
    }

    @Test
    public void testSsnInvalidCrc() {
        assertFalse(new SsnValidator().isValidSsn("123456789"));
    }

    @Test
    public void testSsnValidCrc() {
        assertTrue(new SsnValidator().isValidSsn("123456788"));
    }
}
