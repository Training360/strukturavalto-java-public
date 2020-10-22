package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionDecisionMakerTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String str1 = "2017-03-06 12:30";
    LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
    String str2 = "2017-03-07 12:30";
    LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
    String str3 = "2017-03-08 12:30";
    LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);

    List<Transaction> transactions = Arrays.asList(
            new Transaction("123-324-123", TransactionOperation.CREDIT, 2000, dateTime1),
            new Transaction("133-324-123", TransactionOperation.DEBIT, 300, dateTime2),
            new Transaction("143-324-123", TransactionOperation.DEBIT, 2000, dateTime3)
    );

    @Test
    public void testContainsCreditEntryGreaterReturnTrue() {

        String start = "2017-03-06 12:32";
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        String end = "2017-03-07 12:32";
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);

        TransactionDecisionMaker test = new TransactionDecisionMaker();
        assertThat(test.containsCreditEntryGreaterThan(transactions, startTime, endTime, 200), is(true));

    }

    @Test
    public void testContainsCreditEntryGreaterReturnFalseBecauseOfTime() {

        String start = "2017-03-05 12:32";
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        String end = "2017-03-06 12:32";
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);

        TransactionDecisionMaker test = new TransactionDecisionMaker();
        assertThat(test.containsCreditEntryGreaterThan(transactions, startTime, endTime, 200), is(false));

    }

    @Test
    public void testContainsCreditEntryGreaterReturnFalseBecauseOfMin() {

        String start = "2017-03-04 12:32";
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        String end = "2017-03-06 12:32";
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);

        TransactionDecisionMaker test = new TransactionDecisionMaker();
        assertThat(test.containsCreditEntryGreaterThan(transactions, startTime, endTime, 200000), is(false));

    }

}
