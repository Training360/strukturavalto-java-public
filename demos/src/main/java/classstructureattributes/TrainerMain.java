package classstructureattributes;

public class TrainerMain {

    public static void main(String[] args) {
        Trainer trainer = new Trainer();
        trainer.name = "John Doe";
        trainer.yearOfBirth = 1980;
        System.out.println(trainer.name);
        System.out.println(trainer.yearOfBirth);

        Trainer anotherTrainer = new Trainer();
        anotherTrainer.name = "Jack Doe";
        System.out.println(anotherTrainer.name);
    }
}
