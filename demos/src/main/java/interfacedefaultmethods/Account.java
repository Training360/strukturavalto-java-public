package interfacedefaultmethods;

import java.time.LocalDateTime;

public class Account implements Audited {

    private LocalDateTime localDateTime;

    public Account(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return localDateTime;
    }

}
