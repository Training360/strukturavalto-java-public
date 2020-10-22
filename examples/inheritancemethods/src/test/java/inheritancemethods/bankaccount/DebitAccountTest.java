package inheritancemethods.bankaccount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DebitAccountTest {

    @Test
    public void constructorTest() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertThat(debitAccount.getAccountNumber(), equalTo("111111-2222222"));
        assertThat(debitAccount.getBalance(), equalTo(50000L));
    }

    @Test
    public void costOfTransaction() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertThat(debitAccount.costOfTransaction(15027), equalTo(450L));
    }

    @Test
    public void costOfTransactionLow() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertThat(debitAccount.costOfTransaction(6000), equalTo(200L));
    }

    @Test
    public void transactionSuccess() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertThat(debitAccount.transaction(40000), is(true));
        assertThat(debitAccount.getBalance(), equalTo(8800L));
    }

    @Test
    public void transactionFail() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertThat(debitAccount.transaction(60000), is(false));
        assertThat(debitAccount.getBalance(), equalTo(50000L));
    }
}