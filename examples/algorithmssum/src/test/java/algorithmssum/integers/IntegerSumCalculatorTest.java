package algorithmssum.integers;

import java.util.Arrays;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerSumCalculatorTest {

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, -7, 6);

        IntegerSumCalculator test = new IntegerSumCalculator();

        assertThat(test.sum(numbers), is(4));

    }

}
