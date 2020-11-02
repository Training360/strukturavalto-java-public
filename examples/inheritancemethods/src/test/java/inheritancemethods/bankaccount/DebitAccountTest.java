package inheritancemethods.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DebitAccountTest {

    @Test
    public void constructorTest() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertEquals("111111-2222222", debitAccount.getAccountNumber());
        assertEquals(50000L, debitAccount.getBalance());
    }

    @Test
    public void costOfTransaction() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertEquals(450L, debitAccount.costOfTransaction(15027));
    }

    @Test
    public void costOfTransactionLow() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertEquals(200L, debitAccount.costOfTransaction(6000));
    }

    @Test
    public void transactionSuccess() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertTrue(debitAccount.transaction(40000));
        assertEquals(8800L, debitAccount.getBalance());
    }

    @Test
    public void transactionFail() {
        //Given
        DebitAccount debitAccount = new DebitAccount("111111-2222222", 50000);
        //Then
        assertFalse(debitAccount.transaction(60000));
        assertEquals(50000L, debitAccount.getBalance());
    }
}