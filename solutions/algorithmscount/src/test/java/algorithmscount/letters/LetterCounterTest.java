package algorithmscount.letters;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LetterCounterTest {

    @Test
    public void testCount() {
        assertThat(new LetterCounter().countLetters("abcdeabcd", 'f'), equalTo(0));
        assertThat(new LetterCounter().countLetters("abcdeabcd", 'd'), equalTo(2));
    }
}
