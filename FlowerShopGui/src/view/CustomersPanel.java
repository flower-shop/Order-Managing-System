package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomersPanel extends JPanel {
	private static final long serialVersionUID = 3722861926434523695L;

	public CustomersPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		String[] customersColumnNames = new String[]{"First Name", "Last Name", "Phone Number", "Email"};
		Object[][] customersContent = new Object[ViewConstants.MAX_ROW_COUNT][4];
		for (int i = 0; i < ViewConstants.MAX_ROW_COUNT; i++) {
			customersContent[i] = new Object[]{"", "", "", "", ""};
		}
		JTable customersTable = new JTable(customersContent, customersColumnNames);
		JScrollPane customersScrollPane = new JScrollPane(customersTable);
		this.add(customersScrollPane);
		GroupLayout customersLayout = new GroupLayout(this);
		customersLayout.setHorizontalGroup(customersLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(customersLayout.createSequentialGroup()
						.addComponent(customersScrollPane, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
						.addContainerGap()));
		customersLayout
				.setVerticalGroup(customersLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(customersLayout
								.createSequentialGroup().addComponent(customersScrollPane,
										GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(45, Short.MAX_VALUE)));
		customersLayout.setAutoCreateGaps(true);
		customersLayout.setAutoCreateContainerGaps(true);
		this.setLayout(customersLayout);
	}
}
