package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Felhasználónév:");
        String username = scanner.nextLine();

        System.out.println("Jelszó:");
        String password = scanner.nextLine();

        System.out.println("Jelszó még egyszer:");
        String password2 = scanner.nextLine();

        System.out.println("Email cím:");
        String email = scanner.nextLine();

        UserValidator userValidator = new UserValidator();

        System.out.println(userValidator.isValidUsername(username) ? "felhasználónév rendben" : "felhasználónév helytelen");
        System.out.println(userValidator.isValidPassword(password, password2) ? "jelszó rendben" : "jelszó helytelen");
        System.out.println(userValidator.isValidEmail(email) ? "e-mail rendben" : "e-mail helytelen");
    }
}
