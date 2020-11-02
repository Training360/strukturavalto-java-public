package references;

public class TrainerMain {

    public static void main(String[] args) {
        int year = 1980;

        String name = "John Doe";

        Trainer john = new Trainer("John Doe", 1980);

        Trainer trainer = john;

        System.out.println(john == trainer);

        Trainer john2 = new Trainer("John Doe", 1980);

        System.out.println(trainer == john2);
    }
}
