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

public class InventoryPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -3718843315216000622L;

	private JButton inventoryUpdateButton = new JButton("Update inventory");
	private JButton inventoryCancelButton = new JButton("Cancel");

	public InventoryPanel() {
		this.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		String[] inventoryColumnNames = {"Flower Type", "Price", "Quantity"};
		Object[][] inventoryContent = new Object[ViewConstants.MAX_ROW_COUNT][3];
		for (int i = 0; i < ViewConstants.MAX_ROW_COUNT; i++) {
			inventoryContent[i] = new Object[]{"", "", ""};
		}
		JTable inventoryTable = new JTable(inventoryContent, inventoryColumnNames);
		JScrollPane inventoryScrollPane = new JScrollPane(inventoryTable);

		FlowLayout inventoryControlButtonsLayout = new FlowLayout();
		inventoryControlButtonsLayout.setAlignment(FlowLayout.CENTER);
		inventoryControlButtonsLayout.setHgap(100);

		inventoryCancelButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		inventoryCancelButton.addActionListener(this);

		inventoryUpdateButton.setBackground(ViewConstants.BACKGROUND_PANEL_COLOR);
		inventoryUpdateButton.addActionListener(this);

		JPanel inventoryControlButtonsPanel = new JPanel();
		inventoryControlButtonsPanel.setBackground(ViewConstants.BACKGROUND_TAB_COLOR);
		inventoryControlButtonsPanel.setLayout(inventoryControlButtonsLayout);
		inventoryControlButtonsPanel.add(inventoryCancelButton);

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

	}
}
