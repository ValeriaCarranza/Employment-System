package MySpring.MySpring.dao;

import java.util.List;

import MySpring.MySpring.model.Compensation;

public interface CompensationDAO {
	
	public int save(Compensation compensation);
	
	public int update(Compensation compensation);
	
	public Compensation get(Integer id_compensation);
	
	public int delete(Integer id_compensation);
	
	public List<Compensation> getCompensations(Integer id_employee, String month);
	
	public List<Compensation> getCompensations(Integer id_employee);
	
	public List<Compensation> salaryExist(Integer id_employee, String date);
	

}
