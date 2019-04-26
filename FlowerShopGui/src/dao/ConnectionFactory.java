package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean flag = false;

	static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL = "jdbc:derby:FlowershopData;create=true";

	public ConnectionFactory() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL);

			if (con != null)
				System.out.println("Connected");

			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
