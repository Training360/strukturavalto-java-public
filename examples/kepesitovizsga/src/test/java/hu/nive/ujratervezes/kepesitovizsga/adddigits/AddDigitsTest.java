package hu.nive.ujratervezes.kepesitovizsga.adddigits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    private AddDigits digitAdder;

    @BeforeEach
    void init() {
        digitAdder = new AddDigits();
    }

    @Test
    void test_addDigits_null_negativeOne() {
        assertEquals(-1, digitAdder.addDigits(null));
    }

    @Test
    void test_addDigits_emptyString_negativeOne() {
        assertEquals(-1, digitAdder.addDigits(""));
    }

    @Test
    void test_addDigits_0_0() {
        assertEquals(0, digitAdder.addDigits("0"));
    }

    @Test
    void test_addDigits_0_apple() {
        assertEquals(0, digitAdder.addDigits("apple"));
    }

    @Test
    void test_addDigits_5_apple5() {
        assertEquals(5, digitAdder.addDigits("apple5"));
    }

    @Test
    void test_addDigits_2_eleven() {
        assertEquals(2, digitAdder.addDigits("11"));
    }

    @Test
    void test_addDigits_3_app1apple2() {
        assertEquals(3, digitAdder.addDigits("app1apple2"));
    }

    @Test
    void test_addDigits_45_0123456789() {
        assertEquals(45, digitAdder.addDigits("0123456789"));
    }

    @Test
    void test_addDigits_45_0zero1one2two3three4four5five6six7seven8eight9nine() {
        assertEquals(45, digitAdder.addDigits("0zero1one2two3three4four5five6six7seven8eight9nine"));
    }

    @Test
    void test_addDigits_15_5minus55() {
        assertEquals(15, digitAdder.addDigits("5-55"));
    }

}