package zonedaylight;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WorkHoursCalculatorTest {

    public static final String PATTERN = "HHmm, dd MMM yyyy";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN, Locale.ENGLISH);

    @Test
    public void testGetStartDateTime() {
        // When
        WorkHoursCalculator whc = new WorkHoursCalculator(2013, Month.MARCH, 5, 1, ZoneId.of("America/Chicago"));
        //Then
        assertEquals("0100, 05 Mar 2013", FORMATTER.format(whc.getStartDateTime()));
    }

    @Test
    public void testCalculateHoursInMarch() {
        // Given
        Month month = Month.MARCH;
        // When/
        WorkHoursCalculator whc = new WorkHoursCalculator(2013, month, 1, 1, ZoneId.of("America/Chicago"));
        //Then
        assertEquals(359L, whc.calculateHours(2013, month, 16, 1));
    }

    @Test
    public void testCalculateHoursInApril() {
        // Given
        Month month = Month.APRIL;
        // When/
        WorkHoursCalculator whc = new WorkHoursCalculator(2013, month, 1, 1, ZoneId.of("America/Chicago"));
        //Then
        assertEquals(360L, whc.calculateHours(2013, month, 16, 1));
    }

    @Test
    public void testCalculateHoursInNovember() {
        // Given
        Month month = Month.NOVEMBER;
        // When/
        WorkHoursCalculator whc = new WorkHoursCalculator(2013, month, 1, 1, ZoneId.of("America/Chicago"));
        //Then
        assertEquals(361L, whc.calculateHours(2013, month, 16, 1));
    }

    @Test
    public void testCalculateHoursBetweenMonths() {
        // When/
        WorkHoursCalculator whc = new WorkHoursCalculator(2013, Month.MARCH, 1, 1, ZoneId.of("America/Chicago"));
        //Then
        assertEquals(983L, whc.calculateHours(2013, Month.APRIL, 11, 1));
    }
}
