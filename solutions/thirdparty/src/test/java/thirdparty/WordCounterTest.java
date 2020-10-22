package thirdparty;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WordCounterTest {

    @Test
    public void empty() {
        assertThat(new WordCounter().numberOfWords(""), equalTo(0));
        assertThat(new WordCounter().numberOfWords("   "), equalTo(0));
        assertThat(new WordCounter().numberOfWords(",. ,. ,. "), equalTo(0));
    }

    @Test
    public void normalStrings() {
        assertThat(new WordCounter().numberOfWords("a"), equalTo(1));
        assertThat(new WordCounter().numberOfWords("a a"), equalTo(2));
        assertThat(new WordCounter().numberOfWords("a,a"), equalTo(2));
        assertThat(new WordCounter().numberOfWords("a,,a"), equalTo(2));
        assertThat(new WordCounter().numberOfWords("a,.a"), equalTo(2));
    }

}
