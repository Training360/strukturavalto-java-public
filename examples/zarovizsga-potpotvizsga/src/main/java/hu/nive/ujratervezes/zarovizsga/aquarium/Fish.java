package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    private String name;

    protected int weight;

    private String color;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean hasMemoryLoss();

    public abstract void feed();

    public String getStatus() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %s", name, weight, color, hasMemoryLoss());
    }


}
