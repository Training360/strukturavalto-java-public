package methodparam;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoundedCourseTest {

    @Test
    public void createFoundedCourse(){

        FoundedCourse foundedCourse= new FoundedCourse(new Course("Java"),1);

        assertEquals("Java", foundedCourse.getCourse().getName());
        assertEquals(1, foundedCourse.getPosition());

    }



}
