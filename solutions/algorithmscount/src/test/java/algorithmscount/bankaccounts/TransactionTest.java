package algorithmscount.bankaccounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void createTransaction() {
        Transaction transaction = new Transaction("1234", TransactionType.CREDIT, 100);
        assertEquals("1234", transaction.getAccountNumber());
        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
        assertEquals(100, transaction.getAmount());
    }
}
