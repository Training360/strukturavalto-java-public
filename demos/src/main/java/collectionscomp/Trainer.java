package collectionscomp;

import java.util.Objects;

public class Trainer implements Comparable<Trainer> {

    private String name;

    private int salary;

    public Trainer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Trainer o) {
        return this.name.compareTo(o.name);
        //return this.salary - o.salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        //return this.name.equals(trainer.name);
        return salary == trainer.salary;
    }

    @Override
    public int hashCode() {

        return Objects.hash(salary);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
