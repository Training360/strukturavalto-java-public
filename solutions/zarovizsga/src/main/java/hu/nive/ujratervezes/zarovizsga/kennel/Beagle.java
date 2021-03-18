package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        increaseHappiness(2);
    }

    @Override
    public void play(int hours) {
        increaseHappiness(hours * 2);
    }
}
