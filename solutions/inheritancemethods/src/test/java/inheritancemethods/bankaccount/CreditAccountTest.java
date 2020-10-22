package inheritancemethods.bankaccount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreditAccountTest {

    @Test
    public void constructorTest() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertThat(creditAccount.getAccountNumber(), equalTo("11111111-22222222"));
        assertThat(creditAccount.getBalance(), equalTo(100000L));
        assertThat(creditAccount.getOverdraftLimit(), equalTo(50000L));
    }

    @Test
    public void transactionSuccess() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertThat(creditAccount.transaction(40000), is(true));
        assertThat(creditAccount.getBalance(), equalTo(58800L));
        assertThat(creditAccount.getOverdraftLimit(), equalTo(50000L));
    }

    @Test
    public void transactionSuccessWithOverdraf() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertThat(creditAccount.transaction(140000), is(true));
        assertThat(creditAccount.getBalance(), equalTo(0L));
        assertThat(creditAccount.getOverdraftLimit(), equalTo(5800L));
    }

    @Test
    public void transactionSuccessWithLowAmount() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertThat(creditAccount.transaction(1000), is(true));
        assertThat(creditAccount.getBalance(), equalTo(98800L));
        assertThat(creditAccount.getOverdraftLimit(), equalTo(50000L));
    }


    @Test
    public void transactionFail() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertThat(creditAccount.transaction(160000), is(false));
        assertThat(creditAccount.getBalance(), equalTo(100000L));
        assertThat(creditAccount.getOverdraftLimit(), equalTo(50000L));
    }
}