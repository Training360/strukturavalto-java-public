package stringscanner;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringScannerTest {


    @Test
    public void incorrectParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().readAndSumValues("a:2:4", ":"));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }


    @Test
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().readAndSumValues("3:2:4", null));
        assertEquals("Incorrect parameter string!", ex.getMessage());

    }

    @Test
    public void delimiterIsSpaceOrNull() {

        assertEquals(11, new StringScanner().readAndSumValues("2 4 5", " "));
        assertEquals(11, new StringScanner().readAndSumValues("2 4 5", null));


    }


    @Test
    public void readAndSumValues() {

        assertEquals(6, new StringScanner().readAndSumValues("1:2:3", ":"));
        assertEquals(6, new StringScanner().readAndSumValues("1:2:3", ":"));
    }

    @Test
    public void readAndSumValuesWithoutDelimiter() {

        assertEquals(6, new StringScanner().readAndSumValues("1 2 3"));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().readAndSumValues("3:2:4", null));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void filterLinesWithWordOccurrences() {
        assertEquals("first word\nnext word", new StringScanner().filterLinesWithWordOccurrences("first word\napple\nnext word", "word"));
        assertEquals("", new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", "word"));
        assertEquals("", new StringScanner().filterLinesWithWordOccurrences("first\napple\nnext", " "));
    }

    @Test
    public void textIsEmptyShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().filterLinesWithWordOccurrences("", "word"));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void textIsJustSpacesShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().filterLinesWithWordOccurrences("       ", "word"));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void textIsNullShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().filterLinesWithWordOccurrences(null, "word"));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void wordIsNullShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().filterLinesWithWordOccurrences("a\nbc", null));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

    @Test
    public void wordIsEmptyShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new StringScanner().filterLinesWithWordOccurrences("a\nbc", ""));
        assertEquals("Incorrect parameter string!", ex.getMessage());
    }

}
