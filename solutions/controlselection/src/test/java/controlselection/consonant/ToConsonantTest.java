package controlselection.consonant;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ToConsonantTest {

    @Test
    public void testVowel() {
        assertThat(new ToConsonant().convertToConsonant('a'), equalTo('b'));
        assertThat(new ToConsonant().convertToConsonant('e'), equalTo('f'));
        assertThat(new ToConsonant().convertToConsonant('i'), equalTo('j'));
    }

    @Test
    public void testConsonant() {
        assertThat(new ToConsonant().convertToConsonant('b'), equalTo('b'));
        assertThat(new ToConsonant().convertToConsonant('g'), equalTo('g'));
        assertThat(new ToConsonant().convertToConsonant('z'), equalTo('z'));
    }
}
