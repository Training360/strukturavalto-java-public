package algorithmscount.bankaccounts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TransactionCounterTest {

    @Test
    public void testCountEntryLessThan() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1234", TransactionType.CREDIT, 1000),
                new Transaction("1234", TransactionType.CREDIT, 2000),
                new Transaction("1234", TransactionType.CREDIT, 3000),
                new Transaction("1234", TransactionType.CREDIT, 4000)
        );

        assertThat(new TransactionCounter().countEntryLessThan(transactions, 2000), equalTo(1));
        assertThat(new TransactionCounter().countEntryLessThan(transactions, 1000), equalTo(0));
        assertThat(new TransactionCounter().countEntryLessThan(transactions, 10000), equalTo(4));
    }
}
