package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    //private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public DogTypes(DataSource dataSource) {
        //this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getDogsByCountry(String country) {
        return jdbcTemplate.query("SELECT lower(NAME) as name FROM dog_types WHERE lower(country) = lower(?) ORDER BY NAME",
                (resultSet, i) -> resultSet.getString("name"),
                country);
    }


//    public List<String> getDogsByCountry(String country) {
//        try (
//                Connection conn = dataSource.getConnection();
//                PreparedStatement stmt =
//                        conn.prepareStatement("SELECT lower(NAME) as name FROM dog_types WHERE lower(country) = lower(?) ORDER BY NAME");
//        ) {
//            stmt.setString(1, country);
//
//            return convertToNames(stmt);
//        } catch (SQLException sqle) {
//            throw new IllegalArgumentException("Error by insert", sqle);
//        }
//    }
//
//    public List<String> convertToNames(PreparedStatement stmt) {
//        List<String> result = new ArrayList<>();
//        try (
//                ResultSet rs = stmt.executeQuery();
//        ) {
//            while (rs.next()) {
//                String name = rs.getString("name");
//                result.add(name);
//            }
//        } catch (SQLException sqle) {
//            throw new IllegalArgumentException("Error by insert", sqle);
//        }
//        return result;
//    }
}
