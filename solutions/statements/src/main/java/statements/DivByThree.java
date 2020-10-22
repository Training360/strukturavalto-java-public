package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {
        System.out.println("Írj be egy egész számot!");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i % 3 == 0 ? "osztható" : "nem osztható");
    }
}
