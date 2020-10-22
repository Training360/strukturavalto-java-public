package exceptionresource.accesscontrol;

import java.time.LocalDateTime;

public class LogEntry {

    public enum AccessType { IN, OUT}

    private LocalDateTime time;
    private String personId;
    private AccessType accessType;

    public LogEntry(LocalDateTime time, String personId, AccessType accessType) {
        this.time = time;
        this.personId = personId;
        this.accessType = accessType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getPersonId() {
        return personId;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public boolean isBefore(LocalDateTime time) {
        return this.time.isBefore(time);
    }
}
