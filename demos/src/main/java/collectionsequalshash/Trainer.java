package collectionsequalshash;

import java.util.Objects;

public class Trainer {

    private String name;

    private int year;

    public Trainer(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return year == trainer.year &&
                Objects.equals(name, trainer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, year);
    }
}
