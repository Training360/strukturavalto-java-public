package algorithmsdecision.integers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IntegerDecisionMakerTest {

    IntegerDecisionMaker test = new IntegerDecisionMaker();
    List<Integer> numbers = Arrays.asList(1, 2, 2, -7, 6);

    @Test
    public void testContainsGreaterThan() {

        assertTrue(test.containsGreaterThan(numbers, 3));
        assertFalse(test.containsGreaterThan(numbers, 7));
    }

    @Test
    public void testContainsLowerThan() {
        assertTrue(test.containsLowerThan(numbers, -6));
        assertFalse(test.containsLowerThan(numbers, -7));
    }

}
