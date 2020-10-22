package abstractclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CourseTest {

    @Test
    public void testCreate() {
        Course course = new Course("Math");
        assertThat(course.getName(), equalTo("Math"));
        assertThat(course.isTaken(), is(false));
    }

    @Test
    public void testTake() {
        Course course = new Course("Math");
        course.setTaken(true);
        assertThat(course.isTaken(), is(true));
    }
}
