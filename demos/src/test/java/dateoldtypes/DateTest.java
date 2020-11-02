package dateoldtypes;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateTest {

    @Test
    public void testDate() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 1);
        Date date1 = calendar.getTime();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date2 = format.parse("2018-06-01 10:30");
        System.out.println(date2);

        String s = format.format(new Date());
        System.out.println(s);

        Date date3 = format.parse("2018-06-01 10:45");
        assertTrue(date3.after(date2));
    }
}
