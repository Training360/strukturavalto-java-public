package interfacedefaultmethods;

import java.time.LocalDateTime;
import java.util.List;

public interface Audited {

    LocalDateTime getCreatedAt();

    default boolean createdAfter(LocalDateTime dateTime) {
        return getCreatedAt().isAfter(dateTime);
    }

}
