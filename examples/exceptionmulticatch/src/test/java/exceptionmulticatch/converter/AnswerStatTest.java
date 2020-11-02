package exceptionmulticatch.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AnswerStatTest {


    @Test
    public void convertNullShouldThrowException() {
        AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());
        Exception ex = assertThrows(InvalidBinaryStringException.class, () -> answerStat.convert(null));
        assertEquals("binaryString null", ex.getCause().getMessage());
    }

    @Test
    public void convertInvalidStringShouldThowException() {
        AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());
        Exception ex = assertThrows(InvalidBinaryStringException.class, () -> answerStat.convert("1133"));
        assertEquals("binaryString not valid", ex.getCause().getMessage());
    }

    @Test
    public void convertShouldReturn() {
        BinaryStringConverter binaryStringConverter = new BinaryStringConverter();
        AnswerStat answerStat = new AnswerStat(binaryStringConverter);
        String good = "1100010";

        assertArrayEquals(binaryStringConverter.binaryStringToBooleanArray(good), answerStat.convert(good));
    }

    @Test
    public void answerTruePercent() {
        BinaryStringConverter binaryStringConverter = new BinaryStringConverter();
        AnswerStat answerStat = new AnswerStat(binaryStringConverter);

        assertEquals(50, answerStat.answerTruePercent("11000101"));
        assertEquals(80, answerStat.answerTruePercent("1111111100"));
    }

}