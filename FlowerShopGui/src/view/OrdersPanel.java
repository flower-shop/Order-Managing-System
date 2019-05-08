package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.OrderDAO;
import dto.OrderDTO;

public class OrdersPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2666270557360720356L;

	private JButton ordersCancelButton = new JButton("Cancel");
	private JButton ordersUpdateButton = new JButton("Update Records");
	private JTable ordersTable;

	private OrderDAO orderDAO = new OrderDAO();

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

		ordersCancelButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);

		ordersUpdateButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);

		FlowLayout ordersControlButtonsLayout = new FlowLayout();
		ordersControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		ordersControlButtonsLayout.setHgap(100);

		JPanel ordersControlButtonsPanel = new JPanel(ordersControlButtonsLayout);
		ordersControlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		ordersControlButtonsPanel.add(ordersCancelButton);

		Component verticalGlue_2 = Box.createVerticalGlue();
		ordersControlButtonsPanel.add(verticalGlue_2);
		ordersControlButtonsPanel.add(ordersUpdateButton);

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
