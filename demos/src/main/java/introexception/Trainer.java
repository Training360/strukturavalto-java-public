package introexception;

public class Trainer {

    public static final int MIN_AGE = 18;

    private String name;

    private int age;

    public Trainer(String name, int age) {
        if (age <= MIN_AGE) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
