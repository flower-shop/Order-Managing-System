package dto;

public class EmployeeDTO {
	private String firstName;
	private String lastName;
	private String employeeId;
	private String password;
	private String isAdmin;

	public EmployeeDTO(String lastName, String firstName, String employeeId, String password,
			String isAdmin) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.employeeId = employeeId;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getPassword() {
		return password;
	}

	public String isAdmin() {
		return isAdmin;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdminStatus(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}
