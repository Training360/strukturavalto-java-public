package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.naturalOrder());
        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.comparing((a) -> Math.abs(a.getBalance())));
        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return ordered;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));

        ordered.sort(
                Comparator.comparing(BankAccount::getNameOfOwner,
                        Comparator.nullsFirst(collator))
                        .thenComparing(BankAccount::getAccountNumber));
        return ordered;
    }

}
