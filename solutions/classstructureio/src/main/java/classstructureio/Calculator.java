package classstructureio;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg az első egész számot: ");
        int number1 = scanner.nextInt();
        System.out.println("Add meg a második egész számot: ");
        int number2 = scanner.nextInt();
        System.out.println(number1 + " + " + number2);
        System.out.println(number1 + number2);
    }
}
