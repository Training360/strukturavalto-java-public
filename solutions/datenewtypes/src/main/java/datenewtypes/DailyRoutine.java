package introdate;

import java.time.LocalTime;

public class DailyRoutine {

    LocalTime startTime;

    public DailyRoutine(int hour, int minute) {
        this.startTime = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String timeString) {
        this.startTime = LocalTime.parse(timeString);
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setFutureTime(int minutes) {
        this.startTime = this.startTime.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return this.startTime.isBefore(LocalTime.NOON);
    }

    public static void main(String[] args) {

        DailyRoutine dr = new DailyRoutine(9, 0);
        System.out.println(dr.getStartTime());
        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        System.out.println(dailyRoutine.getStartTime());
        dr.setFutureTime( 3 * 45 + 20);
        System.out.println(dr.getStartTime());
        System.out.println(dr.isBeforeNoon());
    }
}
