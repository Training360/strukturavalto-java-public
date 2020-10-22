package stringscanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringScannerTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");
        // When
        new StringScanner().readAndSumValues("a:2:4", ":");
    }


    @Test
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException{

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().readAndSumValues("3:2:4", null);

    }

    @Test
    public void delimiterIsSpaceOrNull(){

        assertThat(new StringScanner().readAndSumValues("2 4 5"," "),equalTo(11));
        assertThat(new StringScanner().readAndSumValues("2 4 5",null),equalTo(11));
    }


    @Test
    public void readAndSumValues() {

        assertThat(new StringScanner().readAndSumValues("1:2:3", ":"), equalTo(6));
        assertThat(new StringScanner().readAndSumValues("1:2:3", ":"), equalTo(6));
    }

    @Test
    public void readAndSumValuesWithoutDelimiter() {

        assertThat(new StringScanner().readAndSumValues("1 2 3"), equalTo(6));

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().readAndSumValues("3:2:4", null);
    }

    @Test
    public void filterLinesWithWordOccurrences() {
        assertThat(new StringScanner().filterLinesWithWordOccurrences("first word\napple\nnext word", "word"), equalTo("first word\nnext word"));
        assertThat(new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", "word"), equalTo(""));
        assertThat(new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", " "), equalTo(""));
    }

    @Test
    public void textIsEmptyShouldThrowException() throws IllegalArgumentException{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().filterLinesWithWordOccurrences("", "word");
    }

    @Test
    public void textIsJustSpacesShouldThrowException() throws IllegalArgumentException{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().filterLinesWithWordOccurrences("       ", "word");
    }

    @Test
    public void textIsNullShouldThrowException() throws IllegalArgumentException{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().filterLinesWithWordOccurrences(null, "word");
    }

    @Test
    public void wordIsNullShouldThrowException() throws IllegalArgumentException{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().filterLinesWithWordOccurrences("a\nbc", null);
    }

    @Test
    public void wordIsEmptyShouldThrowException() throws IllegalArgumentException{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect parameter string!");


        new StringScanner().filterLinesWithWordOccurrences("a\nbc", "");
    }

}
