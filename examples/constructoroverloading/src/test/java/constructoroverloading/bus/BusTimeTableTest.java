package constructoroverloading.bus;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BusTimeTableTest {

    private static final List<SimpleTime> TIME_TABLE = Arrays.asList(
            new SimpleTime(9, 15),
            new SimpleTime(12, 45),
            new SimpleTime(14, 15),
            new SimpleTime(16, 15),
            new SimpleTime(18, 15)
    );

    @Test
    public void constructorTestList() {
        //Given
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);
        // When
        assertEquals(5, timetable.getTimeTable().size());
        assertEquals(9, timetable.getTimeTable().get(0).getHours());
        assertEquals(15, timetable.getTimeTable().get(4).getMinutes());
    }

    @Test
    public void constructorTestHours() {
        //Given
        BusTimeTable timetable = new BusTimeTable(14, 16, 30);
        // When
        assertEquals(3, timetable.getTimeTable().size());
        assertEquals(14, timetable.getTimeTable().get(0).getHours());
        assertEquals(30, timetable.getTimeTable().get(0).getMinutes());
        assertEquals(16, timetable.getTimeTable().get(2).getHours());
    }

    @Test
    public void testNextBus() {
        //Given
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);
        // When
        assertEquals("14:15", timetable.nextBus(new SimpleTime(13, 15)).toString());
    }

    @Test
    public void nextBusShouldThrowExceptionIfNone() throws IllegalStateException {
        BusTimeTable timetable = new BusTimeTable(TIME_TABLE);

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            timetable.nextBus(new SimpleTime(18, 16));
        });
        assertEquals("No more buses today!", ex.getMessage());
    }
}