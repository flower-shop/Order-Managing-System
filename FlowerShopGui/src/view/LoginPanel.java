package view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.ConnectionFactory;

//add Nimbus theme

public class LoginPanel {
	JTextField inputTxt;
	JTextField inputTxt2;
	JTextField passwordText;
	JTextArea imageArea;
	JTextField passwordText2;

	private void adminCheck() {

		/*
		 * check the db to see if Employee table contains entries. if yes then
		 * go to mainWindow(), if no then go to setUpAccount()
		 */
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM Employee ";
			ResultSet rs = stmt.executeQuery(query);

			if (rs == null) {

			}

			if (rs.next() == false) {
				setUpAccount();

			} else {
				mainWindow();
			}
		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	private void setUpAccount() {

		// Create Main window
		JFrame window = new JFrame("Flower Shop Management Program");

		// Create Panels
		JPanel mainPanel = new JPanel();
		JPanel logInPanel = new JPanel();
		JPanel userName = new JPanel();
		JPanel password = new JPanel();
		JPanel image = new JPanel();
		logInPanel.setBorder(BorderFactory.createTitledBorder("Log In Credentials"));
		logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));

		// Create Components
		JLabel adminUserLabel = new JLabel("Admin User Name");
		inputTxt = new JTextField(null, 20);
		JLabel adminUserLabel2 = new JLabel("Admin User Name");
		inputTxt2 = new JTextField(null, 20);
		JLabel passwordLabel = new JLabel("Password");
		passwordText = new JTextField(null, 20);
		JLabel passwordLabel2 = new JLabel("Password");
		passwordText2 = new JTextField(null, 20);
		JButton enterBttn = new JButton("Enter");
		// Username Data entry validation
		// password match validation
		//
		imageArea = new JTextArea(10, 44);

		// Add components to panels
		// needs reorganised for proper GUI set up
		// second username applied or username validation optionpane check
		userName.setLayout(new FlowLayout(3, 8, 2));
		userName.add(adminUserLabel);
		userName.add(inputTxt);
		userName.add(enterBttn);

		// second password info to be added
		password.setLayout(new FlowLayout(3, 20, 2));
		password.add(passwordLabel);
		password.add(passwordText);

		image.add(imageArea);
		image.setPreferredSize(new Dimension(500, 200));

		logInPanel.add(password);
		logInPanel.add(userName);

		// insert panells to Window
		// Add all panels to main panel

		mainPanel.add(image);
		mainPanel.add(logInPanel);
		// Add main panel to main window
		window.add(mainPanel);
		// Window set up and specifications
		// Set window to close on acceptance of valid username and passwords
		// go to employee entry section
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(640, 480);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
	}

	private void mainWindow() {
		// Create Main window
		JFrame window = new JFrame("Flower Shop Management Program");

		// Create Panels
		JPanel mainPanel = new JPanel();
		JPanel logInPanel = new JPanel();
		JPanel userName = new JPanel();
		JPanel password = new JPanel();
		JPanel image = new JPanel();
		logInPanel.setBorder(BorderFactory.createTitledBorder("Log In Credentials"));
		logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));

		// Create Components
		JLabel userNameLabel = new JLabel("User Name");
		inputTxt = new JTextField(null, 20);
		JLabel passwordLabel = new JLabel("Password");
		passwordText = new JTextField(null, 20);
		JButton enterBttn = new JButton("Enter");
		imageArea = new JTextArea(10, 44);

		// need code here to check validation of entries with db
		// if successful go to FlowerShopGui

		// Add components to panels
		userName.setLayout(new FlowLayout(3, 8, 2));
		userName.add(userNameLabel);
		userName.add(inputTxt);
		userName.add(enterBttn);

		password.setLayout(new FlowLayout(3, 20, 2));
		password.add(passwordLabel);
		password.add(passwordText);

		image.add(imageArea);
		image.setPreferredSize(new Dimension(500, 200));

		logInPanel.add(password);
		logInPanel.add(userName);

		// insert panells to Window
		// Add all panels to main panel

		mainPanel.add(image);
		mainPanel.add(logInPanel);
		// Add main panel to main window
		window.add(mainPanel);
		// Window set up and specifications
		// set window to close on accepted information
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(640, 480);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);

		// Actionlisteners for Buttons

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		LoginPanel begin = new LoginPanel();
		// begin.userCheck();
	}
}
