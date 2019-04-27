package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;

public class EmployeeDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public EmployeeDAO() {
		try {
			con = new ConnectionFactory().getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EmployeeDTO find(String employeeId) {
		String query = "SELECT * FROM Employee WHERE employeeId=" + employeeId;

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return null;
			}

			if (resultSet.next()) {
				String firstName = resultSet.getString(0);
				String lastName = resultSet.getString(1);
				String empId = resultSet.getString(2);
				String password = resultSet.getString(3);
				boolean isAdmin = resultSet.getBoolean(4);

				return new EmployeeDTO(firstName, lastName, empId, password, isAdmin);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public List<EmployeeDTO> findAll() {
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
				boolean isAdmin = resultSet.getBoolean(5);

				employees.add(new EmployeeDTO(firstName, lastName, empId, password, isAdmin));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return employees;
	}

	// public EmployeeDTO save(EmployeeDTO pendingEmployee) {
	//
	// }
}