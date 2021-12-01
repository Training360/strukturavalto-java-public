package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;

    private int areaPerLevel;

    private int level;

    public Office(String address, int areaPerLevel, int level) {
        this.address = address;
        this.areaPerLevel = areaPerLevel;
        this.level = level;
    }

    @Override
    public int clean() {
        return areaPerLevel * level * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
