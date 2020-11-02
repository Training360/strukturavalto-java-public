package collectionsequalshash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualsTest {

    @Test
    public void testEquals() {
        //noinspection StringOperationCanBeSimplified
        String s = new String("John");
        //noinspection StringOperationCanBeSimplified
        String s2 = new String("John");
        assertTrue(s.equals(s2));

        Trainer trainer = new Trainer("John Doe", 2000);
        Trainer trainer2 = new Trainer("John Doe", 1990);
        assertFalse(trainer.equals(trainer2));

        Trainer trainer3 = new Trainer("John Doe", 2000);
        assertTrue(trainer.equals(trainer3));

        List<Integer> l = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(1, 2, 3);

        assertTrue(l.equals(l2));
    }

    @Test
    public void testHashCode() {
        Trainer trainer = new Trainer("John Doe", 1990);
        Trainer trainer1 = new Trainer("John Doe", 1990);
        assertTrue(trainer.equals(trainer1));
        assertTrue(trainer.hashCode() == trainer1.hashCode());

        Trainer trainer2 = new Trainer("John Doe", 2000);
        assertFalse(trainer.equals(trainer2));
    }
}
