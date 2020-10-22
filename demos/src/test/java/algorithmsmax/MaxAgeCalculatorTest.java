package algorithmsmax;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAgeCalculatorTest {

    @Test
    public void testTrainerWithMaxAge() {
        //Given
        List<Trainer> trainers = Arrays.asList(
                new Trainer("John", 21),
                new Trainer("Bill", 32),
                new Trainer("Kate", 31),
                new Trainer("Mary", 28),
                new Trainer("Karl", 19)
        );
        //When
        MaxAgeCalculator mac = new MaxAgeCalculator();
        //Then
        assertThat(mac.trainerWithMaxAge(trainers).getAge(), is(32));
    }

}
