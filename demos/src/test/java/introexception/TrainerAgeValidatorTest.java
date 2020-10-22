package introexception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrainerAgeValidatorTest {

    @Test
    public void testValidAge() {
        assertThat(new TrainerAgeValidator().isValidAge("18"), is(true));
        assertThat(new TrainerAgeValidator().isValidAge("20"), is(true));
    }

    @Test
    public void testInvalidAge() {
        assertThat(new TrainerAgeValidator().isValidAge("abc"), is(false));
        assertThat(new TrainerAgeValidator().isValidAge("17"), is(false));
    }
}
