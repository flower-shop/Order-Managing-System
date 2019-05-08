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

	// INSERT INTO TABLE_NAME(
	// date_column
	// )values(
	// TO_DATE('06/06/2006', 'mm/dd/yyyy')
	// )

	public void insertOrder(OrderDTO pendingOrder) {
		String sql = "INSERT INTO Orders (orderID, orderDate, lastName, firstName, phoneNumber, email, flowerType, quantity, accessoryType, arrangementTheme, address, deliveryDate, totalCost, hasCard, cardText, isPaid, isDelivered) VALUES("
				+ pendingOrder.getOrderNumber() + ", '" + pendingOrder.getOrderDate() + "', '"
				+ pendingOrder.getLastName() + "', '" + pendingOrder.getFirstName() + "', '"
				+ pendingOrder.getPhoneNumber() + "', '" + pendingOrder.getEmail() + "', '"
				+ pendingOrder.getFlowerType() + "', " + pendingOrder.getFlowerQty() + ", '"
				+ pendingOrder.getAccessory() + "', '" + pendingOrder.getArrangementType() + "', '"
				+ pendingOrder.getAddress() + "', '" + pendingOrder.getDeliveryDate() + "', "
				+ pendingOrder.getTotalCost() + ", '" + pendingOrder.getHasCard() + "', '" + pendingOrder.getCardText()
				+ "', '" + pendingOrder.getIsPaidFor() + "', '" + pendingOrder.getIsDelivered() + "')";

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
}
