package duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class WorkHoursCalculatorTest {

    private WorkHoursCalculator whc;

    @BeforeEach
    public void setUp() {
        whc = new WorkHoursCalculator();
    }

    @AfterEach
    public void tearDown() {
        whc = null;
    }


    @Test
    public void testAddWorkTimeAsDuration() {
        //Given
        whc.addWorkTime(Duration.ofHours(6));
        //Then
        assertEquals(360L, whc.getWorkDuration().toMinutes());
    }

    @Test
    public void testAddWorkTimeAsIntegers() {
        //When
        whc.addWorkTime(1, 2, 30);
        whc.addWorkTime(0, 2, 0);
        //Then
        assertEquals(1710L, whc.getWorkDuration().toMinutes());
    }

    @Test
    public void emptyParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new WorkHoursCalculator().addWorkTime(""));
        assertEquals("Parameter must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParameterShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new WorkHoursCalculator().addWorkTime("01:02:30"));
        assertEquals("Parameter must match PnDTnHnM pattern, but found: 01:02:30", ex.getMessage());
    }

    @Test
    public void testAddWorkTimeAsString() {
        //When
        whc.addWorkTime("P1DT2H30M");
        whc.addWorkTime("P0DT2H0M");
        //Then
        assertEquals(1710L, whc.getWorkDuration().toMinutes());
    }

    @Test
    public void testCalculateWorkHours() {
        //When
        whc.addWorkTime("P1DT2H30M");
        whc.addWorkTime("P0DT2H0M");
        //Then
        assertEquals(28, whc.calculateWorkHours());
    }

    @Test
    public void testToString() {
        //When
        whc.addWorkTime("P1DT2H30M");
        //Then
        assertEquals("Days: 1, hours: 2, minutes: 30", whc.toString());
    }
}
