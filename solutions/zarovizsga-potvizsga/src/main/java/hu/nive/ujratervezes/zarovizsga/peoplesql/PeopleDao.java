package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {


    private DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }




    public String findIpByName(String firstName, String lastName){

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select ip_address from people where first_name=? AND last_name=?")){
            stmt.setString(1,firstName);
            stmt.setString(2,lastName);

            return findByStatement(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot connnect");
        }

    }


    public  String  findByStatement(PreparedStatement stmt){
        try(ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                return rs.getString("ip_address");
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot execute!");
        }

        throw new IllegalArgumentException("Cannot find!");
    }




}
