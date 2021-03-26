package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueFinderTest {

    private UniqueFinder uniqueFinder;
    private List<Character> expected;

    @BeforeEach
    void init() {
        uniqueFinder = new UniqueFinder();
        expected = new ArrayList<>();
    }

    @Test
    void test_uniqueChars_null_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> uniqueFinder.uniqueChars(null));
    }

    @Test
    void test_uniqueChars_a_a() {
        expected.add('a');
        assertEquals(expected, uniqueFinder.uniqueChars("a"));
    }

    @Test
    void test_uniqueChars_abc_abc() {
        expected.add('a');
        expected.add('b');
        expected.add('c');
        assertEquals(expected, uniqueFinder.uniqueChars("abc"));
    }

    @Test
    void test_uniqueChars_abac_abc() {
        expected.add('a');
        expected.add('b');
        expected.add('c');
        assertEquals(expected, uniqueFinder.uniqueChars("abac"));
    }

    @Test
    void test_uniqueChars_ilkethcs_iLikeTheCats() {
        expected.add('i');
        expected.add(' ');
        expected.add('l');
        expected.add('k');
        expected.add('e');
        expected.add('t');
        expected.add('h');
        expected.add('c');
        expected.add('a');
        expected.add('s');
        assertEquals(expected, uniqueFinder.uniqueChars("i like the cats"));
    }

    @Test
    void test_uniqueChars_aAbBcCDd_aAabBbcCCcDdD() {
        expected.add('a');
        expected.add('A');
        expected.add('b');
        expected.add('B');
        expected.add('c');
        expected.add('C');
        expected.add('D');
        expected.add('d');
        assertEquals(expected, uniqueFinder.uniqueChars("aAabBbcCCcDdD"));
    }

    @Test
    void test_uniqueChars_123_123() {
        expected.add('1');
        expected.add('2');
        expected.add('3');
        assertEquals(expected, uniqueFinder.uniqueChars("123"));
    }

    @Test
    void test_uniqueChars_1234_1223334444() {
        expected.add('1');
        expected.add('2');
        expected.add('3');
        expected.add('4');
        assertEquals(expected, uniqueFinder.uniqueChars("1223334444"));
    }

    @Test
    void test_uniqueChars_iate12pls_iAte112Apples() {
        expected.add('i');
        expected.add(' ');
        expected.add('a');
        expected.add('t');
        expected.add('e');
        expected.add('1');
        expected.add('2');
        expected.add('p');
        expected.add('l');
        expected.add('s');
        assertEquals(expected, uniqueFinder.uniqueChars("i ate 112 apples"));
    }

    @Test
    void test_uniqueChars_withSpecialCharacters_withSpecialCharacters() {
        expected.add('<');
        expected.add('3');
        expected.add(' ');
        expected.add('j');
        expected.add('a');
        expected.add('v');
        expected.add('&');
        expected.add('m');
        expected.add('y');
        expected.add('t');
        expected.add('e');
        expected.add('@');
        expected.add('p');
        expected.add(':');
        expected.add('0');
        assertEquals(expected, uniqueFinder.uniqueChars("<3 java && my team @ pm @ 3:00"));
    }
}
