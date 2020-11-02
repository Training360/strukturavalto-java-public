package introexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 20);
        assertEquals("John Doe", trainer.getName());
    }

    @Test
    public void testInvalidAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Trainer("John Doe", 13);
        });
        assertEquals("Invalid age: 13", e.getMessage());
    }
}
