package inheritanceconstructor.classroom;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClassRoomTest {

    @Test
    public void constructorTest() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.CHALKBOARD);
        //Then
        assertThat(classroom.getLocation(), equalTo("122"));
        assertThat(classroom.getCapacity(), equalTo(20));
        assertThat(classroom.getFacility(), equalTo(Facility.CHALKBOARD));
    }

    @Test
    public void isSuitableSuccess() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.COMPUTERS);
        Course course = new Course(15, Facility.COMPUTERS);
        //Then
        assertThat(classroom.isSuitable(course), equalTo(true));

    }

    @Test
    public void isSuitableFail() {
        //Given
        ClassRoom classroom = new ClassRoom("122", 20, Facility.COMPUTERS);
        Course course = new Course(15, Facility.CHALKBOARD);
        //Then
        assertThat(classroom.isSuitable(course), equalTo(false));
    }
}