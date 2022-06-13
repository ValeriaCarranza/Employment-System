package MySpring.MySpring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import MySpring.MySpring.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		dao = new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Contact contact = new Contact("Brandon", "steve@gmail.com", "Cupertio, CA", "4434388880");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(25, "Valeria", "steve@gmail.com", "Cupertio, CA", "4434388880");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testGetInteger() {
		Integer id = 25;
		Contact contact = dao.get(id);
		if(contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id = 26;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		List<Contact> listContacts = dao.get();
		for(Contact ac : listContacts) {
			System.out.println(ac);
		}
		
		assertTrue(!listContacts.isEmpty());
	}

}
