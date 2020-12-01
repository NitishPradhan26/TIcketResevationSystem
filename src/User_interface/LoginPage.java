package User_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Data_control.DataController;
import User.Administrator;
import User.User;

/**
 * Login page
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class LoginPage extends JFrame{
	/**
	 * Title of page
	 */
	private JLabel title = new JLabel("Ticket Reservation System");
	/**
	 * North panel for frame layout
	 */
	private JPanel north = new JPanel();
	/**
	 * Center panel for frame layout
	 */
	private JPanel center = new JPanel();
	/**
	 * South panel for frame layout
	 */
	private JPanel south = new JPanel();
	/**
	 * Login button 
	 */
	private JButton loginButton = new JButton("Login");
	/**
	 * Username label to display on page
	 */
	private JLabel username = new JLabel("Username:");
	/**
	 * Username field for user input
	 */
	private JTextField usernameInput = new JTextField(15);
	/**
	 * Password label to display on page
	 */
	private JLabel password = new JLabel("Password:");
	/**
	 * Password field for user input
	 */
	private JPasswordField passwordInput = new JPasswordField(15); 
	/**
	 * Label to direct users to register if user does not have account
	 */
	private JLabel registerUser = new JLabel ("Not a user?");
	/**
	 * Register button to redirect user to registration page
	 */
	private JButton registerButton = new JButton ("Register");
	/**
	 * Directs user to home page
	 */
	private JButton backButton = new JButton("Back to Homepage");
	/**
	 * Font for labels
	 */
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	/**
	 * Font for text fields
	 */
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	/**
	 * Color for button (background)
	 */
	private Color buttonColor = new Color(237,246,249);
	/**
	 * Data controller to access data 
	 */
	private DataController dataControl;
	
	/**
	 * Constructs the login page
	 */
	public LoginPage() {
		super("Login Page");
		setTitle("Login");
		setSize(new Dimension(400,285));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		dataControl = DataController.dataController();
		
		//sets title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);
		
		//sets layout for login info and input
		SpringLayout contentLayout = new SpringLayout();
		center.setLayout(contentLayout);
		username.setFont(labelFont);
		username.setLabelFor(usernameInput);
		usernameInput.setFont(fieldFont);
		//sets constraints for location of username label and its field
		contentLayout.putConstraint(SpringLayout.WEST, username, 15, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, username, 20, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, usernameInput, 20, SpringLayout.EAST, username);
		contentLayout.putConstraint(SpringLayout.NORTH, usernameInput, 20, SpringLayout.NORTH, this);
		password.setFont(labelFont);
		password.setLabelFor(passwordInput);
		passwordInput.setFont(fieldFont);
		//sets constraints for location of password label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, password, 15, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, password, 50, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, passwordInput, 20, SpringLayout.EAST, username);
		contentLayout.putConstraint(SpringLayout.NORTH, passwordInput, 50, SpringLayout.NORTH, this);
		loginButton.setFont(labelFont);
		loginButton.setBackground(buttonColor);
		loginButton.addActionListener(new loginButtonListener());
		//sets constraints for location of login button 
		contentLayout.putConstraint(SpringLayout.WEST, loginButton, 20, SpringLayout.EAST, username);
		contentLayout.putConstraint(SpringLayout.NORTH, loginButton, 80, SpringLayout.NORTH, this);
		center.setBackground(new Color(131,197,190));
		center.add(username);
		center.add(usernameInput);
		center.add(password);
		center.add(passwordInput);
		center.add(loginButton);
		add("Center", center);
		
		//adds register label and button in south panel 
		south.setLayout(new BorderLayout());
		JPanel registerPanel = new JPanel(new FlowLayout());
		registerPanel.setBackground(new Color(0,109,119));
		registerUser.setForeground(Color.white);;
		registerUser.setFont(labelFont);
		registerButton.setFont(labelFont);
		registerButton.setBackground(buttonColor);
		registerPanel.add(registerUser);
		registerPanel.add(registerButton);
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		south.add("North",registerPanel);
		south.add("South", backButton);
		add("South", south);
		
	}
	
	/**
	 * adds listener to login button
	 * @param listener: listener to login button
	 */
	public void addLoginListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	/**
	 * adds listener to register button
	 * @param listener: listener to register button 
	 */
	public void addRegisterListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}
	
	/**
	 * add listener to back to homepage button
	 * @param listener: listener to back to homepage button
	 */
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	/**
	 * returns username from input field
	 * @return username: String
	 */
	public String getUsername() {
		return usernameInput.getText();
	}
	
	/**
	 * returns password from input field
	 * @return password: String
	 */
	public String getPassword() {
		char [] passwordArray = passwordInput.getPassword();
		return new String(passwordArray);
	}
	
	/**
	 * Listener class, retrieves username and password Input, sends
	 * data to data controller to authentication
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class loginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//retrieves user from data controller using username and password
			User u = dataControl.loginUser(getUsername(), getPassword());
			if (u==null){
				JOptionPane.showMessageDialog(getParent(), "Username or password incorrect. Please try again.");
			}
			else {
				//redirects user to specific page depending on type of user
				UIManager instance = UIManager.getUIManager();
				instance.closeLogin();
				if (u instanceof Administrator) {
					instance.setAdmin();
				}
				else {
					instance.setUsername(getUsername());
				}
				instance.openHomepage();
			}
		}
	}

}
