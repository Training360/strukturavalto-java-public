package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DogTypesTest {

        DogTypes dogTypes;

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

            dogTypes = new DogTypes(dataSource);

        }

        @Test
        void testGetDogsByCountry() {
            List<String> types = dogTypes.getDogsByCountry("Hungary");
            assertEquals(9, types.size());
            assertTrue(types.contains("komondor"));
            assertTrue(types.contains("kuvasz"));
        }

    }
