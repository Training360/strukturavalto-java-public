package employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class EmployeesSpringBootApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(EmployeesSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
//		jdbcTemplate.update("insert into employees(emp_name) values (?)", "Jane Spring Boot Doe");
//
//
//		List<Employee> employees = jdbcTemplate.query("select id, emp_name from employees",
//				(resultSet, i) -> new Employee(resultSet.getLong("id"), resultSet.getString("emp_name")));
//		System.out.println(employees);


//		try (
//				Connection conn = dataSource.getConnection();
//				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_READ_ONLY);
//				ResultSet rs = stmt.executeQuery("select emp_name from employees order by emp_name")
//		) {
//			if (rs.next()) {
//
//				List<String> names = new ArrayList<>();
//				names.add(rs.getString("emp_name"));
//				while (rs.relative(2)) {
//					names.add(rs.getString("emp_name"));
//				}
//				System.out.println(names);
//			}
//
//		} catch (SQLException se) {
//			throw new IllegalStateException("Cannot list names", se);
//		}

    }
}
