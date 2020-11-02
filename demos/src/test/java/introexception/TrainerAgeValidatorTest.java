package introexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerAgeValidatorTest {

    @Test
    public void testValidAge() {
        assertTrue(new TrainerAgeValidator().isValidAge("18"));
        assertTrue(new TrainerAgeValidator().isValidAge("20"));
    }

    @Test
    public void testInvalidAge() {
        assertFalse(new TrainerAgeValidator().isValidAge("abc"));
        assertFalse(new TrainerAgeValidator().isValidAge("17"));
    }
}
