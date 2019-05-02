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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeesPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 5803744138819090040L;

	private JButton employeeUpdateButton = new JButton("Update Record");
	private JButton employeeAddButton = new JButton("Add Record");
	private JTable employeesTable;

	private EmployeeDAO employeeDAO = new EmployeeDAO();

	private boolean popupWindowExists = false;

	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JTextField employeeIdTextField;
	private JTextField passwordTextField;
	private JTextField isAdminTextField;

	public EmployeesPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

		String[] employeesColumnNames = new String[]{"Last Name", "First Name", "Employee ID", "Password",
				"Admin Privileges"};

		TableModel tableModel = new DefaultTableModel(employeesColumnNames, 0);

		employeesTable = new JTable(tableModel) {
			private static final long serialVersionUID = 4312131604668103814L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		populateTable();

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

		employeeLayout.setVerticalGroup(employeeLayout.createSequentialGroup().addComponent(employeeScrollPane)
				.addComponent(employeeControlButtonsPanel));

		employeeLayout.setHorizontalGroup(employeeLayout.createParallelGroup().addComponent(employeeScrollPane)
				.addComponent(employeeControlButtonsPanel));
	}

	public void populateTable() {
		List<EmployeeDTO> employees = employeeDAO.selectAll();

		DefaultTableModel tableModel = (DefaultTableModel) this.employeesTable.getModel();
		tableModel.setRowCount(0);

		for (int i = 0; i < employees.size(); i++) {
			EmployeeDTO employee = employees.get(i);
			Object[] employeeContent = new Object[]{employee.getLastName(), employee.getFirstName(),
					employee.getEmployeeId(), employee.getPassword(), employee.isAdmin()};

			tableModel.addRow(employeeContent);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(employeeAddButton)) {

			if (!popupWindowExists) {
				new PopupWindow(true);
			}
		} else if (e.getSource().equals(employeeUpdateButton)) {
			if (!popupWindowExists) {
				new PopupWindow(false);
			}
		}
	}

	class PopupWindow extends JFrame {
		private static final long serialVersionUID = 1379630163981843824L;

		public PopupWindow(boolean isInsertWindow) {
			popupWindowExists = true;

			String title;

			// ----------------------------------------------------------------------------------------------------
			// -------------------- Fields Panel
			// ----------------------------------------------------------------------------------------------------
			JPanel fieldsPanel = new JPanel();
			fieldsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);

			fieldsPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weighty = 1;
			c.weightx = 1;

			JLabel lastNameLabel = new JLabel("Last name:");
			c.gridx = 0;
			c.gridy = 0;
			fieldsPanel.add(lastNameLabel);

			JLabel firstNameLabel = new JLabel("First name:");
			c.gridx = 0;
			c.gridy = 1;
			fieldsPanel.add(firstNameLabel, c);

			JLabel employeeIdLabel = new JLabel("Employee ID:");
			c.gridx = 0;
			c.gridy = 2;
			fieldsPanel.add(employeeIdLabel, c);

			JLabel passwordLabel = new JLabel("Password");
			c.gridx = 0;
			c.gridy = 3;
			fieldsPanel.add(passwordLabel, c);

			JLabel isAdminLabel = new JLabel("Administrator:");
			c.gridx = 0;
			c.gridy = 4;
			fieldsPanel.add(isAdminLabel, c);

			lastNameTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 0;
			fieldsPanel.add(lastNameTextField, c);

			firstNameTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 1;
			fieldsPanel.add(firstNameTextField, c);

			employeeIdTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 2;
			fieldsPanel.add(employeeIdTextField, c);

			passwordTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 3;
			fieldsPanel.add(passwordTextField, c);

			isAdminTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 4;
			fieldsPanel.add(isAdminTextField, c);

			// ----------------------------------------------------------------------------------------------------
			// -------------------- Button Panel
			// ----------------------------------------------------------------------------------------------------

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
			JButton actionButton = new JButton();
			actionButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);

			if (isInsertWindow) {
				title = "Add Employee";
				actionButton.setText("Add");
				actionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String lastName = lastNameTextField.getText();
						String firstName = firstNameTextField.getText();
						String employeeId = employeeIdTextField.getText();
						String password = passwordTextField.getText();
						String isAdmin = isAdminTextField.getText();

						employeeDAO.insertEmployee(new EmployeeDTO(lastName, firstName, employeeId, password, isAdmin));

						populateTable();
					}
				});
			} else {
				title = "Update Employee";
				actionButton.setText("Update");

				actionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String lastName = lastNameTextField.getText();
						String firstName = firstNameTextField.getText();
						String employeeId = employeeIdTextField.getText();
						String password = passwordTextField.getText();
						String isAdmin = isAdminTextField.getText();

						employeeDAO.updateEmployee(new EmployeeDTO(lastName, firstName, employeeId, password, isAdmin));

						populateTable();
					}
				});

				employeeIdTextField.setEditable(false);
				employeeIdTextField.setFocusable(false);
				employeeIdTextField.setBackground(new Color(224, 224, 224));
			}

			buttonPanel.add(actionButton);

			// ----------------------------------------------------------------------------------------------------
			// -------------------- The Window
			// ----------------------------------------------------------------------------------------------------
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					popupWindowExists = false;
				}
			});

			this.setLayout(new BorderLayout());
			this.add(fieldsPanel, BorderLayout.CENTER);
			this.add(buttonPanel, BorderLayout.SOUTH);
			this.setTitle(title);
			this.setAlwaysOnTop(true);
			this.getContentPane().setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
			this.setSize(350, 400);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		}
	}
}
