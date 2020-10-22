package virtualmethod;

import java.util.List;

public class Trainer extends Human {

    private List<Course> courses;

    public Trainer(String name, List<Course> courses) {
        super(name);
        this.courses = courses;
    }

    @Override
    public int getFreeTime() {
        return Math.max(super.getFreeTime() - courses.size(), 0);
    }
}
