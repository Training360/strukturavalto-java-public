package algorithmssum.integers;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegerSumCalculatorTest {

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, -7, 6);

        IntegerSumCalculator test = new IntegerSumCalculator();

        assertEquals(4, test.sum(numbers));

    }

}
