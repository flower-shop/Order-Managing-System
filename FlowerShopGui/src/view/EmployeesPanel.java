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

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeesPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 5803744138819090040L;

	private JButton employeeUpdateButton = new JButton("Update Record");
	private JButton employeeAddButton = new JButton("Add Record");
	private JTable employeesTable;

	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public EmployeesPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		employeeDAO.update(new EmployeeDTO("Smith", "James", "123", "food", true));
		List<EmployeeDTO> employees = employeeDAO.findAll();

		String[] employeesColumnNames = new String[]{"Last Name", "First Name", "Employee ID", "Password",
				"Admin Privileges"};
		Object[][] employeesContent = new Object[employees.size()][5];
		for (int i = 0; i < employees.size(); i++) {
			EmployeeDTO employee = employees.get(i);
			employeesContent[i] = new Object[]{employee.getLastName(), employee.getFirstName(),
					employee.getEmployeeId(), employee.getPassword(), employee.isAdmin()};
		}

		employeesTable = new JTable(employeesContent, employeesColumnNames) {
			private static final long serialVersionUID = 4312131604668103814L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// employeesTable = new JTable(employeesContent, employeesColumnNames);
		JScrollPane employeeScrollPane = new JScrollPane(employeesTable);

		employeeAddButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		employeeAddButton.addActionListener(this);

		employeeUpdateButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		employeeUpdateButton.addActionListener(this);

		FlowLayout employeeControlButtonsLayout = new FlowLayout();
		employeeControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		employeeControlButtonsLayout.setHgap(100);

		JPanel employeeControlButtonsPanel = new JPanel(employeeControlButtonsLayout);
		employeeControlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		employeeControlButtonsPanel.setLayout(employeeControlButtonsLayout);

		employeeControlButtonsPanel.add(employeeAddButton);

		Component verticalGlue_3 = Box.createVerticalGlue();
		employeeControlButtonsPanel.add(verticalGlue_3);
		employeeControlButtonsPanel.add(employeeUpdateButton);

		GroupLayout employeeLayout = new GroupLayout(this);
		this.setLayout(employeeLayout);
		employeeLayout.setAutoCreateGaps(true);
		employeeLayout.setAutoCreateContainerGaps(true);

		employeeLayout.setVerticalGroup(employeeLayout.createSequentialGroup()
				.addComponent(employeeScrollPane).addComponent(employeeControlButtonsPanel));

		employeeLayout.setHorizontalGroup(employeeLayout.createParallelGroup()
				.addComponent(employeeScrollPane).addComponent(employeeControlButtonsPanel));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(employeeAddButton)) {

		}
	}
}
