package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Client client = new Client();

        System.out.println("Név:");
        client.name = scanner.nextLine();
        System.out.println("Születési év:");
        client.year = scanner.nextInt();
        System.out.println("Lakcím:");
        client.address = scanner.nextLine();

        System.out.println("Név: " + client.name);
        System.out.println("Születési év: " + client.year);
        System.out.println("Lakcím: " + client.address);
    }
}
