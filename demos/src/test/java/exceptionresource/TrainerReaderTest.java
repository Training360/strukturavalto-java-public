package exceptionresource;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainerReaderTest {

    @Test
    public void testValid() {
        TrainerReader trainerReader = new TrainerReader("John Doe;30");
        List<Trainer> trainers = trainerReader.read();

        assertEquals(1, trainers.size());
        assertEquals("John Doe", trainers.get(0).getName());
        assertEquals(30, trainers.get(0).getAge());
    }

    @Test
    public void testValidMoreLines() {
        TrainerReader trainerReader = new TrainerReader("John Doe;30\nJane Doe;20");
        List<Trainer> trainers = trainerReader.read();

        assertEquals(2, trainers.size());
        assertEquals("John Doe", trainers.get(0).getName());
        assertEquals(20, trainers.get(1).getAge());
    }

    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> {
            TrainerReader trainerReader = new TrainerReader(null);
            trainerReader.read();
        });
    }

    @Test
    public void testInvalidLine() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrainerReader trainerReader = new TrainerReader("John Doe");
            trainerReader.read();
        });
    }

    @Test
    public void testEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrainerReader trainerReader = new TrainerReader(";30");
            trainerReader.read();
        });
    }

    @Test
    public void testInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrainerReader trainerReader = new TrainerReader("John Doe;abc");
            trainerReader.read();
        });
    }
}
