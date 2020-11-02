package exceptionmulticatch.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryStringConverterTest {


    @Test
    public void binaryStringToBooleanArrayShouldInvalidStringThrowException() {
        String binaryString = "011200";
        BinaryStringConverter converter = new BinaryStringConverter();

        assertThrows(IllegalArgumentException.class, () -> converter.binaryStringToBooleanArray(binaryString));
    }

    @Test
    public void binaryStringToBooleanArrayShouldConvert() {
        String binaryString = "0111001";
        BinaryStringConverter converter = new BinaryStringConverter();

        boolean[] expected = new boolean[]{false, true, true, true, false, false, true};

        assertArrayEquals(expected, converter.binaryStringToBooleanArray(binaryString));
    }

    @Test
    public void booleanArrayToBinaryStringShouldEmptyArrayThrowException() {
        boolean[] booleans = new boolean[0];
        BinaryStringConverter converter = new BinaryStringConverter();

        assertThrows(IllegalArgumentException.class, () -> converter.booleanArrayToBinaryString(booleans));
    }

    @Test
    public void booleanArrayToBinaryStringShouldConvert() {
        boolean[] booleans = new boolean[]{false, true, true, false, false};
        BinaryStringConverter converter = new BinaryStringConverter();
        String expected = "01100";

        assertEquals(expected, converter.booleanArrayToBinaryString(booleans));
    }
}