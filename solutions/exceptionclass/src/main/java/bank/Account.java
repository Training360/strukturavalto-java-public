package bank;

public class Account {

    private static final double INITIAL_MAX_SUBTRACT = 100000;

    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("accountNumber");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = INITIAL_MAX_SUBTRACT;
    }

    public void setMaxSubtract(double maxSubtract) throws InvalidBankOperationException {
        if (maxSubtract <= 0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) throws InvalidBankOperationException {
        if (amount > this.maxSubtract || amount <= 0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        double balanceAfter = this.balance - amount;
        if (balanceAfter < 0) {
            throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        }

        this.balance = balanceAfter;
        return this.balance;
    }

    public double deposit(double amount) throws InvalidBankOperationException {
        if (amount <= 0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        this.balance += amount;
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}
