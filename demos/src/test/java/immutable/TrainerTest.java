package immutable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30, Collections.emptyList());

        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }

    @Test
    public void testCreateWithCourses() {
        List<Course> courses = new ArrayList<>(Arrays.asList(new Course("Math"), new Course("Biology")));
        Trainer trainer = new Trainer("John Doe", 30, courses);

        courses.add(new Course("Art"));
        assertEquals(2, trainer.getCourses().size());

        trainer.getCourses().add(new Course("Art"));
        assertEquals(2, trainer.getCourses().size());

    }
}
