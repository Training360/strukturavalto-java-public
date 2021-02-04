package dateperiod;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PensionCalculatorTest {


    @Test
    public void testSumEmploymentPeriods() {
        //Given
        PensionCalculator pc = new PensionCalculator();
        pc.addEmploymentPeriod(Period.parse("p2y2m4d"));
        pc.addEmploymentPeriod(Period.of(1, 12, 3));

        //Then
        assertEquals(4, pc.sumEmploymentPeriods().getYears());
        assertEquals(2, pc.sumEmploymentPeriods().getMonths());
        assertEquals(7, pc.sumEmploymentPeriods().getDays());
        assertEquals("P4Y2M7D", pc.sumEmploymentPeriods().toString());
    }

    @Test
    public void testModifyByDays() {
        // Given
        Period period = Period.of(1, 2, 10);
        PensionCalculator pc = new PensionCalculator();

        //Then
        assertEquals(475, pc.calculateTotalDays(pc.modifyByDays(period, 40)));
        assertEquals(395, pc.calculateTotalDays(pc.modifyByDays(period, -40)));
    }

    @Test
    public void nullParameterShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> {
            new PensionCalculator().getPeriodBetweenDates(null, LocalDate.of(2005, 2, 5));
        });
        assertEquals("Null parameters are not allowed!", ex.getMessage());
    }

    @Test
    public void testGetPeriodBetweenDates() {//
        //Given
        PensionCalculator pc = new PensionCalculator();
        //When
        Period period = pc.getPeriodBetweenDates(LocalDate.of(2000, 1, 3), LocalDate.of(2005, 2, 5));
        //Then
        assertEquals(1857, pc.calculateTotalDays(period));
    }

    @Test
    public void emptyFromDateParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PensionCalculator().getPeriodBetweenDates("", "2010-12-01", "yyyy-MM-dd");
        });
        assertEquals("Empty from date string, cannot use: ", ex.getMessage());
    }

    @Test
    public void emptyToDateParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PensionCalculator().getPeriodBetweenDates("2010-12-01", "", "yyyy-MM-dd");
        });
        assertEquals("Empty to date string, cannot use: ", ex.getMessage());
    }

    @Test
    public void emptyPatternParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new PensionCalculator().getPeriodBetweenDates("2010-12-01", "2012-04-05", "");
        });
        assertEquals("Empty pattern string, cannot use: ", ex.getMessage());
    }

    @Test
    public void testGetPeriodBetweenStringDates() {//
        //Given
        PensionCalculator pc = new PensionCalculator();
        //When
        Period period = pc.getPeriodBetweenDates("2010-12-01", "2012-12-01", "yyyy-MM-dd");
        //Then
        assertEquals(730, pc.calculateTotalDays(period));
    }
}
