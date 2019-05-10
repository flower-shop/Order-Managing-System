package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;

public class EmployeeDAO {
	private Connection con = null;
	private Statement stmt = null;

	public EmployeeDAO() {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EmployeeDTO select(String employeeId) {
		String query = "SELECT * FROM Employee WHERE employeeId='" + employeeId + "'";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return null;
			}

			if (resultSet.next()) {
				String firstName = resultSet.getString(1);
				String lastName = resultSet.getString(2);
				String empId = resultSet.getString(3);
				String password = resultSet.getString(4);
				String isAdmin = resultSet.getString(5);

				con.close();
				stmt.close();

				return new EmployeeDTO(firstName, lastName, empId, password, isAdmin);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public List<EmployeeDTO> selectAll() {
		List<EmployeeDTO> employees = new ArrayList<>();

		String query = "SELECT * FROM Employee";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return new ArrayList<>();
			}

			while (resultSet.next()) {
				String firstName = resultSet.getString(1);
				String lastName = resultSet.getString(2);
				String empId = resultSet.getString(3);
				String password = resultSet.getString(4);
				String isAdmin = resultSet.getString(5);

				employees.add(new EmployeeDTO(firstName, lastName, empId, password, isAdmin));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return employees;
	}

	public void insertEmployee(EmployeeDTO pendingEmployee) {
		String sql = "INSERT INTO Employee (lastName, firstName, employeeId, password, isAdmin) VALUES('"
				+ pendingEmployee.getLastName() + "', '" + pendingEmployee.getFirstName() + "', '"
				+ pendingEmployee.getEmployeeId() + "', '" + pendingEmployee.getPassword() + "', '"
				+ pendingEmployee.isAdmin() + "')";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Employee insert failed");
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public void updateEmployee(EmployeeDTO employee) {

		String sql = "UPDATE Employee SET lastName='" + employee.getLastName() + "', firstName='"
				+ employee.getFirstName() + "', employeeId='" + employee.getEmployeeId() + "', password='"
				+ employee.getPassword() + "', isAdmin='" + employee.isAdmin() + "' WHERE employeeId='"
				+ employee.getEmployeeId() + "'";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Employee update failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}