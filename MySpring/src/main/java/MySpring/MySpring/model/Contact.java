package MySpring.MySpring.model;

public class Contact {
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String telephone;

	public Contact() {
		
	}
	
	public Contact(Integer id, String name, String email, String address, String telephone) {
		
		this(name, email, address, telephone);
		this.id = id;
	}
	
	public Contact(String name, String email, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return telephone;
	}

	public void setPhone(String phone) {
		this.telephone = phone;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", telephone="
				+ telephone + "]";
	}
	
	

}
