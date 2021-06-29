package hu.nive.ujratervezes.lettermultiplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LetterMultiplierTest {

    LetterMultiplier letterMultiplier;

    @BeforeEach
    void init() {
        letterMultiplier = new LetterMultiplier();
    }

    @Test
    void test_multiply_null_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> letterMultiplier.multiply(null, 1));
    }

    @Test
    void test_multiply_emptyString_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> letterMultiplier.multiply("", 1));
    }

    @Test
    void test_multiply_negativeNumber_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> letterMultiplier.multiply("java", -1));
    }

    @Test
    void test_multiply_alma0_emptyString() {
        assertEquals("", letterMultiplier.multiply("alma", 0));
    }

    @Test
    void test_multiply_a1_a() {
        assertEquals("a", letterMultiplier.multiply("a", 1));
    }

    @Test
    void test_multiply_apple1_apple() {
        assertEquals("apple", letterMultiplier.multiply("apple", 1));
    }

    @Test
    void test_multiply_j2_jj() {
        assertEquals("jj", letterMultiplier.multiply("j", 2));
    }

    @Test
    void test_multiply_java3_jjjaaavvvaaa() {
        assertEquals("jjjaaavvvaaa", letterMultiplier.multiply("java", 3));
    }

    @Test
    void test_multiply_one2_11() {
        assertEquals("11", letterMultiplier.multiply("1", 2));
    }

    @Test
    void test_multiply_one1two2three3And2_oonnee11ttwwoo22tthhrreeee33() {
        assertEquals("oonnee11ttwwoo22tthhrreeee33", letterMultiplier.multiply("one1two2three3", 2));
    }

}