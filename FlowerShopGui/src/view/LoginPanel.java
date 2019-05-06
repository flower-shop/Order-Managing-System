package view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.ConnectionFactory;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

//add Nimbus theme

public class LoginPanel implements ActionListener {
	JTextField inputTxt, inputTxtl;
	JTextField inputTxt2;
	JTextField passwordTxt, passwordTxtl;
	JTextField passwordTxt2;
        String introText, inTxt1, inTxt2, inTxtl, passTxt, passTxt2, passTxtl, infoText;
        boolean check;
        
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
                //window.getContentPane().setBackground(Color.GREEN);
                JLabel background = setBackground(window, "flowers.jpg");
		// Create Panels
		JPanel mainPanel = new JPanel();
		JPanel logInPanel = new JPanel();
		JPanel userName = new JPanel();
		JPanel password = new JPanel();
                JPanel buffer1 = new JPanel();
                JPanel buffer2 = new JPanel();

		JPanel instructionPanel = new JPanel();
		logInPanel.setBorder(BorderFactory.createTitledBorder("Log In Credentials"));
		logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));
                buffer1.setOpaque(false);
                buffer2.setOpaque(false);

		// Create Components
		JLabel adminUserLabel = new JLabel("   Admin User Name");
                adminUserLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		inputTxt = new JTextField(null, 20);
		JLabel adminUserLabel2 = new JLabel("Re-Enter User Name");
                adminUserLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		inputTxt2 = new JTextField(null, 20);
		JLabel passwordLabel = new JLabel("     Enter Password");
                passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordTxt = new JPasswordField(null, 20);
                passwordTxt.setEditable(false);
		JLabel passwordLabel2 = new JLabel("Re-Enter Password");
                passwordLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordTxt2 = new JPasswordField(null, 20);
                passwordTxt2.setEditable(false);
		JButton enterBttn = new JButton("Confirm User Name");
                JButton passwordBttn = new JButton("Confirm Password");
                enterBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
                passwordBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		// Username Data entry validation
		// password match validation
		//
		
                introText = "Welcome to your new \nFlower Shop\nManagement Program!\n" +
                "Simply enter your \nchosen username \nand password below.";
                JTextArea instructionText = new JTextArea(5,15);
                instructionText.append(introText);
                instructionText.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
                instructionText.setEditable(false);
                instructionText.setLineWrap(true);
                instructionText.setWrapStyleWord(true);

                
                Color color = new Color(230,255,200);
                instructionText.setBackground(color);
                inputTxt.setBackground(color);
                inputTxt2.setBackground(color);
                passwordTxt.setBackground(color);
                passwordTxt2.setBackground(color);

		// Add components to panels
		// needs reorganised for proper GUI set up
		// second username applied or username validation optionpane check
		userName.setLayout(new FlowLayout());
		userName.add(adminUserLabel);
		userName.add(inputTxt);
                userName.add(adminUserLabel2);
		userName.add(inputTxt2);
                userName.add(buffer1);
		userName.add(enterBttn);
                userName.setOpaque(false);

		// second password info to be added
		password.setLayout(new FlowLayout());
		password.add(passwordLabel);
		password.add(passwordTxt);
                password.add(passwordLabel2);
		password.add(passwordTxt2);
                password.add(buffer1);
                password.add(passwordBttn);
                password.setOpaque(false);
                password.setVisible(false);

		instructionPanel.add(instructionText);
                instructionPanel.setOpaque(false);

		logInPanel.add(userName);
                logInPanel.add(password);

                logInPanel.setOpaque(false);


		// insert panells to Window
		// Add all panels to main panel

		mainPanel.setLayout(new GridLayout(2,2));
                mainPanel.add(buffer1);
                mainPanel.add(instructionPanel);
                mainPanel.add(buffer2);
		mainPanel.add(logInPanel);
                mainPanel.setOpaque(false);
                background.add(mainPanel);
		// Add main panel to main window
		window.add(background);

		// Window set up and specifications
		// Set window to close on acceptance of valid username and passwords
		// go to employee entry section
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		window.setSize(800, 600);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
                
                // Actionlisteners for Buttons
                enterBttn.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String inTxt1 = inputTxt.getText();
                        String inTxt2 = inputTxt2.getText();
                        check = inTxt1.equalsIgnoreCase(inTxt2);
                        if((inTxt1.length()<1)||(inTxt2.length() < 1)){
                            introText = "You Must enter a User Name.";
                            instructionText.setText(null);
                            instructionText.append(introText);
                        }
                        else if (check == true){
                            inputTxt.setEditable(false);
                            inputTxt2.setEditable(false);
                            passwordTxt.setEditable(true);
                            passwordTxt2.setEditable(true);
                            password.setVisible(true);
                            instructionText.setText(null);
                            instructionText.append("Please enter a Password that is at least 8 characters in length.");
                        }
                        else if (check == false){
                            introText = "Your User Names do not Match.";
                            instructionText.setText(null);
                            instructionText.append(introText);       
                        }
                    }
            });
                passwordBttn.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String passTxt1 = passwordTxt.getText();
                        String passTxt2 = passwordTxt2.getText();
                        check = passTxt1.equalsIgnoreCase(passTxt2);
                        if((passTxt1.length()<8)||(passTxt2.length() < 8)){
                            introText = "Your password is not at least 8 characters in length.";
                            instructionText.setText(null);
                            instructionText.append(introText);
                        }
                        else if (check == true){
//need code here to store inTxt2 and passTxt2 into db as admin level user
                            window.setVisible(false);
                            mainWindow();
                        }
                        else if (check == false){
                            introText = "Your Passwords do not Match.";
                            instructionText.setText(null);
                            instructionText.append(introText);       
                        }
                    }
            });
    }

	private void mainWindow() {
		// Create Main window
		JFrame window = new JFrame("Flower Shop Management Program");
                //window.getContentPane().setBackground(Color.GREEN);
                JLabel background = setBackground(window, "flowers2.jpg");
		// Create Panels
		JPanel mainPanel = new JPanel();
		JPanel logInPanel = new JPanel();
                JPanel buffer1 = new JPanel();
                JPanel buffer2 = new JPanel();
                JPanel buffer3 = new JPanel();
                JPanel buffer4 = new JPanel();
                JPanel buffer5 = new JPanel();
                JPanel instructionPanel = new JPanel();
		logInPanel.setBorder(BorderFactory.createTitledBorder("Log In Credentials"));
                buffer1.setOpaque(false);
                buffer2.setOpaque(false);
                buffer3.setOpaque(false);
                buffer4.setOpaque(false);
                buffer5.setOpaque(false);

		// Create Components
		JLabel userLabel = new JLabel("Enter User Name");
                userLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		inputTxtl = new JTextField(null, 20);
		JLabel passwordLabel = new JLabel("   Enter Password");
                passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordTxtl = new JPasswordField(null, 20);
                JButton passwordBttn = new JButton("Log In");
                passwordBttn.setFont(new Font("Times New Roman", Font.BOLD, 14));
                
                JTextArea instructionText = new JTextArea(5,15);
                infoText = "";
                instructionText.append(infoText);
                instructionText.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
                instructionText.setEditable(false);
                instructionText.setLineWrap(true);
                instructionText.setWrapStyleWord(true);

                Color color = new Color(230,255,200);
                instructionText.setBackground(color);
                inputTxtl.setBackground(color);
                passwordTxtl.setBackground(color);

		// Add components to panels
                
                
		logInPanel.setLayout(new FlowLayout());

                logInPanel.add(userLabel);
                logInPanel.add(inputTxtl);
		logInPanel.add(passwordLabel);
		logInPanel.add(passwordTxtl);

                logInPanel.add(buffer1);
                logInPanel.add(passwordBttn);
                logInPanel.setOpaque(false);

		instructionPanel.add(instructionText);
                instructionPanel.setOpaque(false);
                instructionPanel.setVisible(false);

		// insert panells to Window
		// Add all panels to main panel

		mainPanel.setLayout(new GridLayout(3,2));
                mainPanel.add(buffer1);
                mainPanel.add(instructionPanel);
                mainPanel.add(buffer3);
                mainPanel.add(buffer4);
                mainPanel.add(buffer5);
		mainPanel.add(logInPanel);
                mainPanel.setOpaque(false);
                background.add(mainPanel);
		// Add main panel to main window
		window.add(background);

		// Window set up and specifications
		// Set window to close on acceptance of valid username and passwords
		// go to employee entry section
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		window.setSize(800, 600);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);

		// Actionlisteners for Buttons
                passwordBttn.addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e){
                        String inTxtl = inputTxtl.getText();
                        String passTxtl = passwordTxtl.getText();
// need code to check db for matching user and password

                        if((inTxtl.length()<1)||(passTxtl.length() < 1)){
                            infoText = "You must enter a User Name and Passowrd";
                            instructionText.setText(null);
                            instructionText.append(infoText);
                            instructionPanel.setVisible(true);
                        }
//else if (check == true){
//                          window.setVisible(false);
// open main program
//                        }
//else if (check == false){
//                           infoText = "Your User Name and/or password are incorrect";
//                          instructionText.setText(null);
//                          instructionText.append(infoText);
//                          instructionPanel.setVisible(true);
//                      }
                    }
            });
	}
        
        public static JLabel setBackground(JFrame frame, String backgroundFilePath) {  
           frame.setLayout(new BorderLayout());  
           JLabel background=new JLabel(new ImageIcon(backgroundFilePath));  
           frame.add(background);  
           background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
           return background;  
      }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	/**
	 * @param args
	 *            the command line arguments
	 */
/*	public static void main(String[] args) {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            } catch (Exception e) {
            }
            LoginPanel begin = new LoginPanel();
            begin.adminCheck();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
*/ }
