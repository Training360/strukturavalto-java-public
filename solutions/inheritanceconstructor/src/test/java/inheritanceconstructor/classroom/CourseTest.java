package inheritanceconstructor.classroom;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CourseTest {

    @Test
    public void constructorTest() {
        //Given
        Course course = new Course(20, Facility.COMPUTERS);
        //Then
        assertThat(course.getParticipants(), equalTo(20));
        assertThat(course.getFacilityNeeded(), equalTo(Facility.COMPUTERS));
    }
}