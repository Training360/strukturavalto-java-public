package bank2;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("accounts");
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.deposit(amount);
    }

    private Account get(String accountNumber) throws InvalidAccountNumberBankOperationException {
        int accountIndex = -1;
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getAccountNumber().equals(accountNumber)) {
                accountIndex = i;
            }
        }
        if (accountIndex == -1) {
            throw new InvalidAccountNumberBankOperationException();
        }

        return this.accounts.get(accountIndex);
    }
}
