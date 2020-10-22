package algorithmsdecision.integers;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerDecisionMakerTest {

    IntegerDecisionMaker test = new IntegerDecisionMaker();
    List<Integer> numbers = Arrays.asList(1, 2, 2, -7, 6);

    @Test
    public void testContainsGreaterThan() {

        assertThat(test.containsGreaterThan(numbers, 3), is(true));
        assertThat(test.containsGreaterThan(numbers, 7), is(false));
    }

    @Test
    public void testContainsLowerThan() {
        assertThat(test.containsLowerThan(numbers, -6), is(true));
        assertThat(test.containsLowerThan(numbers, -7), is(false));
    }

}
