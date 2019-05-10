package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import dao.FlowerDAO;
import dao.OrderDAO;
import dto.FlowerDTO;
import dto.OrderDTO;
import enums.AccessoryType;
import enums.ArrangementTheme;

public class NewOrderPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -7938215989557472207L;

	private JTextField firstNameInputField = new JTextField();
	private JTextField lastNameInputField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JTextField deliveryAddressTextField = new JTextField();
	private JTextField quantityTextField = new JTextField();
	private JTextField cardInfoTextField = new JTextField();
	private JTextField orderTotalTextField = new JTextField();
	private JTextField unitPriceTextField = new JTextField();
	private JDateChooser dateChooser = new JDateChooser();
	private JRadioButton noRadioButton = new JRadioButton("No", true);
	private JRadioButton yesRadioButton = new JRadioButton("Yes");
	private static JComboBox<String> flowerTypeComboBox = new JComboBox<>();
	private JComboBox<AccessoryType> accessoryTypeComboBox = new JComboBox<>(AccessoryType.values());
	private JComboBox<ArrangementTheme> arrangementThemeComboBox = new JComboBox<>(ArrangementTheme.values());

	private static FlowerDAO flowerDAO = new FlowerDAO();
	private OrderDAO orderDAO = new OrderDAO();

	private JButton placeOrder = new JButton("Place Order");
	private JButton cancelOrder = new JButton("Cancel Order");

	public NewOrderPanel() {
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Customer info"));
		customerInfoPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

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
						.addComponent(firstNameLabel).addComponent(firstNameInputField).addComponent(lastNameLabel)
						.addComponent(lastNameInputField))
				.addGroup(customerInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(phoneNumberLabel).addComponent(phoneNumberTextField).addComponent(emailLabel)
						.addComponent(emailTextField)));

		JPanel deliveryInfoPanel = new JPanel();
		deliveryInfoPanel.setBorder(BorderFactory.createTitledBorder("Delivery info"));
		deliveryInfoPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		JLabel deliveryAddressLabel = new JLabel("Delivery address");
		JLabel deliveryDateLabel = new JLabel("Delivery date");

		dateChooser.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEditable(false);

		GroupLayout deliveryInfoLayout = new GroupLayout(deliveryInfoPanel);
		deliveryInfoLayout.setHorizontalGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(deliveryInfoLayout.createSequentialGroup()
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deliveryAddressLabel).addComponent(deliveryDateLabel))
						.addGap(18)
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deliveryAddressTextField, GroupLayout.PREFERRED_SIZE, 641,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
						.addGap(106)));
		deliveryInfoLayout.setVerticalGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(deliveryInfoLayout.createSequentialGroup()
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(deliveryAddressLabel).addComponent(deliveryAddressTextField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(deliveryInfoLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(deliveryDateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		deliveryInfoLayout.setAutoCreateGaps(true);
		deliveryInfoLayout.setAutoCreateContainerGaps(true);
		deliveryInfoPanel.setLayout(deliveryInfoLayout);

		JPanel orderInfoPanel = new JPanel();
		orderInfoPanel.setBorder(BorderFactory.createTitledBorder("Order info"));
		orderInfoPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		JLabel flowerTypeLabel = new JLabel("Flower type");

		JLabel unitPriceLabel = new JLabel("Unit price");

		unitPriceTextField.setEditable(false);
		unitPriceTextField.setFocusable(false);

		JLabel quantityLabel = new JLabel("Quantity");

		JLabel accessoryTypeLabel = new JLabel("Accessory type");

		JLabel arrangementThemeLabel = new JLabel("Arrangement theme");

		JLabel cardLabel = new JLabel("Card");

		ButtonGroup cardOptionsButtonGroup = new ButtonGroup();

		cardOptionsButtonGroup.add(noRadioButton);
		cardOptionsButtonGroup.add(yesRadioButton);

		cardInfoTextField.setToolTipText("Card text goes here");

		GroupLayout orderInfoLayout = new GroupLayout(orderInfoPanel);
		orderInfoLayout.setAutoCreateGaps(true);
		orderInfoLayout.setAutoCreateContainerGaps(true);

		orderInfoLayout.setHorizontalGroup(orderInfoLayout.createParallelGroup()
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(flowerTypeLabel)
						.addComponent(flowerTypeComboBox).addComponent(unitPriceLabel).addComponent(unitPriceTextField)
						.addComponent(quantityLabel).addComponent(quantityTextField))
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(accessoryTypeLabel)
						.addComponent(accessoryTypeComboBox).addComponent(arrangementThemeLabel)
						.addComponent(arrangementThemeComboBox))
				.addGroup(orderInfoLayout.createSequentialGroup().addComponent(cardLabel).addComponent(noRadioButton)
						.addComponent(yesRadioButton).addComponent(cardInfoTextField)));

		orderInfoLayout.setVerticalGroup(orderInfoLayout.createSequentialGroup()
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(flowerTypeLabel).addComponent(flowerTypeComboBox).addComponent(unitPriceLabel)
						.addComponent(unitPriceTextField).addComponent(quantityLabel).addComponent(quantityTextField))
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(accessoryTypeLabel).addComponent(accessoryTypeComboBox)
						.addComponent(arrangementThemeLabel).addComponent(arrangementThemeComboBox))
				.addGroup(orderInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cardLabel)
						.addComponent(noRadioButton).addComponent(yesRadioButton).addComponent(cardInfoTextField)));

		orderInfoPanel.setLayout(orderInfoLayout);

		FlowLayout orderTotalLayout = new FlowLayout();
		orderTotalLayout.setAlignment(FlowLayout.LEFT);
		JPanel orderTotalPanel = new JPanel();
		orderTotalPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		orderTotalPanel.setLayout(orderTotalLayout);

		JLabel orderTotalLabel = new JLabel("Order total");

		orderTotalTextField.setFocusable(false);
		orderTotalTextField.setColumns(4);
		orderTotalTextField.setEditable(false);

		quantityTextField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String quantity = quantityTextField.getText();
				String price = unitPriceTextField.getText();
				if (quantityTextField.getText().isEmpty()) {
					orderTotalTextField.setText(String.valueOf(0));
				} else {
					Double totalcost = (Double.valueOf(price) * Double.valueOf(quantity));
					orderTotalTextField.setText(CurrencyFormatter.formatDouble(totalcost));
				}
			}
		});

		orderTotalPanel.add(orderTotalLabel);
		orderTotalPanel.add(orderTotalTextField);

		FlowLayout controlButtonsLayout = new FlowLayout();
		controlButtonsLayout.setAlignment(FlowLayout.CENTER);
		controlButtonsLayout.setHgap(100);

		placeOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		placeOrder.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		placeOrder.addActionListener(this);

		JPanel controlButtonsPanel = new JPanel();
		controlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		controlButtonsPanel.setLayout(controlButtonsLayout);

		cancelOrder.setAlignmentX(0.5f);
		cancelOrder.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		cancelOrder.addActionListener(this);

		flowerTypeComboBox.addActionListener(this);

		controlButtonsPanel.add(cancelOrder);
		Component verticalGlue = Box.createVerticalGlue();
		controlButtonsPanel.add(verticalGlue);
		controlButtonsPanel.add(placeOrder);

		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		BoxLayout newOrderLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.add(Box.createVerticalGlue());
		this.add(customerInfoPanel);
		this.add(Box.createVerticalGlue());
		this.add(deliveryInfoPanel);
		this.add(Box.createVerticalGlue());
		this.add(orderInfoPanel);
		this.add(Box.createVerticalGlue());
		this.add(orderTotalPanel);
		this.add(controlButtonsPanel);
		this.add(Box.createVerticalGlue());
		this.setLayout(newOrderLayout);

		populateFlowerTypeComboBox();
	}

	public static void populateFlowerTypeComboBox() {
		flowerTypeComboBox.setModel(new DefaultComboBoxModel<String>());

		List<String> flowersInStock = flowerDAO.selectInStock();
		for (int i = 0; i < flowersInStock.size(); i++)
			flowerTypeComboBox.addItem(flowersInStock.get(i));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(flowerTypeComboBox)) {
			FlowerDAO flowerDAO = new FlowerDAO();
			String selectedItem = flowerTypeComboBox.getSelectedItem().toString();

			FlowerDTO flowerDTO = flowerDAO.select(selectedItem);

			unitPriceTextField.setText(Double.toString(flowerDTO.getFlowerCost()));
			orderTotalTextField.setText(String.valueOf(0));
			quantityTextField.setText(String.valueOf(0));

		} else if (e.getSource().equals(placeOrder)) {
			Date todayDate = new Date();
			List<OrderDTO> orders = orderDAO.selectAll();

			int orderNumber;

			if (orders.isEmpty()) {
				orderNumber = 0;
			} else {
				orderNumber = orders.get(orders.size() - 1).getOrderNumber();
				orderNumber++;
			}

			String orderDate = DateFormat.getDateInstance().format(todayDate);;
			String lastName = lastNameInputField.getText();
			String firstName = firstNameInputField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String email = emailTextField.getText();
			String flowerType = flowerTypeComboBox.getSelectedItem().toString();
			int quantity = Integer.parseInt(quantityTextField.getText());
			String accessoryType = accessoryTypeComboBox.getSelectedItem().toString();
			String arrangementTheme = arrangementThemeComboBox.getSelectedItem().toString();
			String address = deliveryAddressTextField.getText();
			String deliveryDate = DateFormat.getDateInstance().format(dateChooser.getDate());
			double totalCost = Double.parseDouble(orderTotalTextField.getText());
			String hasCard = "";

			if (yesRadioButton.isSelected()) {
				hasCard = "yes";
			} else {
				hasCard = "no";
			}

			String cardText = cardInfoTextField.getText();
			String isPaid = "no";
			String isDelivered = "no";

			orderDAO.insertOrder(new OrderDTO(orderNumber, orderDate, lastName, firstName, phoneNumber, email,
					flowerType, quantity, accessoryType, arrangementTheme, address, deliveryDate, totalCost, hasCard,
					cardText, isPaid, isDelivered));

			OrdersPanel.populateTable();
			CustomersPanel.populateTable();
			cancelOrder.doClick();

		} else if (e.getSource().equals(cancelOrder)) {
			firstNameInputField.setText("");
			lastNameInputField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			deliveryAddressTextField.setText("");
			quantityTextField.setText("0");
			cardInfoTextField.setText("");
			orderTotalTextField.setText("");
			dateChooser.setDateFormatString("");
		}
	}
}
