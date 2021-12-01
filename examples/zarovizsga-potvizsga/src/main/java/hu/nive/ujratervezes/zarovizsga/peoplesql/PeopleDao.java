package hu.nive.ujratervezes.zarovizsga.peoplesql;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleDao {

    private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findIpByName(String firstName, String lastName) {
        return jdbcTemplate.queryForObject("select ip_address from people where first_name = ? and last_name = ?", String.class,
                firstName, lastName);
    }
}
