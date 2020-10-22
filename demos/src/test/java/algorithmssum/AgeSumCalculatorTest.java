package algorithmssum;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

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

        assertThat(test.sumAges(trainers), is(131));
    }

}
