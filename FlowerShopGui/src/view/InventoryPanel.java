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

import dao.FlowerDAO;
import dto.FlowerDTO;
import view.NewOrderPanel;

public class InventoryPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -3718843315216000622L;

	private JButton inventoryUpdateButton = new JButton("Update Inventory");
	private JButton inventoryAddButton = new JButton("Add Record");
	private JTable inventoryTable;

	private FlowerDAO flowerDAO = new FlowerDAO();

	private boolean popupWindowExists = false;

	private JTextField flowerTypeTextField;
	private JTextField flowerCostTextField;
	private JTextField flowerQtyTextField;

	public InventoryPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		String[] inventoryColumnNames = {"Flower Type", "Price", "Quantity"};

		TableModel tableModel = new DefaultTableModel(inventoryColumnNames, 0);

		/*
		 * Object[][] inventoryContent = new
		 * Object[ViewConstants.MAX_ROW_COUNT][3]; for (int i = 0; i <
		 * ViewConstants.MAX_ROW_COUNT; i++) { inventoryContent[i] = new
		 * Object[]{"", "", ""}; }
		 */

		inventoryTable = new JTable(tableModel) {
			private static final long serialVersionUID = -3773892189214217159L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		populateTable();

		JScrollPane inventoryScrollPane = new JScrollPane(inventoryTable);

		FlowLayout inventoryControlButtonsLayout = new FlowLayout();
		inventoryControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		inventoryControlButtonsLayout.setHgap(100);

		inventoryAddButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		inventoryAddButton.addActionListener(this);

		inventoryUpdateButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		inventoryUpdateButton.addActionListener(this);

		JPanel inventoryControlButtonsPanel = new JPanel();
		inventoryControlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		inventoryControlButtonsPanel.setLayout(inventoryControlButtonsLayout);
		inventoryControlButtonsPanel.add(inventoryAddButton);

		Component verticalGlue_1 = Box.createVerticalGlue();
		inventoryControlButtonsPanel.add(verticalGlue_1);
		inventoryControlButtonsPanel.add(inventoryUpdateButton);

		GroupLayout inventoryPanelLayout = new GroupLayout(this);
		this.setLayout(inventoryPanelLayout);
		inventoryPanelLayout.setAutoCreateGaps(true);
		inventoryPanelLayout.setAutoCreateContainerGaps(true);

		inventoryPanelLayout.setHorizontalGroup(inventoryPanelLayout.createParallelGroup()
				.addComponent(inventoryScrollPane).addComponent(inventoryControlButtonsPanel));

		inventoryPanelLayout.setVerticalGroup(inventoryPanelLayout.createSequentialGroup()
				.addComponent(inventoryScrollPane).addComponent(inventoryControlButtonsPanel));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(inventoryAddButton)) {
			if (!popupWindowExists) {
				MainWindow.getTabbedPane().setEnabled(false);

				new PopupWindow(true);
			}
		} else if (e.getSource().equals(inventoryUpdateButton)) {
			if (!popupWindowExists) {

				if (inventoryTable.getSelectedRow() > -1) {
					MainWindow.getTabbedPane().setEnabled(false);

					new PopupWindow(false);

					int selectedRow = inventoryTable.getSelectedRow();

					flowerTypeTextField.setText((String) inventoryTable.getValueAt(selectedRow, 0));
					flowerCostTextField.setText((String) String.valueOf(inventoryTable.getValueAt(selectedRow, 1)));
					flowerQtyTextField.setText((String) String.valueOf(inventoryTable.getValueAt(selectedRow, 2)));

					flowerTypeTextField.setEditable(false);
					flowerTypeTextField.setFocusable(false);
					flowerTypeTextField.setBackground(new Color(224, 224, 224));
				} else {
					JOptionPane.showMessageDialog(null, "Please select a row");
				}
			}
		}
	}

	class PopupWindow extends JFrame implements ActionListener {
		private static final long serialVersionUID = -1987360885661467194L;

		private String title;
		private boolean isInsertWindow;
		private JButton actionButton;

		public PopupWindow(boolean isInsertWindow) {

			this.isInsertWindow = isInsertWindow;

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

			JLabel flowerTypeLabel = new JLabel("Flower Type:");
			c.gridx = 0;
			c.gridy = 0;
			fieldsPanel.add(flowerTypeLabel);

			JLabel flowerCostLabel = new JLabel("Price:");
			c.gridx = 0;
			c.gridy = 1;
			fieldsPanel.add(flowerCostLabel, c);

			JLabel flowerQtyLabel = new JLabel("Quantity:");
			c.gridx = 0;
			c.gridy = 2;
			fieldsPanel.add(flowerQtyLabel, c);

			flowerTypeTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 0;
			fieldsPanel.add(flowerTypeTextField, c);

			flowerCostTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 1;
			fieldsPanel.add(flowerCostTextField, c);

			flowerQtyTextField = new JTextField(15);
			c.gridx = 1;
			c.gridy = 2;
			fieldsPanel.add(flowerQtyTextField, c);

			// ----------------------------------------------------------------------------------------------------
			// -------------------- Button Panel
			// ----------------------------------------------------------------------------------------------------

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
			actionButton = new JButton();
			actionButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);

			actionButton.addActionListener(this);

			if (isInsertWindow) {
				title = "Add Inventory Record";
				actionButton.setText("Add");
			} else {
				title = "Update Inventory";
				actionButton.setText("Update");
			}

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
			this.setSize(350, 400);
			this.setResizable(false);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		}

		public void actionPerformed(ActionEvent e) {
			if (isInsertWindow) {
				String flowerType = flowerTypeTextField.getText();
				double flowerCost = Double.valueOf(flowerCostTextField.getText());
				int flowerQty = Integer.valueOf(flowerQtyTextField.getText());

				flowerDAO.insertFlower(new FlowerDTO(flowerType, flowerCost, flowerQty));

				NewOrderPanel.populateFlowerTypeComboBox();
				populateTable();

				MainWindow.getTabbedPane().setEnabled(true);
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			} else {
				String flowerType = flowerTypeTextField.getText();
				double flowerCost = Double.valueOf(flowerCostTextField.getText());
				int flowerQty = Integer.valueOf(flowerQtyTextField.getText());

				flowerDAO.updateFlower(new FlowerDTO(flowerType, flowerCost, flowerQty));
				
				NewOrderPanel.populateFlowerTypeComboBox();

				populateTable();

				MainWindow.getTabbedPane().setEnabled(true);
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
	}

	public void populateTable() {
		List<FlowerDTO> flowers = flowerDAO.selectAll();

		DefaultTableModel tableModel = (DefaultTableModel) this.inventoryTable.getModel();
		tableModel.setRowCount(0);

		for (int i = 0; i < flowers.size(); i++) {
			FlowerDTO flower = flowers.get(i);
			Object[] employeeContent = new Object[]{flower.getFlowerType(), flower.getFlowerCost(),
					flower.getFlowerQty()};

			tableModel.addRow(employeeContent);
		}
	}
}