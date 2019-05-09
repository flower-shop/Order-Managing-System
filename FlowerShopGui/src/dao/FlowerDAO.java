package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.FlowerDTO;

public class FlowerDAO {
	
	private Connection con = null;
	private Statement stmt = null;
	
	public FlowerDAO() {
		try {
			con = ConnectionFactory.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FlowerDTO select(String flowerType) {
		String query = "SELECT * FROM Flower WHERE flowerType=" + flowerType;

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return null;
			}
			
			if (resultSet.next()) {
				String type = resultSet.getString(1);
				double flowerCost = resultSet.getDouble(2);
				int flowerQty = resultSet.getInt(3);

				return new FlowerDTO(type, flowerCost, flowerQty);
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public List<FlowerDTO> selectAll() {
		List<FlowerDTO> flowers = new ArrayList<>();

		String query = "SELECT * FROM Flower";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return new ArrayList<>();
			}

			while (resultSet.next()) {
				String type = resultSet.getString(1);
				double flowerCost = resultSet.getDouble(2);
				int flowerQty = resultSet.getInt(3);

				flowers.add(new FlowerDTO(type, flowerCost, flowerQty));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return flowers;
	}
	
	public List<String> selectInStock() {
		List<String> flowersInStock = new ArrayList<>();

		String query = "SELECT flowerType FROM Flower WHERE flowerQty != 0";

		try {
			ResultSet resultSet = stmt.executeQuery(query);

			if (resultSet == null) {
				return new ArrayList<>();
			}

			while (resultSet.next()) {
				String type = resultSet.getString(1);

				flowersInStock.add(new String(type));
			}
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
		return flowersInStock;
	}
	
	public void insertFlower(FlowerDTO pendingFlower) {
		String sql = "INSERT INTO Flower (flowerType, flowerCost, flowerQty) VALUES('"
				+ pendingFlower.getFlowerType() + "', " + pendingFlower.getFlowerCost() + ", "
				+ pendingFlower.getFlowerQty() + ")";

		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Inventory insert failed");
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}
	
	public void updateFlower(FlowerDTO flower) {
		String sql = "UPDATE Flower SET flowerType='" + flower.getFlowerType() + "', flowerCost="
				+ flower.getFlowerCost() + ", flowerQty=" + flower.getFlowerQty() + 
				" WHERE flowerType='" + flower.getFlowerType() + " ' ";
		System.out.println(sql);

		try {
			int rowCount = stmt.executeUpdate(sql);

			if (rowCount == 0) {
				System.out.println("Inventory update failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
