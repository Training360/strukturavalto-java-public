package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Clownfish extends Fish {

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }

    @Override
    public void feed() {
        weight++;
    }
}
