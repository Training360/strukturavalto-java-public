package interfacestaticmethods;

import java.time.LocalDateTime;
import java.util.List;

public interface Audited {

    LocalDateTime getCreatedAt();

    static Audited findLastCreated(List<Audited> values) {
        Audited last = values.get(0);
        for (Audited actual: values) {
            if (actual.getCreatedAt().isAfter(last.getCreatedAt())) {
                last = actual;
            }
        }
        return last;
    }
}
