package timesheet;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TimeSheetItemTest {

    TimeSheetItem timeSheetItem = new TimeSheetItem(
            new Employee("John", "Connor"),
            new Project("Java"),
            LocalDateTime.of(2013, Month.JANUARY, 27, 8, 0, 0),
            LocalDateTime.of(2013, Month.JANUARY, 27, 16, 10, 0)
    );


    @Test
    public void createTimeSheetItem() {

        assertEquals("John Connor", timeSheetItem.getEmployee().getName());
        assertEquals("Java", timeSheetItem.getProject().getName());
        assertEquals(LocalDateTime.of(2013, Month.JANUARY, 27, 8, 0, 0), timeSheetItem.getBeginDate());
        assertEquals(LocalDateTime.of(2013, Month.JANUARY, 27, 16, 10, 0), timeSheetItem.getEndDate());
    }

    @Test
    public void notSameDateTest() {
        assertThrows(IllegalArgumentException.class, () -> new TimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 26, 8, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 27, 16, 10, 0)
        ));


    }

    @Test
    public void beginDateLaterThanEndTest() {
        assertThrows(IllegalArgumentException.class, () -> new TimeSheetItem(
                new Employee("John", "Connor"),
                new Project("Java"),
                LocalDateTime.of(2013, Month.JANUARY, 27, 16, 0, 0),
                LocalDateTime.of(2013, Month.JANUARY, 27, 8, 10, 0)
        ));
    }


    @Test
    public void countDifferenceBetweenDatesTest() {
        assertEquals(8L, timeSheetItem.hoursBetweenDates());
    }
}