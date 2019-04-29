package view;

import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.CustomerDAO;
import dto.CustomerDTO;

public class CustomersPanel extends JPanel {
	private static final long serialVersionUID = 3722861926434523695L;
	
	private JTable customersTable;
	
	private CustomerDAO customerDAO = new CustomerDAO();

	public CustomersPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		
		
		String[] customersColumnNames = new String[]{"First Name", "Last Name", "Phone Number", "Email"};
		
		TableModel tableModel = new DefaultTableModel(customersColumnNames, 0);
		
		customersTable = new JTable(tableModel) {
		
			private static final long serialVersionUID = 1286927826690876147L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		populateTable();

		
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
	
	public void populateTable() {
		List<CustomerDTO> customers = customerDAO.selectAll();

		DefaultTableModel tableModel = (DefaultTableModel) this.customersTable.getModel();
		tableModel.setRowCount(0);

		for (int i = 0; i < customers.size(); i++) {
			CustomerDTO customer = customers.get(i);
			Object[] customerContent = new Object[]{customer.getLastName(), customer.getFirstName(),
					customer.getPhoneNumber(), customer.getEmail()};

			tableModel.addRow(customerContent);
		}
	}
}
