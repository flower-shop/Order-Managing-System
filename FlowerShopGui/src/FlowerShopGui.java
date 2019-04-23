import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
//@formatter:off
public class FlowerShopGui extends JFrame {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL = "jdbc:derby:FlowershopData;create=true";

	static Connection conn = null;
	static Statement statement = null;

	private FlowerShopGui() {
		this.setLookAndFeel();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				System.out.println("Connected");
				String createEmployeeTable = "CREATE TABLE Employee (\n" 
						+ "lastName varchar(20),\n"
						+ "firstName varchar(20),\n" 
						+ "username varchar(40),\n"
						+ "password varchar(20),\n" 
						+ "isAdmin varchar(5)\n" 
						+ ")";
				String createCustomerTable = "CREATE TABLE Customer (\n" 
						+ "lastName varchar(20),\n"
						+ "firstName varchar(20),\n" 
						+ "address varchar(40),\n"
						+ "phoneNumber varchar(20),\n" 
						+ "email varchar(40)\n" 
						+ ")";
				String createArrangementTable = "CREATE TABLE Employee (\n" 
						+ "cost decimal"
						+ "firstName varchar(20),\n" 
						+ "address varchar(40),\n"
						+ "phoneNumber varchar(20),\n" 
						+ "isAdmin varchar(5)\n" 
						+ ")";
				statement = conn.createStatement();
				statement.execute(createEmployeeTable);
			}
		} catch (SQLException se1) {
			System.out.println("Failed to connect");
			System.out.println(se1);
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se3) {
				se3.printStackTrace();
			}
		}

		MainWindow mw = new MainWindow();
		mw.setResizable(false);
		mw.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowerShopGui();
	}

	public void setLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
