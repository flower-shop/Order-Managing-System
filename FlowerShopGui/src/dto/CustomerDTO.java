package dto;
import java.util.ArrayList;

public class CustomerDTO {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private ArrayList<OrderDTO> orderHistory = new ArrayList<>();

	public CustomerDTO(String lastName, String firstName, /* String address, */String phoneNumber, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		/* this.address = address; */
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<OrderDTO> getOrderHistory() {
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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOrderHistory(ArrayList<OrderDTO> orderHistory) {
		this.orderHistory = orderHistory;
	}
}
