package introdate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Performance {

    private String artist;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance(String artist, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.artist = artist;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getInfo() {
        return artist + ": " + date + " " + startTime + " - " + endTime;
    }

    public String getArtist() {
        return artist;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
