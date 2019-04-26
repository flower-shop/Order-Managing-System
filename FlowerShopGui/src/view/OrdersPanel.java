package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrdersPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2666270557360720356L;

	private JButton ordersCancelButton = new JButton("Cancel");
	private JButton ordersUpdateButton = new JButton("Update Records");

	public OrdersPanel() {

		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		String[] ordersColumnNames = new String[]{"Order Date", "First Name", "Last Name", "Flower",
				"Quantity", "Accessory", "Arrangement", "Address", "Delivery Date", "Total Cost", "Card",
				"Text", "Paid", "Delivered"};
		Object[][] ordersContent = new Object[ViewConstants.MAX_ROW_COUNT][14];
		for (int i = 0; i < ViewConstants.MAX_ROW_COUNT; i++) {
			ordersContent[i] = new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
		}
		JTable ordersTable = new JTable(ordersContent, ordersColumnNames);
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
}
