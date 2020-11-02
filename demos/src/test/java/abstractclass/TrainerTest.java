package abstractclass;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", Arrays.asList(new Course("Biology")));
        assertEquals("John Doe", trainer.getName());
        assertEquals(1, trainer.getCourses().size());
    }

    @Test
    public void testWork() {
        List<Course> courses = Arrays.asList(new Course("Biology"), new Course("Math"));
        assertFalse(courses.get(0).isTaken());
        Human human = new Trainer("John Doe", courses);
        human.work();

        assertTrue(courses.get(0).isTaken());
        assertTrue(courses.get(1).isTaken());
    }
}
