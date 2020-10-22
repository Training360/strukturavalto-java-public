package methodparam;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FoundedCourseTest {

    @Test
    public void createFoundedCourse(){

        FoundedCourse foundedCourse= new FoundedCourse(new Course("Java"),1);

        assertThat(foundedCourse.getCourse().getName(),is("Java"));
        assertThat(foundedCourse.getPosition(),is(1));

    }



}
