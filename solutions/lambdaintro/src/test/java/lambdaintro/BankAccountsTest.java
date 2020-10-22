package lambdaintro;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

        assertThat(sorted.get(0).getAccountNumber(), equalTo("1"));
        assertThat(sorted.get(3).getAccountNumber(), equalTo("4"));
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

        assertThat(sorted.get(0).getBalance(), equalTo(90.0));
        assertThat(sorted.get(3).getBalance(), equalTo(105.0));
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

        assertThat(sorted.get(1).getBalance(), equalTo(105.0));
        assertThat(sorted.get(3).getBalance(), equalTo(90.0));
        assertThat(sorted.get(4).getBalance(), equalTo(-102.0));

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

        assertThat(sorted.get(0).getNameOfOwner(), equalTo(null));
        assertThat(sorted.get(1).getNameOfOwner(), equalTo("Ábrahám Doe"));
        assertThat(sorted.get(2).getNameOfOwner(), equalTo("Alphonse Doe"));
        assertThat(sorted.get(4).getNameOfOwner(), equalTo("John Doe"));
        assertThat(sorted.get(4).getAccountNumber(), equalTo("4"));
    }

}
