package exceptions.faults;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FaultListTest {

    private static final List<String> INPUT = Arrays.asList(
            "1,12.4,1998.04.12.",
            "2,12.4,1998.04.12.,a",
            "a,12.4,1998.04.12.",
            "3,12a.4,1998.04.12.",
            "4,12.4,1998.12.1.",
            "5,12.4,1998.04.3a.",
            "a1,12a.4,1998.04.12.",
            "6,12a.4,1998.04a.12.");

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void processingNullParamShouldThrowException() throws Exception {
        exception.expect(IllegalArgumentException.class);

        new FaultList().processLines(null);
    }

    @Test
    public void processing() {
        FaultList faultList = new FaultList();
        List<String> faults = faultList.processLines(INPUT);

        List<String> expected = new ArrayList<>();
        expected.add("2," + ProcessingResult.WORD_COUNT_ERROR.getCode());
        expected.add("3," + ProcessingResult.VALUE_ERROR.getCode());
        expected.add("5," + ProcessingResult.DATE_ERROR.getCode());
        expected.add("6," + ProcessingResult.VALUE_AND_DATE_ERROR.getCode());

        assertThat(faults, is(expected));
    }

}