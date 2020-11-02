package algorithmscount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeConditionCounterTest {

    @Test
    public void testCount() {
        List<Trainer> trainers = Arrays.asList(new Trainer("John Doe", 30),
                new Trainer("Jane Doe", 35), new Trainer("Joe Doe", 40));
        assertEquals(3, new AgeConditionCounter().countElderly(trainers, 30));
        assertEquals(2, new AgeConditionCounter().countElderly(trainers, 35));
        assertEquals(1, new AgeConditionCounter().countElderly(trainers, 38));
        assertEquals(0, new AgeConditionCounter().countElderly(trainers, 45));
    }
}
