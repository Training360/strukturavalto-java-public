package algorithmscount.bankaccounts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountConditionCounterTest {

    @Test
    public void testCountWithBalanceGreaterThan() {
        List<BankAccount> bankAccounts = Arrays.asList(
                new BankAccount("John Doe", "123", 100),
                new BankAccount("Jane Doe", "123", 200),
                new BankAccount("Joe Doe", "123", 300),
                new BankAccount("Jennifer Doe", "123", 400));

        assertThat(new BankAccountConditionCounter().countWithBalanceGreaterThan(bankAccounts, 100), equalTo(3));
        assertThat(new BankAccountConditionCounter().countWithBalanceGreaterThan(bankAccounts, 400), equalTo(0));
    }
}
