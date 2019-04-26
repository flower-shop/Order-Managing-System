import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
//@formatter:off
public class FlowerShopGui extends JFrame {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL = "jdbc:derby:FlowershopData;create=true";

	static Connection connection = null;
	static Statement statement = null;

	private FlowerShopGui() {
//		try {
//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(DB_URL);
//			if (connection != null) {
//				System.out.println("Connected");
//				
//				statement = connection.createStatement();
//			
//				String sql = "INSERT INTO Employee(lastName, firstName, employeeId, password, isAdmin) VALUES ('DeBenedictis','James','123','1234','yes')";
//
//				statement.executeUpdate(sql);
//				
//				sql = "UPDATE Employee SET lastName = 'Sdkajsfh' WHERE employeeId = '123'";
//				
//				statement.executeUpdate(sql);
//			}
//		} catch (SQLException se1) {
//			System.out.println("Failed to connect");
//			System.out.println(se1);
//		} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			try {
//				if (statement != null)
//					statement.close();
//			} catch (SQLException se2) {
//				System.out.println(se2);
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException se3) {
//				System.out.println(se3);
//			}
//		}

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
