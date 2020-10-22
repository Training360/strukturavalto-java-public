package iozip.transactions;

import java.time.LocalDateTime;

public class Transaction {

    private final long id;

    private final LocalDateTime time;

    private final String account;

    private final double amount;

    public Transaction(long id, LocalDateTime time, String account, double amount) {
        this.id = id;
        this.time = time;
        this.account = account;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }
}
