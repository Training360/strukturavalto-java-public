package hu.nive.ujratervezes.webshop;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebshopServiceTest {

    private WebshopService webshopService;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        webshopService = new WebshopService(dataSource);

    }

    @Test
    void getValuableCustomers() {
        List<String> names = webshopService.getValuableCustomers();
        assertEquals(Arrays.asList("Clara Spinka", "Gloria Hyatt", "Gloria Hyatt", "Stacy Doyle Jr."), names);
    }
}