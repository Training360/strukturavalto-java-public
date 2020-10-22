package interfacedefaultmethods;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void testCreatedAfter() {
        Account account = new Account(LocalDateTime.of(2018, 1, 1, 10, 0));
        boolean result = account.createdAfter(LocalDateTime.of(2018, 1, 1, 11, 0));
        assertThat(result, equalTo(false));
    }

}
