package hu.nive.ujratervezes.webshop;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebshopService {

    private DataSource dataSource;

    public WebshopService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getValuableCustomers() {
        List<String> names = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT customer_name FROM orders WHERE total > 1000 ORDER BY customer_name ASC;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                names.add(resultSet.getString("customer_name"));
            }
        } catch (SQLException exception) {
            throw new IllegalStateException("Can not run query", exception);
        }
        return names;
    }

}
