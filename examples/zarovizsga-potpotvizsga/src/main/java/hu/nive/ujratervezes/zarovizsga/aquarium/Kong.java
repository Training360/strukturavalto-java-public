package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish {

    public Kong(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }

    public void feed() {
        weight += 2;
    }
}
