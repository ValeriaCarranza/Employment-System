package MySpring.MySpring.model;

public class Employee {
	private Integer id_employee;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String birth;
	private String position;

	public Employee() {

	}

	public Employee(int id_employee, String first_name, String middle_name, String last_name, String birth,
			String position) {
		this(first_name, middle_name, last_name, birth, position);
		this.id_employee = id_employee;
	}

	public Employee(String first_name, String middle_name, String last_name, String birth, String position) {
		super();
		this.id_employee = id_employee;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.birth = birth;
		this.position = position;
	}

	public Integer getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "employee [id_employee=" + id_employee + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", birth=" + birth + ", position=" + position + "]";
	}

}
