package User_interface;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class RegisterForm extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel south = new JPanel(new BorderLayout());
	private JPanel center = new JPanel();
	private JLabel name = new JLabel("Name:");
	private JTextField nameInput = new JTextField(15);
	private JLabel address = new JLabel("Address:");
	private JTextField addressInput = new JTextField(15);
	private JLabel city = new JLabel("City:");
	private JTextField cityInput = new JTextField(15);
	private JLabel province = new JLabel("Province:");
	private JComboBox provinceInput;
	private JLabel postalcode = new JLabel("Postal Code:");
	private JTextField postalcodeInput = new JTextField(15);
	private JLabel email = new JLabel("Email:");
	private JTextField emailInput = new JTextField(15);
	private JLabel username = new JLabel("Username:");
	private JTextField usernameInput = new JTextField(15);
	private JLabel password = new JLabel("Password:");
	private JPasswordField passwordInput = new JPasswordField(15); 
	private JLabel bankInfo = new JLabel("Banking Information");
	private JLabel debitCard = new JLabel("Debit/");
	private JLabel creditCard = new JLabel("Credit Card:");
	private JTextField creditCardInput = new JTextField(15);
	private JLabel expiryDate = new JLabel("Expiry:");
	private JTextField expiryDateInput = new JTextField(15);
	private JLabel cvv = new JLabel("CVV");
	private JTextField cvvInput = new JTextField(15);
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private JButton registerButton = new JButton("Register");
	private JLabel alreadyUser = new JLabel("Already a user?");
	private JButton loginButton = new JButton("Login");
	private JButton backButton = new JButton("Back To Homepage");
	
	public RegisterForm() {
		super("Registration Page");
		setTitle("Register");
		setSize(new Dimension(400,600));
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
		contentLayout.putConstraint(SpringLayout.WEST, name, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, name, 20, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, nameInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, nameInput, 20, SpringLayout.NORTH, this);
		address.setFont(labelFont);
		address.setLabelFor(addressInput);
		addressInput.setFont(fieldFont);
		//sets constraints for location of address label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, address, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, address, 50, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, addressInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, addressInput, 50, SpringLayout.NORTH, this);
		city.setFont(labelFont);
		city.setLabelFor(cityInput);
		cityInput.setFont(fieldFont);
		//sets constraints for location of city label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, city, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, city, 80, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, cityInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, cityInput, 80, SpringLayout.NORTH, this);
		String [] provinces = {"BC", "AB", "SK", "MB", "ON", "QC", "NL", "NS", "NB", "PEI", "NU", "NWT", "YK"};
		provinceInput = new JComboBox(provinces);
		province.setFont(labelFont);
		province.setLabelFor(provinceInput);
		provinceInput.setFont(fieldFont);
		//sets constraints for location of province label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, province, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, province, 110, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, provinceInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, provinceInput, 107, SpringLayout.NORTH, this);
		postalcode.setFont(labelFont);
		postalcode.setLabelFor(postalcodeInput);
		postalcodeInput.setFont(fieldFont);
		//sets constraints for location of postal code label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, postalcode, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, postalcode, 140, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, postalcodeInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, postalcodeInput, 140, SpringLayout.NORTH, this);
		email.setFont(labelFont);
		email.setLabelFor(emailInput);
		emailInput.setFont(fieldFont);
		addListenerToEmail();
		//sets constraints for location of email label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, email, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, email, 170, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, emailInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, emailInput, 170, SpringLayout.NORTH, this);
		username.setFont(labelFont);
		username.setLabelFor(usernameInput);
		usernameInput.setFont(fieldFont);
		//sets constraints for location of username label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, username, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, username, 200, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, usernameInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, usernameInput, 200, SpringLayout.NORTH, this);
		password.setFont(labelFont);
		password.setLabelFor(passwordInput);
		passwordInput.setFont(fieldFont);
		//sets constraints for location of password label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, password, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, password, 230, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, passwordInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, passwordInput, 230, SpringLayout.NORTH, this);
		bankInfo.setFont(labelFont);
		contentLayout.putConstraint(SpringLayout.WEST, bankInfo, 85, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, bankInfo, 255, SpringLayout.NORTH, this);
		debitCard.setFont(labelFont);
		debitCard.setLabelFor(creditCardInput);
		contentLayout.putConstraint(SpringLayout.WEST, debitCard, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, debitCard, 275, SpringLayout.NORTH, this);
		creditCard.setFont(labelFont);
		creditCard.setLabelFor(creditCardInput);
		creditCardInput.setFont(fieldFont);
		//sets constraints for location of password label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, creditCard, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCard, 295, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, creditCardInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCardInput, 295, SpringLayout.NORTH, this);
		expiryDate.setFont(labelFont);
		expiryDate.setLabelFor(expiryDateInput);
		expiryDateInput.setFont(fieldFont);
		//sets constraints for location of expiry date label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, expiryDate, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDate, 325, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, expiryDateInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDateInput, 325, SpringLayout.NORTH, this);
		cvv.setFont(labelFont);
		cvv.setLabelFor(cvvInput);
		cvvInput.setFont(fieldFont);
		contentLayout.putConstraint(SpringLayout.WEST, cvv, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, cvv, 355, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, cvvInput, 75, SpringLayout.EAST, name);
		contentLayout.putConstraint(SpringLayout.NORTH, cvvInput, 355, SpringLayout.NORTH, this);
		registerButton.setFont(labelFont);
		Color buttonColor = new Color(237,246,249);
		registerButton.setBackground(buttonColor);
		//sets constraints for location of register button
		contentLayout.putConstraint(SpringLayout.WEST, registerButton, 130, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, registerButton, 400, SpringLayout.NORTH, this);
		
		center.setBackground(new Color(131,197,190));
		center.add(name);
		center.add(nameInput);
		center.add(address);
		center.add(addressInput);
		center.add(city);
		center.add(cityInput);
		center.add(province);
		center.add(provinceInput);
		center.add(postalcode);
		center.add(postalcodeInput);
		center.add(email);
		center.add(emailInput);
		center.add(username);
		center.add(usernameInput);
		center.add(password);
		center.add(passwordInput);
		center.add(bankInfo);
		center.add(debitCard);
		center.add(creditCard);
		center.add(creditCardInput);
		center.add(expiryDate);
		center.add(expiryDateInput);
		center.add(cvv);
		center.add(cvvInput);
		center.add(registerButton);
		center.add(alreadyUser);
		center.add(loginButton);
		add("Center", center);
		
		south.setBackground(new Color(0,109,119));
		south.setForeground(Color.white);
		JPanel alreadyUserPanel = new JPanel(new FlowLayout());
		alreadyUserPanel.setBackground(new Color(0,109,119));
		alreadyUser.setFont(labelFont);
		alreadyUser.setLabelFor(loginButton);
		alreadyUser.setForeground(Color.white);
		loginButton.setFont(labelFont);
		loginButton.setBackground(buttonColor);
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		alreadyUserPanel.add(alreadyUser);
		alreadyUserPanel.add(loginButton);
		south.add("North", alreadyUserPanel);
		south.add("South", backButton);
		add("South", south);
	}
	
	private void addListenerToEmail() {
		emailInput.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				setUsername();
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				setUsername();				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				setUsername();				
			}
			
		});		
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
	
//	public void getUserInfo() {
//		//puts all info in user object
//	}
	
	
	
	public void setUsername() {
		usernameInput.setText(getStringFromTextBox(emailInput));
	}
	
	public String getStringFromTextBox(JTextField field) {
		return field.getText();
	}

}
