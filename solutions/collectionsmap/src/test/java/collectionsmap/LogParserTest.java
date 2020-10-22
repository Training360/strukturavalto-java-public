package collectionsmap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LogParserTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void faultyLogShouldThrowException() {
        // Given
        String log = "invalid_log_format";

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect log: incorrect number of fields");

        // When
        new LogParser().parseLog(log);
    }

    @Test
    public void invalidDateFormatShouldThrowException() {
        // Given
        String log = "176.121.45.124:20161202:derzsi\n";

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect log: incorrect date");

        // When
        new LogParser().parseLog(log);
    }

    @Test
    public void entriesWithSameIpShouldBeInSameList() {
        // Given
        String log = "176.121.45.124:2016-12-02:derzsi\n"
                + "176.121.45.124:2016-12-03:ggrrrr\n";

        // When
        Map<String, List<Entry>> entries = new LogParser().parseLog(log);

        // Then
        assertThat(entries.size(), equalTo(1));
        assertThat(entries.get("176.121.45.124").size(), equalTo(2));
        assertThat(entries.get("176.121.45.124").get(0).getLogin(), equalTo("derzsi"));
        assertThat(entries.get("176.121.45.124").get(0).getIpAddress(), equalTo("176.121.45.124"));
        assertThat(entries.get("176.121.45.124").get(0).getEntryDate(), equalTo(LocalDate.of(2016, 12, 2)));
    }
}
