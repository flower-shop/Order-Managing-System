import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.MainWindow;

public class FlowerShopGui extends JFrame {
	private static final long serialVersionUID = 8803195407449611129L;

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
