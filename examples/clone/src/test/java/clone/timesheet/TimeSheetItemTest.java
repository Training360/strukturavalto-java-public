package clone.timesheet;

import clone.timesheet.TimeSheetItem;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TimeSheetItemTest {

    TimeSheetItem timeSheetItem = new TimeSheetItem("John Doe", "JavaProject",
            LocalDateTime.of(2017, 4, 24, 8, 0),
            LocalDateTime.of(2017, 4, 24, 17, 30));


    @Test
    public void testCreateWithData() {
        assertThat(timeSheetItem.getEmployee(), equalTo("John Doe"));
        assertThat(timeSheetItem.getProject(), equalTo("JavaProject"));
        assertThat(timeSheetItem.getFrom(), equalTo(LocalDateTime.of(2017, 4, 24, 8, 0)));
        assertThat(timeSheetItem.getTo(), equalTo(LocalDateTime.of(2017, 4, 24, 17, 30)));
    }

    @Test
    public void testCreateBasedOnTimeSheetItem() {
        TimeSheetItem anotherTimeSheetItem = new TimeSheetItem(timeSheetItem);
        assertThat(anotherTimeSheetItem.getEmployee(), equalTo("John Doe"));
        assertThat(anotherTimeSheetItem.getProject(), equalTo("JavaProject"));
        assertThat(anotherTimeSheetItem.getFrom(), equalTo(LocalDateTime.of(2017, 4, 24, 8, 0)));
        assertThat(anotherTimeSheetItem.getTo(), equalTo(LocalDateTime.of(2017, 4, 24, 17, 30)));
    }

    @Test
    public void testCreateWithDifferentDay() {
        TimeSheetItem anotherTimeSheetItem = TimeSheetItem.withDifferentDay(timeSheetItem, LocalDate.of(2017, 4, 25));
        assertThat(anotherTimeSheetItem.getEmployee(), equalTo("John Doe"));
        assertThat(anotherTimeSheetItem.getProject(), equalTo("JavaProject"));
        assertThat(anotherTimeSheetItem.getFrom(), equalTo(LocalDateTime.of(2017, 4, 25, 8, 0)));
        assertThat(anotherTimeSheetItem.getTo(), equalTo(LocalDateTime.of(2017, 4, 25, 17, 30)));
    }
}
