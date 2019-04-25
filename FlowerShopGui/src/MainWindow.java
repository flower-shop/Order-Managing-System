import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 3434469359320329958L;
	private static Color BACKGROUND_PANEL_COLOR = new Color(Integer.parseInt("ffcbbc", 16));
	private static Color BACKGROUND_TAB_COLOR = new Color(Integer.parseInt("bee8d9", 16));
	private static Integer MAX_ROW_COUNT = 256;

	private JTextField firstNameInputField = new JTextField();
	private JTextField lastNameInputField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JTextField deliveryAddressTextField = new JTextField();
	private JTextField quantityTextField = new JTextField();
	private JTextField cardInfoTextField = new JTextField();
	private JDateChooser dateChooser = new JDateChooser();
	private JComboBox<FlowerType> flowerTypeComboBox = new JComboBox<>(FlowerType.values());
	private JComboBox<AccessoryType> accessoryTypeComboBox = new JComboBox<>(AccessoryType.values());
	private JComboBox<ArrangementTheme> arrangementThemeComboBox = new JComboBox<>(ArrangementTheme.values());

	public MainWindow() {

		// ----------------------------------------------------------------------
		// --------------------Pane 1 - New Order
		// ----------------------------------------------------------------------

		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Customer info"));
		customerInfoPanel.setBackground(BACKGROUND_TAB_COLOR);

		JLabel firstNameLabel = new JLabel("First name");

		JLabel lastNameLabel = new JLabel("Last name");

		JLabel phoneNumberLabel = new JLabel("Phone number");

		JLabel emailLabel = new JLabel("Email");

		GroupLayout customerInfoLayout = new GroupLayout(customerInfoPanel);
		customerInfoPanel.setLayout(customerInfoLayout);
		customerInfoLayout.setAutoCreateContainerGaps(true);
		customerInfoLayout.setAutoCreateGaps(true);

		customerInfoLayout.setHorizontalGroup(customerInfoLayout.createSequentialGroup()
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(firstNameLabel).addComponent(emailLabel))
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(firstNameInputField).addComponent(emailTextField))
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lastNameLabel).addComponent(phoneNumberLabel))
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(lastNameInputField).addComponent(phoneNumberTextField)));

		customerInfoLayout.setVerticalGroup(customerInfoLayout.createSequentialGroup()
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(firstNameLabel).addComponent(firstNameInputField)
						.addComponent(lastNameLabel).addComponent(lastNameInputField))
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(phoneNumberLabel).addComponent(phoneNumberTextField)
						.addComponent(emailLabel).addComponent(emailTextField)));

		JPanel deliveryInfoPanel = new JPanel();
		deliveryInfoPanel.setBorder(BorderFactory.createTitledBorder("Delivery info"));
		deliveryInfoPanel.setBackground(BACKGROUND_TAB_COLOR);

		JLabel deliveryAddressLabel = new JLabel("Delivery address");
		JLabel deliveryDateLabel = new JLabel("Delivery date");

		dateChooser.setBackground(BACKGROUND_TAB_COLOR);

		GroupLayout deliveryInfoLayout = new GroupLayout(deliveryInfoPanel);
		deliveryInfoLayout.setHorizontalGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(deliveryInfoLayout.createSequentialGroup()
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deliveryAddressLabel).addComponent(deliveryDateLabel))
						.addGap(18)
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deliveryAddressTextField, GroupLayout.PREFERRED_SIZE, 641,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 166,
										GroupLayout.PREFERRED_SIZE))
						.addGap(106)));
		deliveryInfoLayout
				.setVerticalGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(deliveryInfoLayout.createSequentialGroup()
								.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(deliveryAddressLabel)
										.addComponent(deliveryAddressTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(deliveryDateLabel, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		deliveryInfoLayout.setAutoCreateGaps(true);
		deliveryInfoLayout.setAutoCreateContainerGaps(true);
		deliveryInfoPanel.setLayout(deliveryInfoLayout);

		JPanel orderInfoPanel = new JPanel();
		orderInfoPanel.setBorder(BorderFactory.createTitledBorder("Order info"));
		orderInfoPanel.setBackground(BACKGROUND_TAB_COLOR);

		JLabel flowerTypeLabel = new JLabel("Flower type");

		JLabel unitPriceLabel = new JLabel("Unit price");
		JTextField unitPriceTextField = new JTextField();
		unitPriceTextField.setEditable(false);
		unitPriceTextField.setFocusable(false);

		JLabel quantityLabel = new JLabel("Quantity");

		JLabel accessoryTypeLabel = new JLabel("Accessory type");

		JLabel arrangementThemeLabel = new JLabel("Arrangement theme");

		JLabel cardLabel = new JLabel("Card");
		JRadioButton noRadioButton = new JRadioButton("No", true);

		JRadioButton yesRadioButton = new JRadioButton("Yes");
		ButtonGroup cardOptionsButtonGroup = new ButtonGroup();

		cardOptionsButtonGroup.add(noRadioButton);
		cardOptionsButtonGroup.add(yesRadioButton);

		cardInfoTextField.setToolTipText("Card text goes here");

		GroupLayout orderInfoLayout = new GroupLayout(orderInfoPanel);
		orderInfoLayout.setAutoCreateGaps(true);
		orderInfoLayout.setAutoCreateContainerGaps(true);

		orderInfoLayout.setHorizontalGroup(orderInfoLayout.createParallelGroup()
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(flowerTypeLabel)
						.addComponent(flowerTypeComboBox).addComponent(unitPriceLabel)
						.addComponent(unitPriceTextField).addComponent(quantityLabel)
						.addComponent(quantityTextField))
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(accessoryTypeLabel)
						.addComponent(accessoryTypeComboBox).addComponent(arrangementThemeLabel)
						.addComponent(arrangementThemeComboBox))
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(cardLabel)
						.addComponent(noRadioButton).addComponent(yesRadioButton)
						.addComponent(cardInfoTextField)));

		orderInfoLayout.setVerticalGroup(orderInfoLayout.createSequentialGroup()
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(flowerTypeLabel).addComponent(flowerTypeComboBox)
						.addComponent(unitPriceLabel).addComponent(unitPriceTextField)
						.addComponent(quantityLabel).addComponent(quantityTextField))
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(accessoryTypeLabel).addComponent(accessoryTypeComboBox)
						.addComponent(arrangementThemeLabel).addComponent(arrangementThemeComboBox))
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cardLabel).addComponent(noRadioButton).addComponent(yesRadioButton)
						.addComponent(cardInfoTextField)));

		orderInfoPanel.setLayout(orderInfoLayout);

		FlowLayout orderTotalLayout = new FlowLayout();
		orderTotalLayout.setAlignment(FlowLayout.LEFT);
		JPanel orderTotalPanel = new JPanel();
		orderTotalPanel.setBackground(BACKGROUND_TAB_COLOR);
		orderTotalPanel.setLayout(orderTotalLayout);

		JLabel orderTotalLabel = new JLabel("Order total");
		JTextField orderTotalTextField = new JTextField();
		orderTotalTextField.setFocusable(false);
		orderTotalTextField.setColumns(4);
		orderTotalTextField.setEditable(false);

		orderTotalPanel.add(orderTotalLabel);
		orderTotalPanel.add(orderTotalTextField);

		FlowLayout controlButtonsLayout = new FlowLayout();
		controlButtonsLayout.setAlignment(FlowLayout.CENTER);
		controlButtonsLayout.setHgap(100);

		JButton placeOrder = new JButton("Place Order");
		placeOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		placeOrder.setBackground(BACKGROUND_PANEL_COLOR);

		JPanel controlButtonsPanel = new JPanel();
		controlButtonsPanel.setBackground(BACKGROUND_TAB_COLOR);
		controlButtonsPanel.setLayout(controlButtonsLayout);

		JButton cancelOrder = new JButton("Cancel Order");
		cancelOrder.setAlignmentX(0.5f);
		cancelOrder.setBackground(BACKGROUND_PANEL_COLOR);
		controlButtonsPanel.add(cancelOrder);
		Component verticalGlue = Box.createVerticalGlue();
		controlButtonsPanel.add(verticalGlue);
		controlButtonsPanel.add(placeOrder);

		JPanel newOrderPanel = new JPanel();
		newOrderPanel.setBackground(BACKGROUND_TAB_COLOR);
		BoxLayout newOrderLayout = new BoxLayout(newOrderPanel, BoxLayout.Y_AXIS);
		newOrderPanel.add(Box.createVerticalGlue());
		newOrderPanel.add(customerInfoPanel);
		newOrderPanel.add(Box.createVerticalGlue());
		newOrderPanel.add(deliveryInfoPanel);
		newOrderPanel.add(Box.createVerticalGlue());
		newOrderPanel.add(orderInfoPanel);
		newOrderPanel.add(Box.createVerticalGlue());
		newOrderPanel.add(orderTotalPanel);
		newOrderPanel.add(controlButtonsPanel);
		newOrderPanel.add(Box.createVerticalGlue());
		newOrderPanel.setLayout(newOrderLayout);

		// ----------------------------------------------------------------------
		// --------------------Pane 2 - Inventory
		// ----------------------------------------------------------------------
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBackground(BACKGROUND_TAB_COLOR);
		String[] inventoryColumnNames = {"Flower Type", "Price", "Quantity"};
		Object[][] inventoryContent = new Object[MainWindow.MAX_ROW_COUNT][3];
		for (int i = 0; i < MAX_ROW_COUNT; i++) {
			inventoryContent[i] = new Object[]{"", "", ""};
		}
		JTable inventoryTable = new JTable(inventoryContent, inventoryColumnNames);
		JScrollPane inventoryScrollPane = new JScrollPane(inventoryTable);

		FlowLayout inventoryControlButtonsLayout = new FlowLayout();
		inventoryControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		inventoryControlButtonsLayout.setHgap(100);

		JButton inventoryCancelButton = new JButton("Cancel");
		inventoryCancelButton.setBackground(BACKGROUND_PANEL_COLOR);

		JButton inventoryUpdateButton = new JButton("Update inventory");
		inventoryUpdateButton.setBackground(BACKGROUND_PANEL_COLOR);

		JPanel inventoryControlButtonsPanel = new JPanel();
		inventoryControlButtonsPanel.setBackground(BACKGROUND_TAB_COLOR);
		inventoryControlButtonsPanel.setLayout(inventoryControlButtonsLayout);
		inventoryControlButtonsPanel.add(inventoryCancelButton);

		Component verticalGlue_1 = Box.createVerticalGlue();
		inventoryControlButtonsPanel.add(verticalGlue_1);
		inventoryControlButtonsPanel.add(inventoryUpdateButton);

		GroupLayout inventoryPanelLayout = new GroupLayout(inventoryPanel);
		inventoryPanel.setLayout(inventoryPanelLayout);
		inventoryPanelLayout.setAutoCreateGaps(true);
		inventoryPanelLayout.setAutoCreateContainerGaps(true);

		inventoryPanelLayout.setHorizontalGroup(inventoryPanelLayout.createParallelGroup()
				.addComponent(inventoryScrollPane).addComponent(inventoryControlButtonsPanel));

		inventoryPanelLayout.setVerticalGroup(inventoryPanelLayout.createSequentialGroup()
				.addComponent(inventoryScrollPane).addComponent(inventoryControlButtonsPanel));
		
		// ----------------------------------------------------------------------
		// --------------------Pane 3 - Customers
		// ----------------------------------------------------------------------
		
		JPanel customersPanel = new JPanel();
		customersPanel.setBackground(BACKGROUND_TAB_COLOR);
        String[] customersColumnNames = new String[] {
                "First Name", "Last Name", "Phone Number", "Email"
        };
        Object[][] customersContent = new Object[MainWindow.MAX_ROW_COUNT][4];
        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            customersContent[i] = new Object[] {"", "", "", "", ""};
        }
        JTable customersTable = new JTable(customersContent, customersColumnNames);
        JScrollPane customersScrollPane = new JScrollPane(customersTable);
        customersPanel.add(customersScrollPane);
        GroupLayout customersLayout = new GroupLayout(customersPanel);
        customersLayout.setHorizontalGroup(
        	customersLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(customersLayout.createSequentialGroup()
        			.addComponent(customersScrollPane, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        			.addContainerGap())
        );
        customersLayout.setVerticalGroup(
        	customersLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(customersLayout.createSequentialGroup()
        			.addComponent(customersScrollPane, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(45, Short.MAX_VALUE))
        );
        customersLayout.setAutoCreateGaps(true);
        customersLayout.setAutoCreateContainerGaps(true);
        customersPanel.setLayout(customersLayout);

		// ----------------------------------------------------------------------
		// --------------------Pane 4 - Orders
		// ----------------------------------------------------------------------
        JPanel ordersPanel = new JPanel();
        ordersPanel.setBackground(BACKGROUND_TAB_COLOR);
        String[] ordersColumnNames = new String[] {
                "Order Date", "First Name", "Last Name", "Flower", "Quantity", "Accessory", "Arrangement", "Address", "Delivery Date",  "Total Cost", "Card", "Text", "Paid", "Delivered"
        };
        Object[][] ordersContent = new Object[MainWindow.MAX_ROW_COUNT][14];
        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            ordersContent[i] = new Object[] {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        }
        JTable ordersTable = new JTable(ordersContent, ordersColumnNames);
        JScrollPane ordersScrollPane = new JScrollPane(ordersTable);

        JButton ordersCancelButton = new JButton("Cancel");
        ordersCancelButton.setBackground(BACKGROUND_PANEL_COLOR);

        JButton ordersUpdateButton = new JButton("Update Records");
        ordersUpdateButton.setBackground(BACKGROUND_PANEL_COLOR);

        FlowLayout ordersControlButtonsLayout = new FlowLayout();
        ordersControlButtonsLayout.setAlignment(FlowLayout.CENTER);
        ordersControlButtonsLayout.setHgap(100);

        JPanel ordersControlButtonsPanel = new JPanel(ordersControlButtonsLayout);
        ordersControlButtonsPanel.setBackground(BACKGROUND_TAB_COLOR);
        ordersControlButtonsPanel.add(ordersCancelButton);
        
        Component verticalGlue_2 = Box.createVerticalGlue();
        ordersControlButtonsPanel.add(verticalGlue_2);
        ordersControlButtonsPanel.add(ordersUpdateButton);

        GroupLayout ordersLayout = new GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersLayout);
        ordersLayout.setAutoCreateGaps(true);
        ordersLayout.setAutoCreateContainerGaps(true);

        ordersLayout.setHorizontalGroup(
                ordersLayout.createParallelGroup()
                    .addComponent(ordersScrollPane)
                    .addComponent(ordersControlButtonsPanel)
        );

        ordersLayout.setVerticalGroup(
                ordersLayout.createSequentialGroup()
                    .addComponent(ordersScrollPane)
                    .addComponent(ordersControlButtonsPanel)
        );        
        
		// ----------------------------------------------------------------------
		// --------------------Pane 5 - Employees
		// ----------------------------------------------------------------------   
        
        JPanel employeesPanel = new JPanel();
        employeesPanel.setBackground(BACKGROUND_TAB_COLOR);
        String[] employeesColumnNames = new String[] {
                "Last Name", "First Name", "Employee ID", "Password", "Admin Privileges"
        };
        Object[][] employeesContent = new Object[MainWindow.MAX_ROW_COUNT][5];
        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            employeesContent[i] = new Object[] {"", "", "", "", ""};
        }
        JTable employeesTable = new JTable(employeesContent, employeesColumnNames);
        JScrollPane employeeScrollPane = new JScrollPane(employeesTable);

        JButton employeeCancelButton = new JButton("Cancel");
        employeeCancelButton.setBackground(BACKGROUND_PANEL_COLOR);

        JButton employeeUpdateButton = new JButton("Update Record");
        employeeUpdateButton.setBackground(BACKGROUND_PANEL_COLOR);

        FlowLayout employeeControlButtonsLayout = new FlowLayout();
        employeeControlButtonsLayout.setAlignment(FlowLayout.CENTER);
        employeeControlButtonsLayout.setHgap(100);

        JPanel employeeControlButtonsPanel = new JPanel(employeeControlButtonsLayout);
        employeeControlButtonsPanel.setBackground(BACKGROUND_TAB_COLOR);
        employeeControlButtonsPanel.setLayout(employeeControlButtonsLayout);

        employeeControlButtonsPanel.add(employeeCancelButton);
        
        Component verticalGlue_3 = Box.createVerticalGlue();
        employeeControlButtonsPanel.add(verticalGlue_3);
        employeeControlButtonsPanel.add(employeeUpdateButton);

        GroupLayout employeeLayout = new GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeeLayout);
        employeeLayout.setAutoCreateGaps(true);
        employeeLayout.setAutoCreateContainerGaps(true);

        employeeLayout.setVerticalGroup(
                employeeLayout.createSequentialGroup()
                    .addComponent(employeeScrollPane)
                    .addComponent(employeeControlButtonsPanel)
        );

        employeeLayout.setHorizontalGroup(
                employeeLayout.createParallelGroup()
                    .addComponent(employeeScrollPane)
                    .addComponent(employeeControlButtonsPanel)
        );        
        
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.addTab("New Order", newOrderPanel);
		tabbedPane.addTab("Inventory", inventoryPanel);
		tabbedPane.addTab("Customers", customersPanel);
		tabbedPane.addTab("Orders", ordersPanel);
        tabbedPane.addTab("Employees", employeesPanel);
		getContentPane().add(tabbedPane);
		setResizable(true);
		getContentPane().setBackground(BACKGROUND_PANEL_COLOR);
		setTitle("Flower Shop");
		setSize(1200, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
