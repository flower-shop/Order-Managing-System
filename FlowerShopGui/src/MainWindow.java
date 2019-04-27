
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.CustomersPanel;
import view.EmployeesPanel;
import view.InventoryPanel;
import view.NewOrderPanel;
import view.OrdersPanel;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3434469359320329958L;
	private static Color BACKGROUND_PANEL_COLOR = new Color(Integer.parseInt("ffcbbc", 16));
	private static Color BACKGROUND_TAB_COLOR = new Color(Integer.parseInt("bee8d9", 16));
	private static Integer MAX_ROW_COUNT = 256;

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

	public MainWindow() {
		tabbedPane.addTab("New Order", new NewOrderPanel());
		tabbedPane.addTab("Inventory", new InventoryPanel());
		tabbedPane.addTab("Customers", new CustomersPanel());
		tabbedPane.addTab("Orders", new OrdersPanel());
		tabbedPane.addTab("Employees", new EmployeesPanel());
		getContentPane().add(tabbedPane);
		setResizable(true);
		getContentPane().setBackground(BACKGROUND_PANEL_COLOR);
		setTitle("Flower Shop");
		setSize(1200, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if (e.getSource().equals(employeeUpdateButton)) {
		// Read in employee fields

		// Validate
		// Create Employee DTO
		// Save new Employee in DAO
		// Finally, update view?

	}
}
