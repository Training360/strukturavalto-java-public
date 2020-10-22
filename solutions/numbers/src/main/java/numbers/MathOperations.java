package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        String problem = "3 / 8 + 7 / (8 - 2)";
        double result = 3 / 8.0 + 7.0 / (8 - 2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az eredmény? Négy tizedes jegy pontossággal add meg!");
        System.out.println(problem);

        double resultByUser = scanner.nextDouble();

        if (Math.abs(result - resultByUser) < 0.0001) {
            System.out.println("Helyes eredmény");
        } else {
            System.out.println("Nem jó az eredmény");
        }
    }
}
