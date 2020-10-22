package constructoroverloading;

public class Trainer {

    public static final String DEFAULT_NAME = "anonymous";
    public static final int DEFAULT_AGE = 20;
    private String name;

    private int age;

    public Trainer() {
        this(DEFAULT_NAME);
    }

    public Trainer(String name) {
        this(name, DEFAULT_AGE);
    }

    public Trainer(String name, int age) {
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
