package algorithmscount.letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCounterTest {

    @Test
    public void testCount() {
        assertEquals(0, new LetterCounter().countLetters("abcdeabcd", 'f'));
        assertEquals(2, new LetterCounter().countLetters("abcdeabcd", 'd'));
    }
}
