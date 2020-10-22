package course;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CourseTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorNullNameShouldThrowException() {
        String name = null;
        SimpleTime begin = new SimpleTime(1,1);

        exception.expect(IllegalArgumentException.class);

        new Course(name, begin);
    }

    @Test
    public void constructorNullBeginShouldThrowException() {
        String name = "coursename";
        SimpleTime begin = null;

        exception.expect(IllegalArgumentException.class);

        new Course(name, begin);
    }

    @Test
    public void constructorShouldInitialize() {
        String name = "courseName";
        SimpleTime begin = new SimpleTime(1,1);

        Course course = new Course(name, begin);

        assertThat(course.getName(), equalTo(name));
        assertThat(course.getBegin(), equalTo(begin));
    }

    @Test
    public void toStringShouldReturnCorrectFormat() {
        String name = "courseName";
        String beginStr = "12:05";
        SimpleTime begin = new SimpleTime(beginStr);

        Course course = new Course(name, begin);

        assertThat(course.toString(), equalTo(String.format("%s: %s", beginStr, name)));
    }

}