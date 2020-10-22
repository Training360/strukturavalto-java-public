package classstructureintegrate;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az új számla száma?");
        String accountNumber = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount = scanner.nextInt();
        scanner.nextLine();

        BankAccount account1 = new BankAccount(accountNumber, owner, amount);

        System.out.println("Mi az új számla száma?");
        String accountNumber2 = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner2 = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount2 = scanner.nextInt();

        BankAccount account2 = new BankAccount(accountNumber2, owner2, amount2);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne befizetni az első számlára?");
        int depositAmount = scanner.nextInt();
        account1.deposit(depositAmount);

        System.out.println(account1.getInfo());

        System.out.println("Mennyit szeretne felvenni a második számláról?");
        int withdrawAmount = scanner.nextInt();
        account2.withdraw(withdrawAmount);

        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne átutalni az első számláról a másodikra?");
        int transferAmount = scanner.nextInt();
        account1.transfer(account2, transferAmount);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());
    }
}
