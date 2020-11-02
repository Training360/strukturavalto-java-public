package constructoroverloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer();
        assertEquals("anonymous", trainer.getName());
        assertEquals(20, trainer.getAge());
    }

    @Test
    public void testCreateWithName() {
        Trainer trainer = new Trainer("John Doe");
        assertEquals("John Doe", trainer.getName());
        assertEquals(20, trainer.getAge());
    }

    @Test
    public void testCreateWithNameAndAge() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }
}
