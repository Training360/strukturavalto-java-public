package algorithmsdecision;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerDecisionMakerTest {

    @Test
    public void testContainsElderThan() {
        TrainerDecisionMaker test = new TrainerDecisionMaker();

        List<Trainer> trainers = Arrays.asList(
                new Trainer("John", 21),
                new Trainer("Bill", 32),
                new Trainer("Kate", 31),
                new Trainer("Mary", 28),
                new Trainer("Karl", 19)
        );

        assertTrue(test.containsElderThan(trainers, 31));
        assertFalse(test.containsElderThan(trainers, 32));

    }

}
