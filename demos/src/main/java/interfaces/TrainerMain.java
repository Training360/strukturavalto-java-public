package interfaces;

public class TrainerMain {

    public static void main(String[] args) {
//        Trainer trainer = new Trainer();
//        Human human = trainer;

//        Human human = new Trainer();

        HasName trainer = new Trainer();
        trainer.getName();

        HasName course = new Course();

    }
}
