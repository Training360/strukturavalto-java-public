package hu.nive.ujratervezes.zarovizsga.housecup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseCupTest {

    private MariaDbDataSource dataSource;

    private HouseCup houseCup;

    @BeforeEach
    void init() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        houseCup = new HouseCup(dataSource);

        initTables();
        createDummyData();
    }

    @Test
    void test_get_points_of_house() throws SQLException {
        assertEquals(30, houseCup.getPointsOfHouse("Gryffindor"));
    }

    @Test
    void test_get_points_of_house_one() throws SQLException {
        assertEquals(5, houseCup.getPointsOfHouse("Slytherin"));
    }



    @AfterEach
    void destruct() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String dropHousePoints = "DROP TABLE IF EXISTS house_points";
            Statement statement = connection.createStatement();
            statement.execute(dropHousePoints);
        }
    }

    void initTables() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String createHouseTable = "CREATE TABLE IF NOT EXISTS house_points (" +
                    "house_name VARCHAR(255), " +
                    "student_name VARCHAR(255), " +
                    "points_earned INT" +
                    ");";
            Statement statement = connection.createStatement();
            statement.execute(createHouseTable);
        }
    }

    void createDummyData() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String insertHousePoints = "INSERT INTO house_points VALUES ('Gryffindor', 'Harry Potter', 10)";
            Statement insertHousePointsStatement = connection.createStatement();
            insertHousePointsStatement.execute(insertHousePoints);
            insertHousePoints = "INSERT INTO house_points VALUES ('Gryffindor', 'Ginny Weasley', 20)";
            insertHousePointsStatement = connection.createStatement();
            insertHousePointsStatement.execute(insertHousePoints);
            insertHousePoints = "INSERT INTO house_points VALUES ('Slytherin', 'Draco Malfoy', 5)";
            insertHousePointsStatement = connection.createStatement();
            insertHousePointsStatement.execute(insertHousePoints);
            insertHousePoints = "INSERT INTO house_points VALUES ('Hufflepuff', 'Cedric Diggory', 15)";
            insertHousePointsStatement = connection.createStatement();
            insertHousePointsStatement.execute(insertHousePoints);
            insertHousePoints = "INSERT INTO house_points VALUES ('Ravenclaw', 'Luna Lovegood', 50)";
            insertHousePointsStatement = connection.createStatement();
            insertHousePointsStatement.execute(insertHousePoints);
        }

    }

}