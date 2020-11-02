package algorithmscount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }

}
