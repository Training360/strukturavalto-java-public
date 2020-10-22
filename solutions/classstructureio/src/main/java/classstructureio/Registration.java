package classstructureio;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        System.out.println("Regisztráció");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Név:");
        String name = scanner.nextLine();

        System.out.println("Email cím:");
        String email = scanner.nextLine();

        System.out.println("Sikeres regisztráció");
        System.out.println("Regisztrált név: " + name);
        System.out.println("Regisztrált email cím: " + email);
    }
}
