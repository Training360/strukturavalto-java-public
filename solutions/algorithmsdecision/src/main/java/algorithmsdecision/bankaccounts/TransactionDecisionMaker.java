package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime start, LocalDateTime end, int min) {
        for (Transaction transaction: transactions) {
            if (transaction.isDebit()
                    && transaction.getDateOfTransaction().isAfter(start)
                    && transaction.getDateOfTransaction().isBefore(end)
                    && transaction.getAmount() > min) {
                return true;
            }
        }
        return false;
    }
}
