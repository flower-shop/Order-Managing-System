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
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL);
			if (conn != null) {
				System.out.println("Connected");
				
//				statement = conn.createStatement();
//				
//				String sql = "INSERT INTO Employee(lastName, firstName, employeeId, password, isAdmin) VALUES ('DeBenedictis','James','123','1234','yes')";
//				
//				statement.executeUpdate(sql);
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

		this.setLookAndFeel();
		new MainWindow();
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
