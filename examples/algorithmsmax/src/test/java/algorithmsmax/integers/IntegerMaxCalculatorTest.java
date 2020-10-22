package algorithmsmax.integers;

import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerMaxCalculatorTest {

    @Test
    public void testMax() {
        List<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i % 30);
        }

        IntegerMaxCalculator test = new IntegerMaxCalculator();

        assertThat(test.max(integers), is(29));

    }

}
