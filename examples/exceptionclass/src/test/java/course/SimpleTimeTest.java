package course;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleTimeTest {


    @Test
    public void constructorIntIntInvalidHourShouldThrowException() {
        int hour = 24;
        int minute = 1;

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(hour, minute));
        assertEquals("Hour is invalid (0-23)", itex.getMessage());
    }

    @Test
    public void constructorIntIntInvalidMinuteShouldThrowException() {
        int hour = 1;
        int minute = 60;

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(hour, minute));
        assertEquals("Minute is invalid (0-59)", itex.getMessage());

    }

    @Test
    public void constructorIntIntShouldInitialize() {
        int hour = 1;
        int minute = 1;

        SimpleTime simpleTime = new SimpleTime(hour, minute);

        assertEquals(1, simpleTime.getHour());
        assertEquals(1, simpleTime.getMinute());
    }

    @Test
    public void constructorStringNullParameterShouldThrowException() {
        String timeStr = null;

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Time is null", itex.getMessage());
    }

    @Test
    public void constructorStringInvalidLengthShouldThrowException() {
        String timeStr = "aa";

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Time is not hh:mm", itex.getMessage());
    }

    @Test
    public void constructorStringInvalidDelimiterShouldThrowException() {
        String timeStr = "12,23";

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Time is not hh:mm", itex.getMessage());
    }

    @Test
    public void constructorStringInvalidNumberShouldThrowException() {
        String timeStr = "a1:23";

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Time is not hh:mm", itex.getMessage());
    }

    @Test
    public void constructorStringInvalidHourShouldThrowException() {
        String timeStr = "24:23";

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Hour is invalid (0-23)", itex.getMessage());
    }

    @Test
    public void constructorStringInvalidMinuteShouldThrowException() {
        String timeStr = "12:60";

        InvalidTimeException itex = assertThrows(InvalidTimeException.class, () -> new SimpleTime(timeStr));
        assertEquals("Minute is invalid (0-59)", itex.getMessage());
    }

    @Test
    public void constructorStringShouldInitialize() {
        String timeStr = "01:12";

        SimpleTime simpleTime = new SimpleTime(timeStr);

        assertEquals(1,simpleTime.getHour());
        assertEquals(12,simpleTime.getMinute());
    }

    @Test
    public void toStringShouldReturnCorrectFormat() {
        int hour = 1;
        int minute = 12;

        SimpleTime simpleTime = new SimpleTime(hour, minute);

        assertEquals(String.format("%02d:%02d", hour, minute),simpleTime.toString());
    }

}