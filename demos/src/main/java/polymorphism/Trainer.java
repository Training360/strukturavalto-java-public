package polymorphism;

import java.util.List;

public class Trainer extends Human {

    private List<Course> courses;

    public Trainer(String name, List<Course> courses) {
        super(name);
        this.courses = courses;
    }

}
