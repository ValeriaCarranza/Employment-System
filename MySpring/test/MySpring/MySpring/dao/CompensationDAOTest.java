package MySpring.MySpring.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import MySpring.MySpring.model.Compensation;
import MySpring.MySpring.model.Employee;

class CompensationDAOTest {
	private DriverManagerDataSource dataSource;
	private CompensationDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/employmentsystem");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		dao = new CompensationDAOImpl(dataSource);
	}

	@Test
	void testCompensationDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		Compensation compensation = new Compensation("Bonus", 400, "Bonus del mes", "2022/06/13", 1);
		int result = dao.save(compensation);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Compensation compensation = new Compensation(1, "Salary", 1500, "Sueldo del mes", "2022/12/06",1);
		int result = dao.update(compensation);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Compensation compensation = dao.get(id);
		if(compensation != null) {
			System.out.println(compensation);
		}
		assertNotNull(compensation);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testGetCompensations() {
		List<Compensation> listCom = dao.getCompensations(1, "2022/06/01");
		for(Compensation em : listCom) {
			System.out.println(em);
		}
		
		assertTrue(!listCom.isEmpty());
	}
	
}
