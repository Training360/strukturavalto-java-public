package inheritanceconstructor.classroom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    public void constructorTest() {
        //Given
        Course course = new Course(20, Facility.COMPUTERS);
        //Then
        assertEquals(20, course.getParticipants());
        assertEquals(Facility.COMPUTERS, course.getFacilityNeeded());
    }
}