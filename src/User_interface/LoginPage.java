package User_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Data_control.DataController;

public class LoginPage extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private JButton loginButton = new JButton("Login");
	private JLabel username = new JLabel("Username:");
	private JTextField usernameInput = new JTextField(15);
	private JLabel password = new JLabel("Password:");
	private JPasswordField passwordInput = new JPasswordField(15); 
	private JLabel registerUser = new JLabel ("Not a user?");
	private JButton registerButton = new JButton ("Register");
	private JButton backButton = new JButton("Back to Homepage");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	private DataController dataControl;
	
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
		
		SpringLayout contentLayout = new SpringLayout();
		center.setLayout(contentLayout);
		username.setFont(labelFont);
		username.setLabelFor(usernameInput);
		usernameInput.setFont(fieldFont);
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
		contentLayout.putConstraint(SpringLayout.WEST, loginButton, 20, SpringLayout.EAST, username);
		contentLayout.putConstraint(SpringLayout.NORTH, loginButton, 80, SpringLayout.NORTH, this);
		center.setBackground(new Color(131,197,190));
		center.add(username);
		center.add(usernameInput);
		center.add(password);
		center.add(passwordInput);
		center.add(loginButton);
		add("Center", center);
		
		
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
	
	public void addLoginListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	public void addRegisterListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}
	
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public String getUsername() {
		return usernameInput.getText();
	}
	
	public String getPassword() {
		char [] passwordArray = passwordInput.getPassword();
		return passwordArray.toString();
	}
	
	public class loginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (dataControl.loginUser(getUsername(), getPassword())==null){
				JOptionPane.showMessageDialog(getParent(), "Username or password incorrect. Please try again.");
			}
			else {
				UIManager instance = UIManager.getUIManager();
				instance.closeLogin();
				instance.setUsername(getUsername());
				instance.openHomepage();
			}
		}
	}

}
