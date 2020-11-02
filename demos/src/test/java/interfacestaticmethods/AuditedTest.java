package interfacestaticmethods;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuditedTest {

    @Test
    public void testFind() {
        List<Audited> values = new ArrayList<>();
        values.add(new Employee("John Doe", LocalDateTime.of(2019, 1, 1, 10, 00)));
        values.add(new Employee("Jane Doe", LocalDateTime.of(2019, 2, 1, 10, 00)));

        Audited audited = Audited.findLastCreated(values);
        assertEquals("Jane Doe", ((Employee)audited).getName());
    }

}
