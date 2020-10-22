package lambdaintro;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

    @Test
    public void testCreate() {
        BankAccount bankAccount = new BankAccount("12345678-12345678", "John Doe", 100.5);

        assertThat(bankAccount.getAccountNumber(), equalTo("12345678-12345678"));
        assertThat(bankAccount.getNameOfOwner(), equalTo("John Doe"));
        assertThat(bankAccount.getBalance(), equalTo(100.5));
    }

}
