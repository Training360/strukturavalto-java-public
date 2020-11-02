package staticattrmeth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static staticattrmeth.Trainer.getNumberOfTrainers;

public class TrainerTest {

    @Test
    public void testCreate() {
        assertEquals(0, getNumberOfTrainers());
        Trainer t = new Trainer("John Doe");
        assertEquals(1, getNumberOfTrainers());
        Trainer t2 = new Trainer("Jane Doe");
        assertEquals(2, getNumberOfTrainers());
    }

}
