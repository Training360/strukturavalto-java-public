package transaction;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {


    @Test
    public void createAccountTest() {
        BankAccount ba = new BankAccount("John Doe", "1234-1234-1234-1234", 2500);
        assertEquals("John Doe", ba.getName());
        assertEquals("1234-1234-1234-1234", ba.getAccountNumber());

    }


    @Test
    public void addBalanceTest() {
        BankAccount ba = new BankAccount("John Doe", "1234-1234-1234-1234", 2500);

        assertEquals(2500, ba.getBalance(), 0.0000001);

        ba.setBalance(100);
        assertEquals(2600, ba.getBalance(), 0.0000001);

    }


}
