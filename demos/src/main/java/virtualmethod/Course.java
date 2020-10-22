package virtualmethod;

public class Course implements HasName {

    private String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
