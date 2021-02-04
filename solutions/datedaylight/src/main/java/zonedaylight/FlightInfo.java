package zonedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private ZonedDateTime departureDateTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {

        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }

        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }

        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        LocalDateTime ldt = getLocalDateTime(dateString, pattern, locale);
        this.departureDateTime = ldt.atZone(zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {

        return departureDateTime.withZoneSameInstant(zone).plusHours(flightHours).plusMinutes(flightMinutes);
    }

    public ZonedDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    private LocalDateTime getLocalDateTime(String dateString, String pattern, Locale locale) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return LocalDateTime.parse(dateString, formatter);
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
