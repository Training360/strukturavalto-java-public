package javabeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void createTrainer() {
        Trainer trainer = new Trainer("John Doe", true);
        assertEquals("John Doe", trainer.getName());
        assertTrue(trainer.isActive());
    }

    @Test
    public void setTrainer() {
        Trainer trainer = new Trainer("John Doe", true);
        trainer.setName("Jack Doe");
        trainer.setActive(false);
        assertEquals("Jack Doe", trainer.getName());
        assertFalse(trainer.isActive());
    }
}
