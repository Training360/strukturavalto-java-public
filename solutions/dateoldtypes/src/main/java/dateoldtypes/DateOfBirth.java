package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {

    private Date dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);
        this.dateOfBirth = calendar.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        setDateOfBirth(dateString, new SimpleDateFormat(pattern, locale));
    }

    public DateOfBirth(String dateString, String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        setDateOfBirth(dateString, new SimpleDateFormat(pattern));
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(dateOfBirth);
    }

    public boolean isWeekDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);
        return calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }

    private void setDateOfBirth(String dateString, DateFormat dateFormat) {
        try {
            dateOfBirth = dateFormat.parse(dateString);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateString, pe);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
