package algorithmsdecision.bankaccounts;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountDecisionMakerTest {

    List<BankAccount> accounts = Arrays.asList(
            new BankAccount("Fred", "123-324-123", 100),
            new BankAccount("Kate", "133-324-123", 200),
            new BankAccount("Mary", "143-324-123", 90)
    );

    @Test
    public void testContainsBalanceGreaterThan() {

        BankAccountDecisionMaker test = new BankAccountDecisionMaker();

        assertThat(test.containsBalanceGreaterThan(accounts, 150), is(true));
        assertThat(test.containsBalanceGreaterThan(accounts, 250), is(false));

    }

}
