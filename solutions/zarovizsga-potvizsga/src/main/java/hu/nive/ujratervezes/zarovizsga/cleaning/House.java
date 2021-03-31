package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {


    public static int CLEANING_PRICE=80;

    private String address;
    private int area;
    private BuildingType type = BuildingType.HOUSE;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    public BuildingType getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    @Override
    public int clean() {
        return area*CLEANING_PRICE;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
