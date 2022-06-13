package MySpring.MySpring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import MySpring.MySpring.model.Contact;
import MySpring.MySpring.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Employee e) {
		String sql = "INSERT INTO employee (first_name, middle_name, last_name, birth, position) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, e.getFirst_name(), e.getMiddle_name(), e.getLast_name(), e.getBirth(),
				e.getPosition());
	}

	@Override
	public int update(Employee e) {
		String sql = "UPDATE employee SET first_name=?, middle_name=?, last_name=?, birth=?, position=? WHERE id_employee=?";
		return jdbcTemplate.update(sql, e.getFirst_name(), e.getMiddle_name(), e.getLast_name(), e.getBirth(),
				e.getPosition(), e.getId_employee());
	}

	@Override
	public Employee get(Integer id) {
		String sql = "SELECT * FROM employee WHERE id_employee=" + id;
		final Integer op = id;
		ResultSetExtractor<Employee> extractor = new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String first_name = rs.getString("first_name");
					String middle_name = rs.getString("middle_name");
					String last_name = rs.getString("last_name");
					String birth = rs.getString("birth");
					String position = rs.getString("position");

					return new Employee(op, first_name, middle_name, last_name, birth, position);
				}
				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);

	}

	@Override
	public int delete(Integer id_employee) {
		String sql = "DELETE FROM employee WHERE id_employee =?";
		return jdbcTemplate.update(sql, id_employee);
	}

	@Override
	public List<Employee> get() {
		String sql = "SELECT * FROM employee";

		ParameterizedRowMapper<Employee> row = new ParameterizedRowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id_employee = rs.getInt("id_employee");
				String first_name = rs.getString("first_name");
				String middle_name = rs.getString("middle_name");
				String last_name = rs.getString("last_name");
				String birth = rs.getString("birth");
				String position = rs.getString("position");

				return new Employee(id_employee, first_name, middle_name, last_name, birth, position);
			}

		};

		return jdbcTemplate.query(sql, row);

	}

	@Override
	public List<Employee> employeExist(String first_name, String middle_name, String last_name, String birthay) {
		String sql = "SELECT * FROM employee WHERE first_name= '" + first_name+ "' and middle_name='"+middle_name+"' and last_name='"+last_name+"' and birth='"+birthay+"'";
		
		ParameterizedRowMapper<Employee> row = new ParameterizedRowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id_employee = rs.getInt("id_employee");
				String first_name = rs.getString("first_name");
				String middle_name = rs.getString("middle_name");
				String last_name = rs.getString("last_name");
				String birth = rs.getString("birth");
				String position = rs.getString("position");

				return new Employee(id_employee, first_name, middle_name, last_name, birth, position);
			}

		};

		return jdbcTemplate.query(sql, row);
		
	}

}
