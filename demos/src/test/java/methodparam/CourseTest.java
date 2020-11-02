package methodparam;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    public void createCourse(){

        Course course = new Course("Java");

        assertEquals("Java", course.getName());
    }



}
