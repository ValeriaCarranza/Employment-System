package MySpring.MySpring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import MySpring.MySpring.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone());
	}

	@Override
	public int update(Contact c) {
		String sql = "UPDATE Contact SET name=?, email=?, address=?, telephone=? WHERE contact_id=?";
		
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone(), c.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM Contact WHERE contact_id=" + id;
		final Integer op = id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			 
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String telephone = rs.getString("telephone");
					
					return new Contact(op, name, email, address, telephone);
				}
				return null;
			}
			
		};
		
		return jdbcTemplate.query(sql, extractor);
		
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Contact WHERE contact_id =?";
		return jdbcTemplate.update(sql, id );
	}

	@Override
	public List<Contact> get() {
		String sql = "SELECT * FROM Contact";
		
		ParameterizedRowMapper<Contact> row = new ParameterizedRowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer contact_id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				
				return new Contact(contact_id, name, email, address, telephone);
			}
			
		};
		
		
		return jdbcTemplate.query(sql, row);
	}

}
