package interfaces;

public class Trainer implements HasName {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return 1980;
    }
}
