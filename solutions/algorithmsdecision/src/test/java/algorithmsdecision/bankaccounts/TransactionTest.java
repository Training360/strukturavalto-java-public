package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {

    String str = "1986-04-08 12:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

    @Test
    public void transactionCreateTest() {
         Transaction transaction = new Transaction("1234-234-345", TransactionOperation.CREDIT, 10000, dateTime);

        assertThat(transaction.isCredit(), is(true));
        assertThat(transaction.isDebit(), is(false));
        assertThat(transaction.getAmount(), is(10000));
        assertThat(transaction.getDateOfTransaction(), is(dateTime));
        assertThat(transaction.getAccountNumber(), is("1234-234-345"));
    }
}
