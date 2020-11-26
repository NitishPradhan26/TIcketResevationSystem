package User_interface;

import java.awt.*;

import javax.swing.*;

public class RegisterForm extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JPanel center = new JPanel();
	private JLabel name = new JLabel("Name:");
	private JTextField nameInput = new JTextField(17);
	private JLabel address = new JLabel("Address:");
	private JTextField addressInput = new JTextField(17);
	private JLabel username = new JLabel("Username:");
	private JTextField usernameInput = new JTextField(17);
	private JLabel password = new JLabel("Password:");
	private JPasswordField passwordInput = new JPasswordField(17); 
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private JButton registerButton = new JButton("Register");
	private JLabel alreadyUser = new JLabel("Already a user?");
	private JButton loginButton = new JButton("Login");
	
	public RegisterForm() {
		super("Registration Page");
		setTitle("Register");
		setSize(new Dimension(400,330));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//sets title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);
		
		//already a user portion
		
		//sets fields
		SpringLayout contentLayout = new SpringLayout();
		center.setLayout(contentLayout);
		name.setFont(labelFont);
		name.setLabelFor(nameInput);
		nameInput.setFont(fieldFont);
		//sets constraints for location of name label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, name, 5, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, name, 20, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, nameInput, 50, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, nameInput, 20, SpringLayout.NORTH, this);
		address.setFont(labelFont);
		address.setLabelFor(addressInput);
		addressInput.setFont(fieldFont);
		//sets constraints for location of address label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, address, 5, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, address, 50, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, addressInput, 50, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, addressInput, 50, SpringLayout.NORTH, this);
		username.setFont(labelFont);
		username.setLabelFor(usernameInput);
		usernameInput.setFont(fieldFont);
		//sets constraints for location of username label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, username, 5, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, username, 80, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, usernameInput, 50, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, usernameInput, 80, SpringLayout.NORTH, this);
		password.setFont(labelFont);
		password.setLabelFor(passwordInput);
		passwordInput.setFont(fieldFont);
		//sets constraints for location of password label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, password, 5, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, password, 110, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, passwordInput, 50, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, passwordInput, 110, SpringLayout.NORTH, this);
		registerButton.setFont(labelFont);
		Color buttonColor = new Color(237,246,249);
		registerButton.setBackground(buttonColor);
		//sets constraints for location of register button
		contentLayout.putConstraint(SpringLayout.WEST, registerButton, 130, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, registerButton, 150, SpringLayout.NORTH, this);
		
		center.setBackground(new Color(131,197,190));
		center.add(name);
		center.add(nameInput);
		center.add(address);
		center.add(addressInput);
		center.add(username);
		center.add(usernameInput);
		center.add(password);
		center.add(passwordInput);
		center.add(registerButton);
		center.add(alreadyUser);
		center.add(loginButton);
		add("Center", center);
		
		south.setBackground(new Color(0,109,119));
		south.setForeground(Color.white);
		alreadyUser.setFont(labelFont);
		alreadyUser.setLabelFor(loginButton);
		alreadyUser.setForeground(Color.white);
		loginButton.setFont(labelFont);
		loginButton.setBackground(buttonColor);
		south.add(alreadyUser);
		south.add(loginButton);
		add("South", south);
	}

}
