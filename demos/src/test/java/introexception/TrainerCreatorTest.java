package introexception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerCreatorTest {

    @Test
    public void testCreate() {
        TrainerCreator trainerCreator = new TrainerCreator();
        assertTrue(trainerCreator.createTrainer("John Doe", "20"));
        assertEquals("John Doe", trainerCreator.getTrainer().getName());
        assertEquals(20, trainerCreator.getTrainer().getAge());
    }

    @Test
    public void testCreateInvalid() {
        TrainerCreator trainerCreator = new TrainerCreator();
        boolean created = trainerCreator.createTrainer("John Doe", "16");
        assertFalse(created);

        Exception e = assertThrows(IllegalStateException.class, () -> {
            trainerCreator.getTrainer();
                    });
        assertEquals("Could not create trainer", e.getMessage());

    }


}
