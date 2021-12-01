package hu.nive.ujratervezes.birdwatcher;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BirdWatcher {

    private final DataSource dataSource;

    public BirdWatcher(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getUniqueBirds() {
        List<String> uniqueBirds = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT DISTINCT species FROM birds_spotted ORDER BY species ASC;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                uniqueBirds.add(resultSet.getString("species"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return uniqueBirds;
    }
}
