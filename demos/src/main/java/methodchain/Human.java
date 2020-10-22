package methodchain;

public class Human {

    private String name;
    private String pet;
    private String favouriteCar;
    private int countOfChildren;

    public Human(String name) {
        this.name = name;
    }

    public Human setPet(String pet) {
        this.pet = pet;
        return this;
    }

    public Human setFavouriteCar(String favouriteCar) {
        this.favouriteCar = favouriteCar;
        return this;
    }

    public Human setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getPet() {
        return pet;
    }

    public String getFavouriteCar() {
        return favouriteCar;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }



}
