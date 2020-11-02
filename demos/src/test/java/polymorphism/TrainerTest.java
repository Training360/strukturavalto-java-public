package polymorphism;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));

        assertTrue(trainer instanceof Trainer);
        assertTrue(trainer instanceof Human);
        assertTrue(trainer instanceof Object);
        assertTrue(trainer instanceof HasName);

        Object object = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertTrue(object instanceof Trainer);
        assertTrue(object instanceof Human);
        assertTrue(object instanceof Object);
        assertTrue(object instanceof HasName);

        Human human = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertTrue(human instanceof Trainer);
        assertTrue(human instanceof Human);
        assertTrue(human instanceof Object);
        assertTrue(human instanceof HasName);

        HasName hasName = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        assertTrue(hasName instanceof Trainer);
        assertTrue(hasName instanceof Human);
        assertTrue(hasName instanceof Object);
        assertTrue(hasName instanceof HasName);
    }

    @Test
    public void testConvert() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        Human human = trainer;
        Object object = trainer;
        HasName hasName = trainer;
    }

    @Test
    public void testExplicitConvert() {
        Object object = new Trainer("John Doe", Arrays.asList(new Course("Course1")));
        Trainer trainer = (Trainer) object;
    }

    @Test
    public void testExplicitConvertCannotWork() {
        Human human = new Human("John Doe");
        assertThrows(ClassCastException.class, () -> {
            Trainer trainer = (Trainer) human;
        });

    }
}
