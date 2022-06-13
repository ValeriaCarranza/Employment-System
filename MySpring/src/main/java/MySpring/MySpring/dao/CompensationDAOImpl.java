package MySpring.MySpring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import MySpring.MySpring.model.Compensation;
import MySpring.MySpring.model.Employee;

public class CompensationDAOImpl implements CompensationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public CompensationDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Compensation c) {
		String sql = "INSERT INTO compensation (type_com, amount, description_com, date_com, id_employe) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getType_com(), c.getAmount(), c.getDescription_com(), c.getDate_com(), c.getId_employee());
	}

	@Override
	public int update(Compensation c) {
		String sql = "UPDATE compensation SET type_com=?, amount=?, description_com=?, date_com=?, id_employe=? WHERE id_compensation=?" ;
		return jdbcTemplate.update(sql, c.getType_com(), c.getAmount(), c.getDescription_com(), c.getDate_com(), c.getId_employee(), c.getId_compensation());
	}

	@Override
	public Compensation get(Integer id) {
		String sql = "SELECT * FROM compensation WHERE id_compensation=" + id;
		final Integer op = id;
		ResultSetExtractor<Compensation> extractor = new ResultSetExtractor<Compensation>() {

			@Override
			public Compensation extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String type_com = rs.getString("type_com");
					int amount = rs.getInt("amount");
					String description_com = rs.getString("description_com");
					String date_com = rs.getString("date_com");
					int id_employe = rs.getInt("id_employe");
					
					return new Compensation(op, type_com, amount, description_com, date_com, id_employe);
				}
				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id_compensation) {
		String sql = "DELETE FROM compensation WHERE id_compensation =?";
		return jdbcTemplate.update(sql, id_compensation);
	}

	@Override
	public List<Compensation> getCompensations(Integer id_employe, String month) {
		String sql = "SELECT * FROM compensation where DATE_FORMAT(date_com, '%y-%m') = DATE_FORMAT('"+month+"', '%y-%m') and id_employe="+ id_employe;

		ParameterizedRowMapper<Compensation> row = new ParameterizedRowMapper<Compensation>() {

			@Override
			public Compensation mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id_compensation = rs.getInt("id_compensation");
				String type_com = rs.getString("type_com");
				int amount = rs.getInt("amount");
				String description_com = rs.getString("description_com");
				String date_com = rs.getString("date_com");
				int id_employe = rs.getInt("id_employe");

				return new Compensation(id_compensation, type_com, amount, description_com, date_com, id_employe);
			}

		};

		return jdbcTemplate.query(sql, row);
	}

	@Override
	public List<Compensation> getCompensations(Integer id_employee) {
		String sql = "SELECT * FROM compensation where id_employe="+ id_employee;

		ParameterizedRowMapper<Compensation> row = new ParameterizedRowMapper<Compensation>() {

			@Override
			public Compensation mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id_compensation = rs.getInt("id_compensation");
				String type_com = rs.getString("type_com");
				int amount = rs.getInt("amount");
				String description_com = rs.getString("description_com");
				String date_com = rs.getString("date_com");
				int id_employe = rs.getInt("id_employe");

				return new Compensation(id_compensation, type_com, amount, description_com, date_com, id_employe);
			}

		};

		return jdbcTemplate.query(sql, row);
	}

	@Override
	public List<Compensation> salaryExist(Integer id_employee, String date) {
		String sql = "SELECT * FROM compensation where DATE_FORMAT(date_com, '%y-%m') = DATE_FORMAT('"+date+"', '%y-%m') and id_employe="+id_employee+" and type_com='Salary'";
		ParameterizedRowMapper<Compensation> row = new ParameterizedRowMapper<Compensation>() {

			@Override
			public Compensation mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id_compensation = rs.getInt("id_compensation");
				String type_com = rs.getString("type_com");
				int amount = rs.getInt("amount");
				String description_com = rs.getString("description_com");
				String date_com = rs.getString("date_com");
				int id_employe = rs.getInt("id_employe");

				return new Compensation(id_compensation, type_com, amount, description_com, date_com, id_employe);
			}

		};

		return jdbcTemplate.query(sql, row);
	}

}
