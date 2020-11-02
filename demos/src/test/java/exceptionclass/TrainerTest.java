package exceptionclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }

    @Test
    public void testInvalidAge() {
        InvalidAgeException e = assertThrows(InvalidAgeException.class, () -> {
            new Trainer("John Doe", 15);
        });
        assertEquals("Invalid age by creating a trainer", e.getMessage());
        assertEquals(15, e.getParameterAge());
        assertEquals(18, e.getMinAge());
    }
}
