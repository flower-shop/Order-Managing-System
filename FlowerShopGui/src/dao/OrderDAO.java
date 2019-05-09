package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public OrderDTO select(String orderId) {
		String query = "SELECT * FROM Orders WHERE orderId=" + orderId;

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return null;
			}

			if (resultSet.next()) {
				int orderNumber = resultSet.getInt(1);
				String orderDate = resultSet.getString(2);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				String email = resultSet.getString(6);
				String flowerType = resultSet.getString(7);
				int flowerQty = resultSet.getInt(8);
				String accessory = resultSet.getString(9);
				String arrangementType = resultSet.getString(10);
				String address = resultSet.getString(11);
				String deliveryDate = resultSet.getString(12);
				double totalCost = resultSet.getDouble(13);
				String hasCard = resultSet.getString(14);
				String cardText = resultSet.getString(15);
				String isPaidFor = resultSet.getString(16);
				String isDelivered = resultSet.getString(17);

				return new OrderDTO(orderNumber, orderDate, firstName, lastName, phoneNumber, email, flowerType,
						flowerQty, accessory, arrangementType, address, deliveryDate, totalCost, hasCard, cardText,
						isPaidFor, isDelivered);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public List<OrderDTO> selectAll() {
		List<OrderDTO> orders = new ArrayList<>();

		String query = "SELECT * FROM Orders";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return new ArrayList<>();
			}

			while (resultSet.next()) {
				int orderNumber = resultSet.getInt(1);
				String orderDate = resultSet.getString(2);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				String email = resultSet.getString(6);
				String flowerType = resultSet.getString(7);
				int flowerQty = resultSet.getInt(8);
				String accessory = resultSet.getString(9);
				String arrangementType = resultSet.getString(10);
				String address = resultSet.getString(11);
				String deliveryDate = resultSet.getString(12);
				double totalCost = resultSet.getDouble(13);
				String hasCard = resultSet.getString(14);
				String cardText = resultSet.getString(15);
				String isPaidFor = resultSet.getString(16);
				String isDelivered = resultSet.getString(17);

				orders.add(new OrderDTO(orderNumber, orderDate, firstName, lastName, phoneNumber, email, flowerType,
						flowerQty, accessory, arrangementType, address, deliveryDate, totalCost, hasCard, cardText,
						isPaidFor, isDelivered));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return orders;
	}

	public void insertOrder(OrderDTO order) {
		String sql = "INSERT INTO Orders (orderID, orderDate, lastName, firstName, phoneNumber, email, flowerType, quantity, accessoryType, arrangementTheme, address, deliveryDate, totalCost, hasCard, cardText, isPaid, isDelivered) VALUES("
				+ order.getOrderNumber() + ", '" + order.getOrderDate() + "', '" + order.getLastName() + "', '"
				+ order.getFirstName() + "', '" + order.getPhoneNumber() + "', '" + order.getEmail() + "', '"
				+ order.getFlowerType() + "', " + order.getFlowerQty() + ", '" + order.getAccessoryType() + "', '"
				+ order.getArrangementTheme() + "', '" + order.getAddress() + "', '" + order.getDeliveryDate() + "', "
				+ order.getTotalCost() + ", '" + order.getHasCard() + "', '" + order.getCardText() + "', '"
				+ order.getIsPaidFor() + "', '" + order.getIsDelivered() + "')";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Order insert failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void updateOrder(OrderDTO order) {
		String sql = "UPDATE Orders SET orderID=" + order.getOrderNumber() + ", orderDate='" + order.getOrderDate()
				+ "', lastName ='" + order.getLastName() + "', firstName='" + order.getFirstName() + "', phoneNumber='"
				+ order.getPhoneNumber() + "', email='" + order.getEmail() + "', flowerType='" + order.getFlowerType()
				+ "', quantity=" + order.getFlowerQty() + ", accessoryType='" + order.getAccessoryType()
				+ "', arrangementTheme='" + order.getArrangementTheme() + "', address='" + order.getAddress()
				+ "', deliveryDate='" + order.getDeliveryDate() + "', totalCost=" + order.getTotalCost() + ", hasCard='"
				+ order.getHasCard() + "', cardText='" + order.getCardText() + "', isPaid='" + order.getIsPaidFor()
				+ "', isDelivered='" + order.getIsDelivered() + "'";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Order update failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
