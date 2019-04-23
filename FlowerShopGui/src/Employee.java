
public class Employee {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAdmin = false;

	public Employee(String lastName, String firstName, String username, String password, boolean isAdmin) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String employeeId) {
		this.username = employeeId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdminStatus(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
