package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime time;

    public Rendezvous(int hour, int minute) {
        time = LocalTime.of(hour, minute);
    }

    public Rendezvous(String timeString, String pattern) {
        validatePattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            time = LocalTime.parse(timeString, formatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
    }

    public String toString(String pattern){
        validatePattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(time);
    }

    public int countMinutesLeft(LocalTime base) {
        int timeToGo = (int) ChronoUnit.MINUTES.between(base, time);
        if (timeToGo <= 0) {
            throw new MissedOpportunityException("Too late!");
        }
        return timeToGo;
    }

    public void pushLater(int hour, int minute) {
        time = time.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        time = time.minusHours(hour).minusMinutes(minute);
    }

    private void validatePattern(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
