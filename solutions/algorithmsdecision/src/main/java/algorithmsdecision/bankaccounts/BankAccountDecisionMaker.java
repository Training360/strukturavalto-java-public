package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int min) {
        for (BankAccount account: accounts) {
            if (account.getBalance() > min) {
                return true;
            }
        }
        return false;
    }
}
