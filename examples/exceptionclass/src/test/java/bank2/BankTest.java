package bank2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private double initialBalance;
    private List<Account> accounts;
    private Bank bank;

    @BeforeEach
    public void createAccountList() {
        initialBalance = 100;
        accounts = new ArrayList<>();
        accounts.add(new Account("acc1", initialBalance));
        accounts.add(new Account("acc2", initialBalance));
        accounts.add(new Account("acc3", initialBalance));
        accounts.add(new Account("acc4", initialBalance));

        bank = new Bank(accounts);
    }

    @Test
    public void constructorNullParamShouldThrowException() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new Bank(null));
    }

    @Test
    public void paymentUnknownAccountNumberShouldThrowException() throws Exception {
        String accountNumber = "unknownaccountNumber";
        assertThrows(InvalidAccountNumberBankOperationException.class, () -> bank.payment(accountNumber, 10));
    }

    @Test
    public void paymentShouldSubtractBalance() throws Exception {
        String accountNumber = "acc2";
        double amount = 10;

        bank.payment(accountNumber, amount);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                assertEquals(initialBalance - amount, account.getBalance());
            } else {
                assertEquals(initialBalance, account.getBalance());
            }
        }
    }

    @Test
    public void depositUnknownAccountNumberShouldThrowException() throws Exception {
        String accountNumber = "unknownAccountNumber";
        assertThrows(InvalidBankOperationException.class, () -> bank.deposit(accountNumber, 10));
    }

    @Test
    public void depositShouldModifyBalance() throws Exception {
        String accountNumber = "acc2";
        double amount = 10;

        bank.deposit(accountNumber, amount);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                assertEquals(initialBalance + amount, account.getBalance());
            } else {
                assertEquals(initialBalance, account.getBalance());
            }
        }
    }

}