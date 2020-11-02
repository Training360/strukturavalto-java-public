package bank;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    public void constructorNullParamShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new Bank(null));
    }

    @Test
    public void paymentUnknownAccountNumberShouldThrowException() {
        String accountNumber = "unknownAccountNumber";
        InvalidBankOperationException ex = assertThrows(InvalidBankOperationException.class, () -> bank.payment(accountNumber, 10));
        assertEquals(ErrorCode.INVALID_ACCOUNTNUMBER, ex.getErrorCode());

    }

    @Test
    public void paymentShouldSubtractBalance() {
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
    public void depositUnknownAccountNumberShouldThowException() {
        String accountNumber = "unknownaccountNumber";

        InvalidBankOperationException ex = assertThrows(InvalidBankOperationException.class, () -> bank.deposit(accountNumber, 10));
        assertEquals(ErrorCode.INVALID_ACCOUNTNUMBER, ex.getErrorCode());

    }

    @Test
    public void depositShouldModifyBalance() {
        String accountNumber = "acc2";
        double amount = 10;

        bank.deposit(accountNumber, amount);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                assertEquals(initialBalance + amount,account.getBalance());
            } else {
                assertEquals(initialBalance,account.getBalance());
            }
        }
    }

}