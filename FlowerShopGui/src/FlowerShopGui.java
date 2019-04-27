import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.MainWindow;
//@formatter:off
public class FlowerShopGui extends JFrame {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL = "jdbc:derby:FlowershopData;create=true";

	static Connection connection = null;
	static Statement statement = null;

	private FlowerShopGui() {
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
