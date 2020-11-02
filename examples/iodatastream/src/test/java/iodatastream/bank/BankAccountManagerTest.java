package iodatastream.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountManagerTest {

  @TempDir
  public File folder;

    @Test
    public void testSaveAccount() throws IOException {
        BankAccount account = new BankAccount("10092395-77541845-00000000", "John Doe", 11234.6);

        BankAccountManager manager = new BankAccountManager();

        File file = new File(folder, "test.txt");
        Path path=folder.toPath();
        manager.saveAccount(account, path);

        Path targetPath = path.resolve("10092395-77541845-00000000.dat");
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
