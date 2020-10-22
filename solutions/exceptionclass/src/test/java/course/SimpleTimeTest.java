package course;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleTimeTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorIntIntInvalidHourShouldThrowException() {
        int hour = 24;
        int minute = 1;

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Hour is invalid (0-23)");

        new SimpleTime(hour, minute);
    }

    @Test
    public void constructorIntIntInvalidMinuteShouldThrowException() {
        int hour = 1;
        int minute = 60;

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Minute is invalid (0-59)");

        new SimpleTime(hour, minute);

    }

    @Test
    public void constructorIntIntShouldInitialize() {
        int hour = 1;
        int minute = 1;

        SimpleTime simpleTime = new SimpleTime(hour, minute);

        assertThat(simpleTime.getHour(), equalTo(hour));
        assertThat(simpleTime.getMinute(), equalTo(minute));
    }

    @Test
    public void constructorStringNullParameterShouldThrowException() {
        String timeStr = null;

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Time is null");

        new SimpleTime(timeStr);
    }

    @Test
    public void constructorStringInvalidLengthShouldThrowException() {
        String timeStr = "aa";

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Time is not hh:mm");

        new SimpleTime(timeStr);
    }

    @Test
    public void constructorStringInvalidDelimiterShouldThrowException() {
        String timeStr = "12,23";

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Time is not hh:mm");

        new SimpleTime(timeStr);
    }

    @Test
    public void constructorStringInvalidNumberShouldThrowException() {
        String timeStr = "a1:23";

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Time is not hh:mm");

        new SimpleTime(timeStr);
    }
    @Test
    public void constructorStringInvalidHourShouldThrowException() {
        String timeStr = "24:23";

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Hour is invalid (0-23)");

        new SimpleTime(timeStr);
    }

    @Test
    public void constructorStringInvalidMinuteShouldThrowException() {
        String timeStr = "12:60";

        exception.expect(InvalidTimeException.class);
        exception.expectMessage("Minute is invalid (0-59)");

        new SimpleTime(timeStr);
    }

    @Test
    public void constructorStringShouldInitialize() {
        String timeStr = "01:12";

        SimpleTime simpleTime = new SimpleTime(timeStr);

        assertThat(simpleTime.getHour(), equalTo(1));
        assertThat(simpleTime.getMinute(), equalTo(12));
    }

    @Test
    public void toStringShouldReturnCorrectFormat() {
        int hour = 1;
        int minute = 12;

        SimpleTime simpleTime = new SimpleTime(hour, minute);

        assertThat(simpleTime.toString(), equalTo(String.format("%02d:%02d", hour, minute)));
    }

}