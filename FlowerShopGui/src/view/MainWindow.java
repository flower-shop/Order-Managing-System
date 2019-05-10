package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import dto.EmployeeDTO;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 3434469359320329958L;

	private static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

	public MainWindow(EmployeeDTO user) {
		tabbedPane.addTab("New Order", new NewOrderPanel());
		tabbedPane.addTab("Inventory", new InventoryPanel());
		tabbedPane.addTab("Customers", new CustomersPanel());
		tabbedPane.addTab("Orders", new OrdersPanel());

		if (user.isAdmin().equalsIgnoreCase("yes")) {
			tabbedPane.addTab("Employees", new EmployeesPanel());
		}

		getContentPane().add(tabbedPane);
		setResizable(true);
		getContentPane().setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		setTitle("Flower Shop Management Program: Logged in as " + user.getLastName() + ", " + user.getFirstName());
		setSize(1200, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
}
