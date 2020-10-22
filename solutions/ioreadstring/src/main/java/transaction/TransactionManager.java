package transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();



    public void uploadListFromFile(String filePath){

        Path accounts = Path.of(filePath);
        try {
            List<String> accountsFromFile = Files.readAllLines(accounts);

            for(String s: accountsFromFile){
                String[] temp = s.split(";");
                BankAccount ba = new BankAccount(temp[0],temp[1],Integer.parseInt(temp[2]));
                accountList.add(ba);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file",e);
        }
    }


    public void makeTransactions(String filePath){
        Path transactions = Path.of(filePath);

        try {
            List<String> transactionsFromFile = Files.readAllLines(transactions);

            for(String s : transactionsFromFile){
                String[] temp = s.split(";");
                for(BankAccount b : accountList){
                    if(temp[0].equals(b.getAccountNumber())){
                        b.setBalance(Double.parseDouble(temp[1]));
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't open file",e);
        }
    }


    public List<BankAccount> getAccountList() {
        return accountList;
    }
}
