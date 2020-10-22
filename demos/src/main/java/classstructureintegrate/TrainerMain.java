package classstructureintegrate;

import java.util.Scanner;

public class TrainerMain {

    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Year of birth?");
        int yearOfBirth = scanner.nextInt();

        Trainer trainer = new Trainer(name, yearOfBirth);

        System.out.println(trainer.getNameAndYearOfBirth());
    }
}
