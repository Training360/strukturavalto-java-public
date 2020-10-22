package abstractclass;

public abstract class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void work();
}
