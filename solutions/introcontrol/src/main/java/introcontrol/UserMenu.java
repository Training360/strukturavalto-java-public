package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();

        if (selected == 1) {
            System.out.println("Felhasználók listázása");
        }
        if (selected == 2) {
            System.out.println("Felhasználó felvétele");
        }
    }
}
