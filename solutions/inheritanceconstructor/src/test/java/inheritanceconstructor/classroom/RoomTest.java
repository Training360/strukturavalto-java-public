package inheritanceconstructor.classroom;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RoomTest {

    @Test
    public void constructorTest() {
        //Given
        Room room = new Room("I. em. 12.", 20);
        //Then
        assertThat(room.getLocation(), equalTo("I. em. 12."));
        assertThat(room.getCapacity(), equalTo(20));
    }
}