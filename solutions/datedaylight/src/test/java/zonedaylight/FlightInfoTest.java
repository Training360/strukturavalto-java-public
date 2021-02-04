package zonedaylight;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FlightInfoTest {

    public static final String PATTERN = "HHmm, dd MMM yyyy";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH);


    @Test
    public void emptyDateStringShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FlightInfo(null, PATTERN, Locale.ENGLISH, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        });
        assertEquals("Empty date string parameter!", ex.getMessage());
    }

    @Test
    public void emptyPatternStringShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new FlightInfo("xyz", "", Locale.ENGLISH, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        });
        assertEquals("Empty pattern string parameter!", ex.getMessage());
    }

    @Test
    public void nullLocaleShouldThrowException() throws NullPointerException {

        Exception ex = assertThrows(NullPointerException.class, () -> {
            new FlightInfo("xyz", "xyz", null, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        });
        assertEquals("Locale must not be null!", ex.getMessage());
    }

    @Test
    public void testGetDepartureDateTime() {
        //Given
        FlightInfo fi = new FlightInfo("1830, 14 Mar 2013", PATTERN, Locale.ENGLISH, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        //Then
        assertEquals("1830, 14 Mar 2013", FORMATTER.format(fi.getDepartureDateTime()));
    }

    @Test
    public void testGetArrivalDateTimeWDifferentDSTPolicy() {
        //Given
        FlightInfo fi = new FlightInfo("1830, 14 Mar 2013", PATTERN, Locale.ENGLISH, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        //Then
        assertEquals("1300, 15 Mar 2013", FORMATTER.format(fi.getArrivalDateTime(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")), 10, 30)));
    }

    @Test
    public void testGetArrivalDateTime() {
        //Given
        FlightInfo fi = new FlightInfo("1830, 14 Apr 2013", PATTERN, Locale.ENGLISH, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        //Then
        assertEquals("1400, 15 Apr 2013", FORMATTER.format(fi.getArrivalDateTime(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")), 10, 30)));
    }
}
