package exceptionmulticatch.converter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BinaryStringConverterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void binaryStringToBooleanArrayShouldInvalidStringThrowException() {
        String binaryString = "011200";
        BinaryStringConverter converter = new BinaryStringConverter();

        exception.expect(IllegalArgumentException.class);

        converter.binaryStringToBooleanArray(binaryString);
    }

    @Test
    public void binaryStringToBooleanArrayShouldConvert() {
        String binaryString = "0111001";
        BinaryStringConverter converter = new BinaryStringConverter();

        boolean[] expected = new boolean[] {false, true, true, true, false, false, true};

        assertThat(converter.binaryStringToBooleanArray(binaryString), equalTo(expected));
    }

    @Test
    public void booleanArrayToBinaryStringShouldEmptyArrayThrowException() {
        boolean[] booleans = new boolean[0];
        BinaryStringConverter converter = new BinaryStringConverter();

        exception.expect(IllegalArgumentException.class);

        converter.booleanArrayToBinaryString(booleans);
    }

    @Test
    public void booleanArrayToBinaryStringShouldConvert() {
        boolean[] booleans = new boolean[] {false, true, true, false, false};
        BinaryStringConverter converter = new BinaryStringConverter();
        String expected = "01100";

        assertThat(converter.booleanArrayToBinaryString(booleans), equalTo(expected));
    }
}