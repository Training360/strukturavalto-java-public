package stringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeValidatorTest {

    @Test
    public void nullParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new PalindromeValidator().isPalindrome(null));
        assertEquals("Text must not be null!", ex.getMessage());
    }

    @Test
    public void isPalindrome() {

        assertTrue(new PalindromeValidator().isPalindrome("Racecar"));
        assertFalse(new PalindromeValidator().isPalindrome("start"));
        assertTrue(new PalindromeValidator().isPalindrome(""));
        assertTrue(new PalindromeValidator().isPalindrome("\n\t"));
    }
}
