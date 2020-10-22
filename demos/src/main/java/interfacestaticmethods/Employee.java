package interfacestaticmethods;

import java.time.LocalDateTime;

public class Employee implements Audited {

    private String name;

    private LocalDateTime createdAt;

    public Employee(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
