package algorithmssum;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeSumCalculatorTest {

    @Test
    public void testSumAges() {
        AgeSumCalculator test = new AgeSumCalculator();

        List<Trainer> trainers = Arrays.asList(
                new Trainer("John", 21),
                new Trainer("Bill", 32),
                new Trainer("Kate", 31),
                new Trainer("Mary", 28),
                new Trainer("Karl", 19)
        );

        assertEquals(131, test.sumAges(trainers));
    }

}
