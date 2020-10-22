package bank2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private double initialBalance;
    private List<Account> accounts;
    private Bank bank;

    @Before
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
        exception.expect(IllegalArgumentException.class);

        new Bank(null);
    }

    @Test
    public void paymentUnknownAccountNumberShouldThrowException() throws Exception {
        String accountNumber = "unknownaccountNumber";

        exception.expect(InvalidAccountNumberBankOperationException.class);

        bank.payment(accountNumber, 10);
    }

    @Test
    public void paymentShouldSubtractBalance() throws Exception {
        String accountNumber = "acc2";
        double amount = 10;

        bank.payment(accountNumber, amount);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                assertThat(account.getBalance(), equalTo(initialBalance - amount));
            } else {
                assertThat(account.getBalance(), equalTo(initialBalance));
            }
        }
    }

    @Test
    public void depositUnknownAccountNumberShouldThrowException() throws Exception {
        String accountNumber = "unknownAccountNumber";

        exception.expect(InvalidAccountNumberBankOperationException.class);

        bank.deposit(accountNumber, 10);
    }

    @Test
    public void depositShouldModifyBalance() throws Exception {
        String accountNumber = "acc2";
        double amount = 10;

        bank.deposit(accountNumber, amount);
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                assertThat(account.getBalance(), equalTo(initialBalance + amount));
            } else {
                assertThat(account.getBalance(), equalTo(initialBalance));
            }
        }
    }

}