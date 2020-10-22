package abstractclass;

public class Course {

    private String name;

    private boolean taken;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
