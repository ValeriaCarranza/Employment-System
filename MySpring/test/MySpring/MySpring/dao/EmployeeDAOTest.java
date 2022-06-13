
package MySpring.MySpring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import MySpring.MySpring.model.Employee;

class EmployeeDAOTest {
	private DriverManagerDataSource dataSource;
	private EmployeeDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employmentsystem");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		dao = new EmployeeDAOImpl(dataSource);
	}
	
	@Test
	void testEmployeeDAOImpl() {
		fail("Not yet implemented");
	}

	
	@Test
	void testSave() {
		Employee employee = new Employee("Anahi", "Carranza", "Silva","1999/05/28", "jefe");
		int result = dao.save(employee);
		assertTrue(result > 0);
	}

	
	@Test
	void testUpdate() {
		Employee employee = new Employee(2,"Juan", "Carranza", "Silva","1999/04/20", "chalan");
		int result = dao.update(employee);
		
		assertTrue(result > 0);
	}

	
	@Test
	void testGetInteger() {
		Integer id = 1;
		Employee employee = dao.get(id);
		if(employee != null) {
			System.out.println(employee);
		}
		assertNotNull(employee);
	}

	
	@Test
	void testDelete() {
		Integer id = 3;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	
	@Test
	void testGet() {
		List<Employee> listEmployee = dao.get();
		for(Employee em : listEmployee) {
			System.out.println(em);
		}
		
		assertTrue(!listEmployee.isEmpty());
	}

}
