package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BankAccountDecisionMakerTest {

    List<BankAccount> accounts = Arrays.asList(
            new BankAccount("Fred", "123-324-123", 100),
            new BankAccount("Kate", "133-324-123", 200),
            new BankAccount("Mary", "143-324-123", 90)
    );

    @Test
    public void testContainsBalanceGreaterThan() {

        BankAccountDecisionMaker test = new BankAccountDecisionMaker();

        assertTrue(test.containsBalanceGreaterThan(accounts, 150));
        assertFalse(test.containsBalanceGreaterThan(accounts, 250));

    }

}
