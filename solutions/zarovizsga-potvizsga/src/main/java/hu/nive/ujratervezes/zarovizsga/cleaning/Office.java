package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    public static int CLEANING_PRICE = 100;

    private String address;
    private int area;
    private int numberOfLevels;
    private BuildingType type = BuildingType.OFFICE;

    public Office(String address, int area, int numberOfLevels) {
        this.address = address;
        this.area = area;
        this.numberOfLevels = numberOfLevels;
    }

    public BuildingType getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    @Override
    public int clean() {
        return area * numberOfLevels * CLEANING_PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
