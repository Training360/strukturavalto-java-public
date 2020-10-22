package virtualmethod;

public class Human implements HasName {

    private static final int DEFAULT_FREE_TIME = 4;
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getFreeTime() {
        return DEFAULT_FREE_TIME;
    }
}
