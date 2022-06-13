package MySpring.MySpring.dao;

import java.util.List;

import MySpring.MySpring.model.Employee;

public interface EmployeeDAO {
	
	public int save(Employee employee);
	
	public int update(Employee employee);
	
	public Employee get(Integer id_employee);
	
	public int delete(Integer id_employee);
	
	public List<Employee> get();
	
	public List<Employee> employeExist(String first_name, String middle_name, String last_name, String birthay);
}
