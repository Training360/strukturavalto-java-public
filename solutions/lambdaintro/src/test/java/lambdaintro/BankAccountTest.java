package lambdaintro;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    public void testCreate() {
        BankAccount bankAccount = new BankAccount("12345678-12345678", "John Doe", 100.5);

        assertEquals("12345678-12345678", bankAccount.getAccountNumber());
        assertEquals("John Doe", bankAccount.getNameOfOwner());
        assertEquals(100.5, bankAccount.getBalance());
    }

}
