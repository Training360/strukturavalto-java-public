package datenewtypes;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(int year, Month month, int day) {
        this(year, month.getValue(), day);
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        validatePattern(pattern);
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        setDateOfBirth(dateString, formatter);
    }

    public DateOfBirth(String dateString, String pattern) {
        validatePattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        setDateOfBirth(dateString, formatter);
    }
	
	   public DateOfBirth(String dateString) {

        this.dateOfBirth = LocalDate.parse(dateString);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate birthdayLater) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return birthdayLater.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public int countDaysSinceBirth(LocalDate base) {
        if (base.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, base);
    }

    public int countDaysBetween(DateOfBirth other) {
        if (other == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, other.dateOfBirth);
    }
	
	   public boolean wasItALeapYear(){
        return dateOfBirth.isLeapYear();
    }

    public String findBirthDayOfWeekLater(int year){
        LocalDate later = dateOfBirth.plusYears(year);
        return findDayOfWeekForBirthDate(Locale.ENGLISH, later);
    }

    public String toString(String pattern) {
        validatePattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(dateOfBirth);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private void setDateOfBirth(String dateString, DateTimeFormatter formatter) {
        validatePattern(dateString);
        try {
            dateOfBirth = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Illegal date string: " + dateString);
        }
    }

    private void validatePattern(String pattern) throws IllegalArgumentException {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
