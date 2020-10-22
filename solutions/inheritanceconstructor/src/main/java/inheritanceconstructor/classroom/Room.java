package inheritanceconstructor.classroom;

public class Room {

    private String location;
    private int capacity;

    public Room(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }
}
