package stringbuilder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeValidatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void nullParameterShouldThrowException() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Text must not be null!");

        // When
        new PalindromeValidator().isPalindrome(null);
    }

    @Test
    public void isPalindrome() {

        assertThat(new PalindromeValidator().isPalindrome("Racecar"), is(true));
        assertThat(new PalindromeValidator().isPalindrome("start"), is(false));
        assertThat(new PalindromeValidator().isPalindrome(""), is(true));
        assertThat(new PalindromeValidator().isPalindrome("\n\t"), is(true));
    }
}
