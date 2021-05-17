package hu.nive.ujratervezes.longestword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestWordTest {
  private LongestWord longestWord;

  @BeforeEach
  void setupEach() {
    longestWord = new LongestWord();
  }

  @Test
  void testWords() {
    String expected = "Maurisinfaucibusmassaeuscelerisqueenim.";
    assertEquals(expected, longestWord.findLongestWord("test-files/test1.txt"));
  }

  @Test
  void testNumbersDoubleSpaces() {
    String expected = "000000000000000001";
    assertEquals(expected, longestWord.findLongestWord("test-files/test2.txt"));
  }

  @Test
  void testWordsMultipleCorrect() {
    String expected1 = "aaaaaaaaaa";
    String expected2 = "bbbbbbbbbb";
    String expected3 = "cccccccccc";
    String actual = longestWord.findLongestWord("test-files/test3.txt");
    assertTrue(expected1.equals(actual) || expected2.equals(actual) || expected3.equals(actual));
  }

  @Test
  void testSingleWordFile() {
    String expected = "42";
    assertEquals(expected, longestWord.findLongestWord("test-files/test4.txt"));
  }

  @Test
  void testNonExistentFile() {
    String expected = "";
    assertEquals(expected, longestWord.findLongestWord("doesNotExist"));
  }
}
