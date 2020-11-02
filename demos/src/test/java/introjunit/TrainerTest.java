package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testCreate() {
        // Given
        Trainer trainer = new Trainer("John Doe");

        // When
        String name = trainer.getName();

        // Then
        assertEquals("John Doe", name);
    }

    @Test
    public void testCreate2() {
        assertEquals("John Doe", new Trainer("John Doe").getName());
    }

    @Test
    public void testUpperCase() {
        assertEquals("JOHN DOE", new Trainer("John Doe").getNameUpperCase());
    }
}
