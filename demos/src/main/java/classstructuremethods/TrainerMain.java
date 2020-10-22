package classstructuremethods;

public class TrainerMain {

    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        trainer.setName("John Doe");
        trainer.setYearOfBirth(1980);
        System.out.println(trainer.getName());
        System.out.println(trainer.getYearOfBirth());

        Trainer anotherTrainer = new Trainer();
        anotherTrainer.setName("Jack Doe");
        anotherTrainer.setYearOfBirth(1981);
        System.out.println(anotherTrainer.getName());

        System.out.println(anotherTrainer.getName());
        System.out.println(anotherTrainer.getNameAndYearOfBirth());

        anotherTrainer.changeName("Joe Doe");
        System.out.println(anotherTrainer.getName());

        anotherTrainer.setName("Jack Doe");
        System.out.println(anotherTrainer.getName());
    }
}
