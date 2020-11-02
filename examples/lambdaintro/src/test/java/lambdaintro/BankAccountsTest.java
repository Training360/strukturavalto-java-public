package lambdaintro;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountsTest {

    @Test
    public void testListBankAccountsByAccountNumber() {
        BankAccounts accounts = new BankAccounts(Arrays.asList(
                new BankAccount("3", "John Doe", 100.0),
                new BankAccount("1", "John Doe", 100.0),
                new BankAccount("2", "John Doe", 100.0),
                new BankAccount("5", "John Doe", 100.0),
                new BankAccount("4", "John Doe", 100.0)

        ));

        List<BankAccount> sorted = accounts.listBankAccountsByAccountNumber();

        assertEquals("1", sorted.get(0).getAccountNumber());
        assertEquals("4", sorted.get(3).getAccountNumber());
    }

    @Test
    public void testListBankAccountsByBalance() {
        BankAccounts accounts = new BankAccounts(Arrays.asList(
                new BankAccount("3", "John Doe", 100.0),
                new BankAccount("1", "John Doe", 105.0),
                new BankAccount("2", "John Doe", -102.0),
                new BankAccount("5", "John Doe", 200.0),
                new BankAccount("4", "John Doe", 90.0)

        ));

        List<BankAccount> sorted = accounts.listBankAccountsByBalance();

        assertEquals(90.0, sorted.get(0).getBalance());
        assertEquals(105.0, sorted.get(3).getBalance());
    }

    @Test
    public void testListBankAccountsByBalanceDesc() {
        BankAccounts accounts = new BankAccounts(Arrays.asList(
                new BankAccount("3", "John Doe", 100.0),
                new BankAccount("1", "John Doe", 105.0),
                new BankAccount("2", "John Doe", -102.0),
                new BankAccount("5", "John Doe", 200.0),
                new BankAccount("4", "John Doe", 90.0)

        ));

        List<BankAccount> sorted = accounts.listBankAccountsByBalanceDesc();

        assertEquals(105.0, sorted.get(1).getBalance());
        assertEquals(90.0, sorted.get(3).getBalance());
        assertEquals(-102.0, sorted.get(4).getBalance());

    }

    @Test
    public void testListBankAccountsByNameThanAccountNumber() {
        BankAccounts accounts = new BankAccounts(Arrays.asList(
                new BankAccount("2", "Ábrahám Doe", 102.0),
                new BankAccount("4", "John Doe", 100.0),
                new BankAccount("1", "Alphonse Doe", 105.0),
                new BankAccount("5", null, 200.0),
                new BankAccount("3", "John Doe", 90.0)

        ));

        List<BankAccount> sorted = accounts.listBankAccountsByNameThanAccountNumber();

        assertEquals(null, sorted.get(0).getNameOfOwner());
        assertEquals("Ábrahám Doe", sorted.get(1).getNameOfOwner());
        assertEquals("Alphonse Doe", sorted.get(2).getNameOfOwner());
        assertEquals("John Doe", sorted.get(4).getNameOfOwner());
        assertEquals("4", sorted.get(4).getAccountNumber());
    }

}
