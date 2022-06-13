package MySpring.MySpring.model;

public class Compensation {
	private Integer id_compensation;
	private String type_com;
	private int amount;
	private String description_com;
	private String date_com;
	private Integer id_employee;
	
	public Compensation() {
		
	}
	
	public Compensation(Integer id_compensation, String type_com, int amount, String description_com, String date_com,
			Integer id_employee) {
		this(type_com, amount,description_com, date_com, id_employee);
		this.id_compensation = id_compensation;
		
	}
	
	public Compensation(String type_com, int amount, String description_com, String date_com,
			Integer id_employee) {
		super();
		
		this.type_com = type_com;
		this.amount = amount;
		this.description_com = description_com;
		this.date_com = date_com;
		this.id_employee = id_employee;
	}

	public Integer getId_compensation() {
		return id_compensation;
	}

	public void setId_compensation(Integer id_compensation) {
		this.id_compensation = id_compensation;
	}

	public String getType_com() {
		return type_com;
	}

	public void setType_com(String type_com) {
		this.type_com = type_com;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription_com() {
		return description_com;
	}

	public void setDescription_com(String description_com) {
		this.description_com = description_com;
	}

	public String getDate_com() {
		return date_com;
	}

	public void setDate_com(String date_com) {
		this.date_com = date_com;
	}

	public Integer getId_employee() {
		return id_employee;
	}

	public void setId_employee(Integer id_employee) {
		this.id_employee = id_employee;
	}

	@Override
	public String toString() {
		return "Compensation [id_compensation=" + id_compensation + ", type_com=" + type_com + ", amount=" + amount
				+ ", description_com=" + description_com + ", date_com=" + date_com + ", id_employee=" + id_employee
				+ "]";
	}

}
