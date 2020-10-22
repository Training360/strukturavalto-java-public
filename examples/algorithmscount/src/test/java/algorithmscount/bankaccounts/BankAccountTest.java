package algorithmscount.bankaccounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

    @Test
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234", 1000);
        assertThat(bankAccount.getNameOfOwner(), equalTo("John Doe"));
        assertThat(bankAccount.getAccountNumber(), equalTo("1234"));
        assertThat(bankAccount.getBalance(), equalTo(1000));
    }
}
