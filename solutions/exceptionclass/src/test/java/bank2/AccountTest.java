package bank2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorShouldThrowException() {
        String accountNumber = null;

        exception.expect(IllegalArgumentException.class);

        new Account(accountNumber, 0);
    }

    @Test
    public void constructorShouldInitialize() {
        String accountNumber = "11112";
        double balance = 1.2;
        double maxSubtract = 100000;

        Account account = new Account(accountNumber, balance);

        assertThat(account.getAccountNumber(), equalTo(accountNumber));
        assertThat(account.getBalance(), equalTo(balance));
        assertThat(account.getMaxSubtract(), equalTo(maxSubtract));
    }

    @Test
    public void setMaxSubtractShouldThrowException() {
        double maxSubtract = -10;
        Account account = new Account("a", 0);

        exception.expect(InvalidAmountBankOperationException.class);

        account.setMaxSubtract(maxSubtract);
    }

    @Test
    public void setMaxSubtractShouldModify() {
        double maxSubtract = 120000;
        Account account = new Account("a", 0);

        account.setMaxSubtract(maxSubtract);

        assertThat(account.getMaxSubtract(), equalTo(maxSubtract));
    }

    @Test
    public void subtractInvalidAmountShouldThrowException() {
        double amount = -10;
        Account account = new Account("a", 100);

        exception.expect(InvalidAmountBankOperationException.class);

        account.subtract(amount);
    }

    @Test
    public void subtractLowBalanceShouldThrowException() {
        double amount = 10;
        Account account = new Account("a", 5);

        exception.expect(LowBalanceBankOperationException.class);

        account.subtract(amount);
    }

    @Test
    public void subtractShouldCorrectReturn() {
        double balance = 300;
        double amount = 10;

        Account account = new Account("a", balance);

        assertThat(account.subtract(amount), equalTo(balance - amount));
    }

    @Test
    public void subtractShouldModifyBalance() {
        double balance = 300;
        double amount = 10;

        Account account = new Account("a", balance);

        account.subtract(amount);
        assertThat(account.getBalance(), equalTo(balance - amount));
    }


    @Test
    public void depositShouldThrowException() throws Exception {
        double amount = -10;

        Account account = new Account("a", 100);

        exception.expect(InvalidAmountBankOperationException.class);
        account.deposit(amount);
    }

    @Test
    public void depositShouldCorrectReturn() throws Exception {
        double balance = 300;
        double amount = 10;

        Account account = new Account("a", balance);

        assertThat(account.deposit(amount), equalTo(balance + amount));
    }

    @Test
    public void depositShouldModifyBalance() throws Exception {
        double balance = 300;
        double amount = 10;

        Account account = new Account("a", balance);

        account.deposit(amount);
        assertThat(account.getBalance(), equalTo(balance + amount));
    }

}