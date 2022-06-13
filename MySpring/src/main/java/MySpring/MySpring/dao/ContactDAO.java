package MySpring.MySpring.dao;

import java.util.List;

import MySpring.MySpring.model.Contact;

public interface ContactDAO {
	public int save(Contact contact);
	
	public int update(Contact contact);
	
	public Contact get(Integer id);
	
	public int delete(Integer id);
	
	public List<Contact> get();
}
