package algorithmscount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AgeConditionCounterTest {

    @Test
    public void testCount() {
        List<Trainer> trainers = Arrays.asList(new Trainer("John Doe", 30),
                new Trainer("Jane Doe", 35), new Trainer("Joe Doe", 40));
        assertThat(new AgeConditionCounter().countElderly(trainers, 30), equalTo(3));
        assertThat(new AgeConditionCounter().countElderly(trainers, 35), equalTo(2));
        assertThat(new AgeConditionCounter().countElderly(trainers, 38), equalTo(1));
        assertThat(new AgeConditionCounter().countElderly(trainers, 45), equalTo(0));
    }
}
