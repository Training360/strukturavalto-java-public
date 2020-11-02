package interfacedefaultmethods;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {

    @Test
    public void testCreatedAfter() {
        Account account = new Account(LocalDateTime.of(2018, 1, 1, 10, 0));
        boolean result = account.createdAfter(LocalDateTime.of(2018, 1, 1, 11, 0));
        assertFalse(result);
    }

}
