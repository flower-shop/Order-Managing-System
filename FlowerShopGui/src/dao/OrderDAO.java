package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AccessoryDTO;
import dto.CustomerDTO;
import dto.FlowerDTO;
import dto.OrderDTO;

public class OrderDAO {
	private Connection con = null;
	private Statement stmt = null;
	
	public OrderDAO() {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public OrderDTO select(String orderId) {
		String query = "SELECT * FROM Orders WHERE orderId=" + orderId;

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return null;
			}

			if (resultSet.next()) {
				String totalCost = resultSet.getString(1);
				CustomerDTO customer = resultSet.getString(2);
				FlowerDTO flower = resultSet.getString(3);
				AccessoryDTO accessory = resultSet.getString(4);
				String arrangementTheme = resultSet.getString(5);
				String address = resultSet.getString(6);
				String orderNumber = resultSet.getString(7);
				String dateOfOrder = resultSet.getString(8);
				String dateOfDelivery = resultSet.getString(9);
				String hasCard = resultSet.getString(10);
				String cardText = resultSet.getString(11);
				String isPaidFor = resultSet.getString(12);
				

				return new OrderDTO(totalCost, customer, flower, accessory, arrangementTheme,address, orderNumber, dateOfOrder, 
						dateOfDelivery, hasCard, cardText, isPaidFor);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}*/
}
