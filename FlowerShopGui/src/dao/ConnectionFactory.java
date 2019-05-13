package dao;
import java.sql.Connection;

/*
 * File: ConnectionFactory.java
 * Date: May 12, 2019
 * Authors: Olga Samborski, Jasmine Jones, Scott Hussey, and James DeBenedictis
 */

import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DB_URL = "jdbc:derby:FlowershopData;create=true";

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL);

			if (conn != null)
				System.out.println("Connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
