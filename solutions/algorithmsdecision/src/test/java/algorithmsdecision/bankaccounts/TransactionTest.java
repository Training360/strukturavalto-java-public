package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    String str = "1986-04-08 12:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

    @Test
    public void transactionCreateTest() {
        Transaction transaction = new Transaction("1234-234-345", TransactionOperation.CREDIT, 10000, dateTime);

        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
        assertEquals(10000, transaction.getAmount());
        assertEquals(dateTime, transaction.getDateOfTransaction());
        assertEquals("1234-234-345", transaction.getAccountNumber());
    }
}
