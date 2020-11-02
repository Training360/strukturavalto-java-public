package clone.timesheet;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimeSheetItemTest {

    TimeSheetItem timeSheetItem = new TimeSheetItem("John Doe", "JavaProject",
            LocalDateTime.of(2017, 4, 24, 8, 0),
            LocalDateTime.of(2017, 4, 24, 17, 30));


    @Test
    public void testCreateWithData() {
        assertEquals("John Doe", timeSheetItem.getEmployee());
        assertEquals("JavaProject", timeSheetItem.getProject());
        assertEquals(LocalDateTime.of(2017, 4, 24, 8, 0), timeSheetItem.getFrom());
        assertEquals(LocalDateTime.of(2017, 4, 24, 17, 30), timeSheetItem.getTo());
    }

    @Test
    public void testCreateBasedOnTimeSheetItem() {
        TimeSheetItem anotherTimeSheetItem = new TimeSheetItem(timeSheetItem);
        assertEquals("John Doe", anotherTimeSheetItem.getEmployee());
        assertEquals("JavaProject", anotherTimeSheetItem.getProject());
        assertEquals(LocalDateTime.of(2017, 4, 24, 8, 0), anotherTimeSheetItem.getFrom());
        assertEquals(LocalDateTime.of(2017, 4, 24, 17, 30), anotherTimeSheetItem.getTo());
    }

    @Test
    public void testCreateWithDifferentDay() {
        TimeSheetItem anotherTimeSheetItem = TimeSheetItem.withDifferentDay(timeSheetItem, LocalDate.of(2017, 4, 25));
        assertEquals("John Doe", anotherTimeSheetItem.getEmployee());
        assertEquals("JavaProject", anotherTimeSheetItem.getProject());
        assertEquals(LocalDateTime.of(2017, 4, 25, 8, 0), anotherTimeSheetItem.getFrom());
        assertEquals(LocalDateTime.of(2017, 4, 25, 17, 30), anotherTimeSheetItem.getTo());
    }
}
