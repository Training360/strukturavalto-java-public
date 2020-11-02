package thirdparty;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void empty() {
        assertEquals(0, new WordCounter().numberOfWords(""));
        assertEquals(0, new WordCounter().numberOfWords("   "));
        assertEquals(0, new WordCounter().numberOfWords(",. ,. ,. "));
    }

    @Test
    public void normalStrings() {
        assertEquals(1, new WordCounter().numberOfWords("a"));
        assertEquals(2, new WordCounter().numberOfWords("a a"));
        assertEquals(2, new WordCounter().numberOfWords("a,a"));
        assertEquals(2, new WordCounter().numberOfWords("a,,a"));
        assertEquals(2, new WordCounter().numberOfWords("a,.a"));
    }

}
