package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.OrderDAO;
import dto.OrderDTO;

public class OrdersPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2666270557360720356L;

	private JButton ordersUpdateButton = new JButton("Update Record");
	private JTable ordersTable;

	private OrderDAO orderDAO = new OrderDAO();

	private boolean popupWindowExists = false;

	private JTextField orderNumberTextField;
	private JTextField orderDateTextField;
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	private JTextField flowerTypeTextField;
	private JTextField quantityTextField;
	private JTextField accessoryTypeTextField;
	private JTextField arrangementThemeTextField;
	private JTextField addressTextField;
	private JTextField deliveryDateTextField;
	private JTextField totalCostTextField;
	private JTextField hasCardTextField;
	private JTextField cardTextTextField;
	private JTextField isPaidTextField;
	private JTextField isDeliveredTextField;

	public OrdersPanel() {

		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		String[] ordersColumnNames = new String[]{"Order Number", "Order Date", "First Name", "Last Name",
				"Phone Number", "Email", "Flower", "Quantity", "Accessory", "Arrangement", "Address", "Delivery Date",
				"Total Cost", "Card", "Text", "Paid", "Delivered"};
		TableModel tableModel = new DefaultTableModel(ordersColumnNames, 0);

		ordersTable = new JTable(tableModel) {
			private static final long serialVersionUID = 4312131604668103814L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		populateTable();

		JScrollPane ordersScrollPane = new JScrollPane(ordersTable);

		ordersUpdateButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		ordersUpdateButton.addActionListener(this);

		FlowLayout ordersControlButtonsLayout = new FlowLayout();
		ordersControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		ordersControlButtonsLayout.setHgap(100);

		JPanel ordersControlButtonsPanel = new JPanel(ordersControlButtonsLayout);
		ordersControlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		Component verticalGlue_2 = Box.createVerticalGlue();
		ordersControlButtonsPanel.add(verticalGlue_2);
		ordersControlButtonsPanel.add(ordersUpdateButton, FlowLayout.CENTER);

		GroupLayout ordersLayout = new GroupLayout(this);
		this.setLayout(ordersLayout);
		ordersLayout.setAutoCreateGaps(true);
		ordersLayout.setAutoCreateContainerGaps(true);

		ordersLayout.setHorizontalGroup(ordersLayout.createParallelGroup().addComponent(ordersScrollPane)
				.addComponent(ordersControlButtonsPanel));

		ordersLayout.setVerticalGroup(ordersLayout.createSequentialGroup().addComponent(ordersScrollPane)
				.addComponent(ordersControlButtonsPanel));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ordersUpdateButton)) {
			if (!popupWindowExists) {

				if (ordersTable.getSelectedRow() > -1) {
					MainWindow.getTabbedPane().setEnabled(false);

					new PopupWindow();

					int selectedRow = ordersTable.getSelectedRow();

					orderNumberTextField.setText(ordersTable.getValueAt(selectedRow, 0).toString());
					orderDateTextField.setText((String) ordersTable.getValueAt(selectedRow, 1));
					lastNameTextField.setText((String) ordersTable.getValueAt(selectedRow, 2));
					firstNameTextField.setText((String) ordersTable.getValueAt(selectedRow, 3));
					phoneNumberTextField.setText((String) ordersTable.getValueAt(selectedRow, 4));
					emailTextField.setText((String) ordersTable.getValueAt(selectedRow, 5));
					flowerTypeTextField.setText((String) ordersTable.getValueAt(selectedRow, 6));
					quantityTextField.setText(ordersTable.getValueAt(selectedRow, 7).toString());
					accessoryTypeTextField.setText((String) ordersTable.getValueAt(selectedRow, 8));
					arrangementThemeTextField.setText((String) ordersTable.getValueAt(selectedRow, 9));
					addressTextField.setText((String) ordersTable.getValueAt(selectedRow, 10));
					deliveryDateTextField.setText((String) ordersTable.getValueAt(selectedRow, 11));
					totalCostTextField.setText(ordersTable.getValueAt(selectedRow, 12).toString());
					hasCardTextField.setText((String) ordersTable.getValueAt(selectedRow, 13));
					cardTextTextField.setText((String) ordersTable.getValueAt(selectedRow, 14));
					isPaidTextField.setText((String) ordersTable.getValueAt(selectedRow, 15));
					isDeliveredTextField.setText((String) ordersTable.getValueAt(selectedRow, 16));

					orderNumberTextField.setEditable(false);
					orderNumberTextField.setFocusable(false);
					orderNumberTextField.setBackground(new Color(224, 224, 224));
				} else {
					JOptionPane.showMessageDialog(null, "Please select a row");
				}
			}
		}
	}

	class PopupWindow extends JFrame implements ActionListener {
		private static final long serialVersionUID = 4497145662567262927L;
		private String title;
		private JButton actionButton;

		public PopupWindow() {

			popupWindowExists = true;

			// ----------------------------------------------------------------------------------------------------
			// -------------------- Fields Panel
			// ----------------------------------------------------------------------------------------------------
			JPanel fieldsPanel = new JPanel();
			fieldsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

			fieldsPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weighty = 1;
			c.weightx = 1;

			JLabel orderNumberLabel = new JLabel("Order Number:");
			c.gridx = 0;
			c.gridy = 0;
			fieldsPanel.add(orderNumberLabel);

			JLabel orderDateLabel = new JLabel("Order Date:");
			c.gridx = 0;
			c.gridy = 1;
			fieldsPanel.add(orderDateLabel, c);

			JLabel lastNameLabel = new JLabel("Last Name:");
			c.gridx = 0;
			c.gridy = 2;
			fieldsPanel.add(lastNameLabel, c);

			JLabel firstNameLabel = new JLabel("First Name:");
			c.gridx = 0;
			c.gridy = 3;
			fieldsPanel.add(firstNameLabel, c);

			JLabel phoneNumberLabel = new JLabel("Phone Number:");
			c.gridx = 0;
			c.gridy = 4;
			fieldsPanel.add(phoneNumberLabel, c);

			JLabel emailLabel = new JLabel("Email:");
			c.gridx = 0;
			c.gridy = 5;
			fieldsPanel.add(emailLabel, c);

			JLabel flowerTypeLabel = new JLabel("Flower Type:");
			c.gridx = 0;
			c.gridy = 6;
			fieldsPanel.add(flowerTypeLabel, c);

			JLabel quantityLabel = new JLabel("Quantity:");
			c.gridx = 0;
			c.gridy = 7;
			fieldsPanel.add(quantityLabel, c);

			JLabel accessoryLabel = new JLabel("Accessory:");
			c.gridx = 0;
			c.gridy = 8;
			fieldsPanel.add(accessoryLabel, c);

			JLabel arrangementLabel = new JLabel("Arrangement:");
			c.gridx = 2;
			c.gridy = 0;
			fieldsPanel.add(arrangementLabel, c);

			JLabel addressLabel = new JLabel("Address:");
			c.gridx = 2;
			c.gridy = 1;
			fieldsPanel.add(addressLabel, c);

			JLabel deliveryDateLabel = new JLabel("Delivery Date:");
			c.gridx = 2;
			c.gridy = 2;
			fieldsPanel.add(deliveryDateLabel, c);

			JLabel totalCostLabel = new JLabel("Total Cost:");
			c.gridx = 2;
			c.gridy = 3;
			fieldsPanel.add(totalCostLabel, c);

			JLabel hasCardLabel = new JLabel("Card:");
			c.gridx = 2;
			c.gridy = 4;
			fieldsPanel.add(hasCardLabel, c);

			JLabel cardTextLabel = new JLabel("Card Text:");
			c.gridx = 2;
			c.gridy = 5;
			fieldsPanel.add(cardTextLabel, c);

			JLabel isPaidLabel = new JLabel("Paid:");
			c.gridx = 2;
			c.gridy = 6;
			fieldsPanel.add(isPaidLabel, c);

			JLabel isDeliveredLabel = new JLabel("Delivered:");
			c.gridx = 2;
			c.gridy = 7;
			fieldsPanel.add(isDeliveredLabel, c);

			orderNumberTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 0;
			fieldsPanel.add(orderNumberTextField, c);

			orderDateTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 1;
			fieldsPanel.add(orderDateTextField, c);

			lastNameTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 2;
			fieldsPanel.add(lastNameTextField, c);

			firstNameTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 3;
			fieldsPanel.add(firstNameTextField, c);

			phoneNumberTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 4;
			fieldsPanel.add(phoneNumberTextField, c);

			emailTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 5;
			fieldsPanel.add(emailTextField, c);

			flowerTypeTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 6;
			fieldsPanel.add(flowerTypeTextField, c);

			quantityTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 7;
			fieldsPanel.add(quantityTextField, c);

			accessoryTypeTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 8;
			fieldsPanel.add(accessoryTypeTextField, c);

			arrangementThemeTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 0;
			fieldsPanel.add(arrangementThemeTextField, c);

			addressTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 1;
			fieldsPanel.add(addressTextField, c);

			deliveryDateTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 2;
			fieldsPanel.add(deliveryDateTextField, c);

			totalCostTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 3;
			fieldsPanel.add(totalCostTextField, c);

			hasCardTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 4;
			fieldsPanel.add(hasCardTextField, c);

			cardTextTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 5;
			fieldsPanel.add(cardTextTextField, c);

			isPaidTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 6;
			fieldsPanel.add(isPaidTextField, c);

			isDeliveredTextField = new JTextField(15);
			c.gridx = 3;
			c.gridy = 7;
			fieldsPanel.add(isDeliveredTextField, c);

			// ----------------------------------------------------------------------------------------------------
			// -------------------- Button Panel
			// ----------------------------------------------------------------------------------------------------

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
			actionButton = new JButton();
			actionButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);

			actionButton.addActionListener(this);

			title = "Update Order";
			actionButton.setText("Update");

			buttonPanel.add(actionButton);

			// ----------------------------------------------------------------------------------------------------
			// -------------------- The Window
			// ----------------------------------------------------------------------------------------------------
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					popupWindowExists = false;
					MainWindow.getTabbedPane().setEnabled(true);
				}
			});

			this.setLayout(new BorderLayout());
			this.add(fieldsPanel, BorderLayout.CENTER);
			this.add(buttonPanel, BorderLayout.SOUTH);
			this.setTitle(title);
			this.setAlwaysOnTop(true);

			this.getContentPane().setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
			this.setSize(700, 500);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		}

		public void actionPerformed(ActionEvent e) {
			int orderNumber = Integer.parseInt(orderNumberTextField.getText());
			String orderDate = orderDateTextField.getText();
			String lastName = lastNameTextField.getText();
			String firstName = firstNameTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String email = emailTextField.getText();
			String flowerType = flowerTypeTextField.getText();
			int quantity = Integer.parseInt(quantityTextField.getText());
			String accessoryType = accessoryTypeTextField.getText();
			String arrangementTheme = arrangementThemeTextField.getText();
			String address = addressTextField.getText();
			String deliveryDate = deliveryDateTextField.getText();
			double totalCost = Double.parseDouble(totalCostTextField.getText());
			String hasCard = hasCardTextField.getText();
			String cardText = cardTextTextField.getText();
			String isPaid = isPaidTextField.getText();
			String isDelivered = isDeliveredTextField.getText();

			orderDAO.updateOrder(new OrderDTO(orderNumber, orderDate, lastName, firstName, phoneNumber, email,
					flowerType, quantity, accessoryType, arrangementTheme, address, deliveryDate, totalCost, hasCard,
					cardText, isPaid, isDelivered));

			populateTable();

			MainWindow.getTabbedPane().setEnabled(true);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}

	public void populateTable() {
		List<OrderDTO> orders = orderDAO.selectAll();

		DefaultTableModel tableModel = (DefaultTableModel) this.ordersTable.getModel();
		tableModel.setRowCount(0);

		for (int i = 0; i < orders.size(); i++) {
			OrderDTO order = orders.get(i);
			Object[] orderContent = new Object[]{order.getOrderNumber(), order.getOrderDate(), order.getFirstName(),
					order.getLastName(), order.getPhoneNumber(), order.getEmail(), order.getFlowerType(),
					order.getFlowerQty(), order.getAccessory(), order.getArrangementType(), order.getAddress(),
					order.getDeliveryDate(), order.getTotalCost(), order.getHasCard(), order.getCardText(),
					order.getIsPaidFor(), order.getIsDelivered()};

			tableModel.addRow(orderContent);
		}
	}
}
