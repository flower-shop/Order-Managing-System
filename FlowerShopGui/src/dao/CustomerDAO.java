package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;

public class CustomerDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public CustomerDAO() {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> customers = new ArrayList<>();

		String query = "SELECT lastName, firstName, phoneNumber, email FROM Orders GROUP BY email, lastName, firstName, phoneNumber";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return new ArrayList<>();
			}

			while (resultSet.next()) {
				String lastName = resultSet.getString(1);
				String firstName = resultSet.getString(2);
				String phoneNumber = resultSet.getString(3);
				String email = resultSet.getString(4);

				customers.add(new CustomerDTO(lastName, firstName, phoneNumber, email));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return customers;
	}

	public void insertCustomer(CustomerDTO pendingCustomer) {
		String sql = "INSERT INTO Customer (lastName, firstName, phoneNumber, email) VALUES('"
				+ pendingCustomer.getLastName() + "', '" + pendingCustomer.getFirstName() + "', '"
				+ pendingCustomer.getPhoneNumber() + "', '" + pendingCustomer.getEmail() + "')";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Customer insert failed");
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}
}
