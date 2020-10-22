package iodatastream.bank;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BankAccountManagerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testSaveAccount() throws IOException {
        BankAccount account = new BankAccount("10092395-77541845-00000000", "John Doe", 11234.6);

        BankAccountManager manager = new BankAccountManager();

        manager.saveAccount(account, folder.getRoot().toPath());

        Path targetPath = folder.getRoot().toPath().resolve("10092395-77541845-00000000.dat");
        byte[] savedAccount = Files.readAllBytes(targetPath);
        byte[] originalAccount = this.getClass().getResourceAsStream("/10092395-77541845-00000000.dat").readAllBytes();

        assertArrayEquals(originalAccount, savedAccount);

    }

    public void testLoadAccount() throws IOException {
        BankAccountManager manager = new BankAccountManager();

        try (InputStream is = this.getClass().getResourceAsStream("/10092395-77541845-00000000.dat")) {
            BankAccount account = manager.loadAccount(is);

            assertEquals("10092395-77541845-00000000", account.getAccountNumber());
            assertEquals("John Doe", account.getOwner());
            assertEquals(11234.6, account.getBalance(), 0.0001);
        }
    }
}
