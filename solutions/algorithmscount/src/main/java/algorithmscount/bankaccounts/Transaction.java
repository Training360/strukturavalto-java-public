package algorithmscount.bankaccounts;


public class Transaction {

    private String accountNumber;
    private TransactionType transactionType;
    private int amount;

    public Transaction(String accountNumber, TransactionType transactionType, int amount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isCredit() {
        return transactionType == TransactionType.CREDIT;
    }
    public boolean isDebit() {
        return transactionType == TransactionType.DEBIT;
    }

    public int getAmount() {
        return amount;
    }
}
