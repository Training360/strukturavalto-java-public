package methodchain;

public class TrainerBuilder {

    private String name;

    private int age;

    public TrainerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TrainerBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public Trainer build() {
        return new Trainer(name, age);
    }
}
