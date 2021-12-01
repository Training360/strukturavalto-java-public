package hu.nive.ujratervezes.kepesitovizsga_pot_potvizsga.numberofdigits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfDigitsTest {

    @Test
    public void testGetNumberOfDigits() {
        Assertions.assertEquals(13, new NumberOfDigits().getNumberOfDigits(11));
    }
}
