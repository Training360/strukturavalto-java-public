package methodparam;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CourseTest {

    @Test
    public void createCourse(){

        Course course = new Course("Java");

        assertThat(course.getName(),is("Java"));

    }



}
