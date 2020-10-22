package abstractclass;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Human {

    public Trainer(String name, List<Course> courses) {
        super(name);
        this.courses = courses;
    }

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void work() {
        for (Course course: courses) {
            take(course);
        }
    }

    private void take(Course course) {
        course.setTaken(true);
    }
}
