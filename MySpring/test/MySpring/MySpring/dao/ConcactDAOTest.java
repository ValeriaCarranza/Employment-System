package MySpring.MySpring.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import MySpring.MySpring.model.Contact;

class ConcactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@Test
	void testSave() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		dao = new ContactDAOImpl(dataSource);
		
		Contact contact = new Contact("Steve jobs", "steve@gmail.com", "Cupertio, CA", "4434388880");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetInteger() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

}
