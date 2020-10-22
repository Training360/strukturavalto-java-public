package algorithmsdecision.bankaccounts;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    BankAccount bankAccount = new BankAccount("Fred", "123-324-123", 100);

    @Test
    public void testCreateBankAccount() {

        assertThat(bankAccount.getAccountNumber(), is("123-324-123"));
        assertThat(bankAccount.getBalance(), is(100));

    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(50);
        assertThat(bankAccount.getBalance(),is(50));
        assertThat(bankAccount.withdraw(110),is(false));
        assertThat(bankAccount.withdraw(20),is(true));
    }
    
    @Test
    public void testDeposit(){
        bankAccount.deposit(100);
        assertThat(bankAccount.getBalance(),is(200));
        assertThat(bankAccount.deposit(20),is(true));
        
    }

}
