package constructoroverloading.bus;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BusTimeTableTest {

    private static final List<SimpleTime> TIME_TABLE = Arrays.asList(
            new SimpleTime(9, 15),
            new SimpleTime(12, 45),
            new SimpleTime(14, 15),
            new SimpleTime(16, 15),
            new SimpleTime(18, 15)
    );

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorTestList() {
        //Given
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);
        // When
        assertThat(timetable.getTimeTable().size(), equalTo(5));
        assertThat(timetable.getTimeTable().get(0).getHours(), equalTo(9));
        assertThat(timetable.getTimeTable().get(4).getMinutes(), equalTo(15));
    }

    @Test
    public void constructorTestHours() {
        //Given
        BusTimeTable timetable = new BusTimeTable(14, 16, 30);
        // When
        assertThat(timetable.getTimeTable().size(), equalTo(3));
        assertThat(timetable.getTimeTable().get(0).getHours(), equalTo(14));
        assertThat(timetable.getTimeTable().get(0).getMinutes(), equalTo(30));
        assertThat(timetable.getTimeTable().get(2).getHours(), equalTo(16));
    }

    @Test
    public void testNextBus() {
        //Given
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);
        // When
        assertThat(timetable.nextBus(new SimpleTime(13, 15)).toString(), equalTo("14:15"));
    }

    @Test
    public void nextBusShouldThrowExceptionIfNone() throws IllegalStateException {
        // Given
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);
        exception.expect(IllegalStateException.class);
        exception.expectMessage("No more buses today!");
        //When
        timetable.nextBus(new SimpleTime(18, 16));
    }
}