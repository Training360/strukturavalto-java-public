package algorithmsdecision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testGetAge() {
        Trainer trainer = new Trainer("Zsofia", 21);

        assertEquals(21, trainer.getAge());
    }

}
