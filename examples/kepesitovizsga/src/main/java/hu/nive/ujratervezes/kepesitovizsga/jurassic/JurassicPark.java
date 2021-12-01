package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        List<String> overpopulated = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT breed FROM dinosaur WHERE expected < actual ORDER BY breed ASC;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                overpopulated.add(resultSet.getString("breed"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return overpopulated;
    }
}
