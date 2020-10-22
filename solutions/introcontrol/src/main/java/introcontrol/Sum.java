package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Adj meg öt számot!");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Add meg a " + (i + 1) + ". számot!");
            int number = scanner.nextInt();
            sum += number;
        }
        System.out.println("Az összeg: " + sum);
    }
}
