import java.util.ArrayList;

public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private int phoneNumber;
	private String email;
	private ArrayList<Order> orderHistory = new ArrayList<>();

	public Customer(String lastName, String firstName, String address, int phoneNumber, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOrderHistory(ArrayList<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}
}
