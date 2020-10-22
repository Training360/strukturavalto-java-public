package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private final String name;

    private final int age;

    private final List<Course> courses;

    public Trainer(String name, int age, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.courses = Collections.unmodifiableList(new ArrayList<>(courses));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

}
