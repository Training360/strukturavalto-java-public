package duration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration workDuration = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workDuration = workDuration.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        workDuration = workDuration.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        if (isEmpty(durationString)) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        try {
            workDuration = workDuration.plus(Duration.parse(durationString));
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public int calculateWorkHours() {
        return (int) workDuration.toHours();
    }

    public Duration getWorkDuration() {
        return workDuration;
    }

    public String toString() {

        Duration workObject = Duration.ZERO;
        workObject = workObject.plus(workDuration);
        long days = workObject.toDays();
        workObject = workObject.minusDays(days);
        long hours = workObject.toHours();
        workObject = workObject.minusHours(hours);
        long minutes = workObject.toMinutes();

        return "Days: " + days + ", hours: " + hours + ", minutes: " + minutes;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
