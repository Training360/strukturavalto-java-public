package formatlocaleprintf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PrintFormatTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void lessParameterThenInFormatStringShouldThrowException() throws IllegalArgumentException {
        // Given
        int i = 6;
        int j = 7;

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Less objects then expected in format String!");

        // When
        new PrintFormat().formatMessageWithIntegerParameters("%d  %d  %d", i, j);
    }


    @Test
    public void testPrintFormattedTextWDouble() {
        // Given
        Double d = 561123.201;

        //Then
        assertThat(new PrintFormat().printFormattedText(d), equalTo("Total is: 561 123,20 Ft"));
    }

    @Test
    public void testPrintFormattedTextWIntString() {
        // Given
        String fruit = "APPLES";
        int count = 6;

        //Then
        assertThat(new PrintFormat().printFormattedText(count, fruit), equalTo("We counted 6 APPLES in the basket"));
    }

    @Test
    public void testPrintFormattedTextWIntegerRightEdge() {
        // Given
        int i = 6;
        int j = 66;
        int k = 666666;   //overflow to the right expected!

        //Then
        assertThat(new PrintFormat().printFormattedText(i), equalTo("Right edge of numbers set at 4 spaces from text:   " + i));
        assertThat(new PrintFormat().printFormattedText(j), equalTo("Right edge of numbers set at 4 spaces from text:  " + j));
        assertThat(new PrintFormat().printFormattedText(k), equalTo("Right edge of numbers set at 4 spaces from text:" + k));
    }

    @Test
    public void testPrintFormattedTextWMultipleObject() {
        // Given
        int i = 6;
        int j = 7;
        int k = 8;

        //Then
        assertThat(new PrintFormat().printFormattedText(i, j, k), equalTo("Multiple objects containing text:" + i + "\t" + j + "\t" + k));
    }
}
