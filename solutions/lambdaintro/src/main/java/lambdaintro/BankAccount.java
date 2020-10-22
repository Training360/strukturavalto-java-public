package lambdaintro;

public class BankAccount implements Comparable<BankAccount> {

    private String accountNumber;

    private String nameOfOwner;

    private double balance;

    public BankAccount(String accountNumber, String nameOfOwner, double balance) {
        this.accountNumber = accountNumber;
        this.nameOfOwner = nameOfOwner;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(BankAccount another) {
        return accountNumber.compareTo(another.accountNumber);
    }
}
