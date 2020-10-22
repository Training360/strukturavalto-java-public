package algorithmscount.bankaccounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

    @Test
    public void createTransaction() {
        Transaction transaction = new Transaction("1234", TransactionType.CREDIT, 100);
        assertThat(transaction.getAccountNumber(), equalTo("1234"));
        assertThat(transaction.isCredit(), is(true));
        assertThat(transaction.isDebit(), is(false));
        assertThat(transaction.getAmount(), equalTo(100));
    }
}
