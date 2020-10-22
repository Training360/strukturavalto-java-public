package methodparam;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    public enum Answer {YES, NO, MAYBE}

    private String name;

    private int age;

    private List<Course> courses = new ArrayList<>();

    public Trainer() {
    }

    public void setAge(int ageParam) {
        if (ageParam < 10) {
            throw new IllegalArgumentException("Invalid age: " + ageParam);
        }
        this.age = ageParam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void changeData(TrainerData trainerData) {
        this.name = trainerData.getName();
        this.age = trainerData.getAge();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
