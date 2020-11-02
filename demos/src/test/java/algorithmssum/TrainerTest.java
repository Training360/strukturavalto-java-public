package algorithmssum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testCreateTrainer() {
        Trainer trainer = new Trainer("Sofia",21);
        
        assertEquals(21, trainer.getAge());
    }

}
