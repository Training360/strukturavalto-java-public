package course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {

    @Test
    public void constructorNullNameShouldThrowException() {
        String name = null;
        SimpleTime begin = new SimpleTime(1, 1);

        assertThrows(IllegalArgumentException.class, () -> new Course(name, begin));
    }

    @Test
    public void constructorNullBeginShouldThrowException() {
        String name = "coursename";
        SimpleTime begin = null;

        assertThrows(IllegalArgumentException.class, () -> new Course(name, begin));

    }

    @Test
    public void constructorShouldInitialize() {
        String name = "courseName";
        SimpleTime begin = new SimpleTime(1, 1);

        Course course = new Course(name, begin);

        assertEquals(name, course.getName());
        assertEquals(begin, course.getBegin());
    }

    @Test
    public void toStringShouldReturnCorrectFormat() {
        String name = "courseName";
        String beginStr = "12:05";
        SimpleTime begin = new SimpleTime(beginStr);

        Course course = new Course(name, begin);

        assertEquals(String.format("%s: %s", beginStr, name), course.toString());
    }

}