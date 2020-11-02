package abstractclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void testCreate() {
        Course course = new Course("Math");
        assertEquals("Math", course.getName());
        assertFalse(course.isTaken());
    }

    @Test
    public void testTake() {
        Course course = new Course("Math");
        course.setTaken(true);
        assertTrue(course.isTaken());
    }
}
