package exceptionmulticatch.converter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class AnswerStatTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void convertNullShouldThrowException() {
        AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());
        exception.expect(InvalidBinaryStringException.class);
        exception.expectCause(instanceOf(NullPointerException.class));

        answerStat.convert(null);
    }

    @Test
    public void convertInvalidStringShouldThowException() {
        AnswerStat answerStat = new AnswerStat(new BinaryStringConverter());
        exception.expect(InvalidBinaryStringException.class);
        exception.expectCause(instanceOf(IllegalArgumentException.class));

        answerStat.convert("1133");
    }

    @Test
    public void convertShouldReturn() {
        BinaryStringConverter binaryStringConverter = new BinaryStringConverter();
        AnswerStat answerStat = new AnswerStat(binaryStringConverter);
        String good = "1100010";

        assertThat(answerStat.convert(good), equalTo(binaryStringConverter.binaryStringToBooleanArray(good)));
    }

    @Test
    public void answerTruePercent() {
        BinaryStringConverter binaryStringConverter = new BinaryStringConverter();
        AnswerStat answerStat = new AnswerStat(binaryStringConverter);

        assertThat(answerStat.answerTruePercent("11000101"), equalTo(50));
        assertThat(answerStat.answerTruePercent("1111111100"), equalTo(80));
    }

}