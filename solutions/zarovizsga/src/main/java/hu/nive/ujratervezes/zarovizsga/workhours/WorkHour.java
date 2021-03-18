package hu.nive.ujratervezes.zarovizsga.workhours;

public class WorkHour {

    private String name;

    private int hours;

    private String date;

    public static WorkHour parseLine(String line) {
        WorkHour workHour = new WorkHour();
        String[] parts = line.split(",");
        workHour.name = parts[0];
        workHour.hours = Integer.parseInt(parts[1]);
        workHour.date = parts[2];
        return workHour;
    }

    public String toExpectedString() {
        return name + ": " + date;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getDate() {
        return date;
    }
}
