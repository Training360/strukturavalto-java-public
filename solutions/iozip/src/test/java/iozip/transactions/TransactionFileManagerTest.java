package iozip.transactions;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TransactionFileManagerTest {

    @TempDir
    public Path folder;

    @Test
    public void testSaveTransactions() throws IOException {
        List<Transaction> transactionList = List.of(
            new Transaction(345L, LocalDateTime.of(2018, 2, 21, 12, 5, 31), "10092385-34562856-00008701", 412000.0),
            new Transaction(1297L, LocalDateTime.of(2018, 2, 21, 13, 10, 6), "10092385-23651299-00123013", -12000.0)
        );
        Path path = Files.createFile(folder.resolve("trans.zip"));
        TransactionFileManager manager = new TransactionFileManager();

        manager.saveTransactions(path, transactionList);

        List<Transaction> saved = readTransactions(path);
        saved.sort(Comparator.comparingLong(Transaction::getId));

        assertEquals(2, saved.size());
        assertEquals(345L, saved.get(0).getId());
        assertEquals(LocalDateTime.of(2018, 2, 21, 12, 5, 31), saved.get(0).getTime());
        assertEquals("10092385-34562856-00008701", saved.get(0).getAccount());
        assertEquals(412000.0, saved.get(0).getAmount(), 0.00001);
    }

    private List<Transaction> readTransactions(Path path) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try (ZipFile zf = new ZipFile(path.toFile())) {
            Enumeration<? extends ZipEntry> zipEntries = zf.entries();
            zipEntries.asIterator().forEachRemaining(entry -> {
                long id = Long.parseLong(entry.getName());
                try (BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(entry)))) {
                    LocalDateTime time = LocalDateTime.parse(br.readLine());
                    String account = br.readLine();
                    double amount = Double.parseDouble(br.readLine());
                    transactions.add(new Transaction(id, time, account, amount));
                } catch (IOException e2) {
                    throw new IllegalStateException("Cannot read entry", e2);
                }
            });
            return transactions;
        }
    }
}
