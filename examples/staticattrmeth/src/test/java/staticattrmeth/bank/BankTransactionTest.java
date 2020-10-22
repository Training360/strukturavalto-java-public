package staticattrmeth.bank;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankTransactionTest {

    @Test
    public void testOneTransaction() {
        //Given
        BankTransaction.initTheDay();
        BankTransaction bankTransaction = new BankTransaction(10_000);
        //Then
        assertThat(bankTransaction.getTrxValue(), equalTo(10_000L));
        assertThat(BankTransaction.getCurrentMinValue(), equalTo(10_000L));
        assertThat(BankTransaction.getCurrentMaxValue(), equalTo(10_000L));
        assertThat(BankTransaction.getSumOfTrxs(), equalTo(new BigDecimal("10000")));
        assertThat(BankTransaction.averageOfTransaction(), equalTo(new BigDecimal("10000")));
    }

    @Test
    public void testSeveralTransactions() {
        //Given
        BankTransaction.initTheDay();
        new BankTransaction(10_000);
        new BankTransaction(20_000);
        //Then
        assertThat(BankTransaction.getCurrentMinValue(), equalTo(10_000L));
        assertThat(BankTransaction.getCurrentMaxValue(), equalTo(20_000L));
        assertThat(BankTransaction.getSumOfTrxs(), equalTo(new BigDecimal("30000")));
        assertThat(BankTransaction.averageOfTransaction(), equalTo(new BigDecimal("15000")));
    }

    @Test
    public void testZeroTransaction() {
        //Given
        BankTransaction.initTheDay();
        //Then
        assertThat(BankTransaction.getCurrentMinValue(), equalTo(0L));
        assertThat(BankTransaction.getCurrentMaxValue(), equalTo(0L));
        assertThat(BankTransaction.getSumOfTrxs(), equalTo(new BigDecimal("0")));
    }
}