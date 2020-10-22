package algorithmsdecision.bankaccounts;

public class BankAccount {

    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }
}
