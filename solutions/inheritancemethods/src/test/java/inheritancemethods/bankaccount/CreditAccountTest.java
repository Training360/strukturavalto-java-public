package inheritancemethods.bankaccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test
    public void constructorTest() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertEquals("11111111-22222222", creditAccount.getAccountNumber());
        assertEquals(100000L, creditAccount.getBalance());
        assertEquals(50000L, creditAccount.getOverdraftLimit());
    }

    @Test
    public void transactionSuccess() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertTrue(creditAccount.transaction(40000));
        assertEquals(58800L, creditAccount.getBalance());
        assertEquals(50000L, creditAccount.getOverdraftLimit());
    }

    @Test
    public void transactionSuccessWithOverdraf() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertTrue(creditAccount.transaction(140000));
        assertEquals(0L, creditAccount.getBalance());
        assertEquals(5800L, creditAccount.getOverdraftLimit());
    }

    @Test
    public void transactionSuccessWithLowAmount() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertTrue(creditAccount.transaction(1000));
        assertEquals(98800L, creditAccount.getBalance());
        assertEquals(50000L, creditAccount.getOverdraftLimit());
    }


    @Test
    public void transactionFail() {
        //Given
        CreditAccount creditAccount = new CreditAccount("11111111-22222222", 100000, 50000);
        //Then
        assertFalse(creditAccount.transaction(160000));
        assertEquals(100000L, creditAccount.getBalance());
        assertEquals(50000L, creditAccount.getOverdraftLimit());
    }
}