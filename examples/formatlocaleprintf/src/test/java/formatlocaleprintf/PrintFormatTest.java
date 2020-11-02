package formatlocaleprintf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintFormatTest {


    @Test
    public void lessParameterThenInFormatStringShouldThrowException() throws IllegalArgumentException {

        int i = 6;
        int j = 7;

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PrintFormat().formatMessageWithIntegerParameters("%d  %d  %d", i, j);
        });
        assertEquals("Less objects then expected in format String!", ex.getMessage());
    }


    @Test
    public void testPrintFormattedTextWDouble() {
        // Given
        Double d = 561123.201;

        //Then
        assertEquals("Total is: 561 123,20 Ft", new PrintFormat().printFormattedText(d));
    }

    @Test
    public void testPrintFormattedTextWIntString() {
        // Given
        String fruit = "APPLES";
        int count = 6;

        //Then
        assertEquals("We counted 6 APPLES in the basket", new PrintFormat().printFormattedText(count, fruit));
    }

    @Test
    public void testPrintFormattedTextWIntegerRightEdge() {
        // Given
        int i = 6;
        int j = 66;
        int k = 666666;   //overflow to the right expected!

        //Then
        assertEquals("Right edge of numbers set at 4 spaces from text:   " + i, new PrintFormat().printFormattedText(i));
        assertEquals("Right edge of numbers set at 4 spaces from text:  " + j, new PrintFormat().printFormattedText(j));
        assertEquals("Right edge of numbers set at 4 spaces from text:" + k, new PrintFormat().printFormattedText(k));
    }

    @Test
    public void testPrintFormattedTextWMultipleObject() {
        // Given
        int i = 6;
        int j = 7;
        int k = 8;

        //Then
        assertEquals("Multiple objects containing text:" + i + "\t" + j + "\t" + k, new PrintFormat().printFormattedText(i, j, k));
    }
}
