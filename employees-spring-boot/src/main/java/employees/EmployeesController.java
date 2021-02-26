package employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmployeesController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/employees")
    @ResponseBody
    public String listEmployees() {
        List<Employee> employees = jdbcTemplate.query("select id, emp_name from employees",
                (resultSet, i) -> new Employee(resultSet.getLong("id"), resultSet.getString("emp_name")));

        return employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
    }
}
