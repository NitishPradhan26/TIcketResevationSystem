package User_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import Data_control.DataController;

/**
 * Home page for application
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class Homepage extends JFrame {
	/**
	 * Title of page
	 */
	private JLabel title = new JLabel("Ticket Reservation System");
	/**
	 * Displays welcome message and username
	 */
	private JLabel subtitle;
	/**
	 * Username of registered user (if user is registered)
	 */
	private String userName;
	/**
	 * If user is registered or has logeed in 
	 */
	private boolean registeredUser = false;
	/**
	 * Determines if user is an administrator
	 */
	private boolean isAdmin = false;
	/**
	 * Redirects user to cancellation page to cancel tickets
	 */
	private JButton cancelTicketButton= new JButton("Cancel Tickets");
	/**
	 * Redirects user to purchase tickets
	 */
	private JButton purchaseTicketButton= new JButton("Purchase Tickets");
	/**
	 * Redirects user to login 
	 */
	private JButton loginButton = new JButton("Login");
	/**
	 * Redirects user to register in system
	 */
	private JButton registerButton = new JButton("Register");
	/**
	 * Redirects user to send news to registered users (only for administrator)
	 */
	private JButton sendNewsButton = new JButton("Send Movie News");
	/**
	 * North panel for frame
	 */
	private JPanel north;
	/**
	 * Center panel for frame
	 */
	private JPanel center;
	/**
	 * Font for buttons
	 */
	private Font buttonFont = new Font("Verdana", Font.BOLD, 18);
	/**
	 * Color for buttons (background)
	 */
	private Color buttonColor = new Color(237,246,249);
	/**
	 * Data controller to access data
	 */
	private DataController dataControl;
	
	/**
	 * Constructs homepage 
	 */
	public Homepage(){
		//window related operations
		super("Homepage");
		setTitle("Ticket Reservation System");
		setSize(new Dimension(400,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		dataControl = DataController.dataController();
		
		//sets background, font and font colour of title
		displayNorthPanel();
		
		//displays buttons depending on type of user
		if (!isAdmin) {
			displayUserButtons();
		}
		else {
			displayAdminButton();
		}
		
		
	}
	
	/**
	 * Helper class to north panel that includes title and welcome message
	 */
	private void displayNorthPanel() {
		if (north!=null) {
			remove(north);
		}
		north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		setRegisteredUserName();
		add("North",north);
		
	}
	
	/**
	 * Helper function to display buttons for user
	 */
	private void displayUserButtons() {
		if (center!=null) {
			remove(center);
		}
		center= new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(new Color(131,197,190));
		JPanel buttonLayout = new JPanel (new GridLayout(0,1));
		cancelTicketButton.setFont(buttonFont);
		cancelTicketButton.setBackground(buttonColor);
		buttonLayout.add(cancelTicketButton);
		purchaseTicketButton.setFont(buttonFont);
		purchaseTicketButton.setBackground(buttonColor);
		buttonLayout.add(purchaseTicketButton);
		loginButton.setFont(buttonFont);
		loginButton.setBackground(buttonColor);
		buttonLayout.add(loginButton);
		registerButton.setFont(buttonFont);
		registerButton.setBackground(buttonColor);
		buttonLayout.add(registerButton);
		add("Center", buttonLayout);
	}
	
	/**
	 * Helper function to display the button for administrator
	 */
	private void displayAdminButton() {
		if (center!=null) {
			remove(center);
		}
		center = new JPanel();
		sendNewsButton.setBackground(buttonColor);
		sendNewsButton.setFont(buttonFont);
		center.add(sendNewsButton);
		add("Center", center);
	}
	
	/**
	 * Helper function to display welcome message depending on type of user
	 */
	private void setRegisteredUserName() {
		if (!registeredUser&&!isAdmin) {
			subtitle = new JLabel("WELCOME UNREGISTERED USER");
		}
		else if(isAdmin&&!registeredUser) {
			subtitle = new JLabel("WELCOME ADMINISTRATOR");
		}
		else {
			subtitle = new JLabel("WELCOME "+userName.toUpperCase());
		}
		subtitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		subtitle.setForeground(Color.white);
		north.add(subtitle);
	}

	/**
	 * Adds listener to purchase ticket button
	 * @param listener: listener to purchase ticket button
	 */
	public void addPurchaseTicketListener(ActionListener listener) {
		purchaseTicketButton.addActionListener(listener);
	}
	
	/**
	 * Adds listener to cancel ticket button
	 * @param listener: listener to cancel ticket button 
	 */
	public void addCancelTicketListener(ActionListener listener) {
		cancelTicketButton.addActionListener(listener);
	}
	
	/**
	 * Adds listener to login button 
	 * @param listener: listener to login button
	 */
	public void addLoginListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	/**
	 * Adds listener to registration button 
	 * @param listener: listener to register button 
	 */
	public void addRegisterListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}
	
	/**
	 * Sets username member
	 * @param username: username of registered user
	 */
	public void setUsername(String username) {
		this.userName = username;
		registeredUser=true;
		displayNorthPanel();
		displayUserButtons();
	}
	
	/**
	 * Returns username of registered user
	 * @return username: String
	 */
	public String getUsername() {
		return userName;
	}
	
	/**
	 * Returns whether or not user is registered in system
	 * @return registeredUser: boolean
	 */
	public boolean getRegisteredUser() {
		return registeredUser;
	}
	
	/**
	 * Sets user to administrator
	 */
	public void setIsAdmin() {
		isAdmin =true;
		registeredUser=false;
		displayNorthPanel();
		displayAdminButton();
	}
	
	/**
	 * Closes homepage
	 */
	public void closeHomepage() {
		setVisible(false);
		dispose();
	}
	
	/**
	 * Listener class, allows administrator to send news to all registered users
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class sendNewsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String message = JOptionPane.showInputDialog("Please enter the news to send to all registered users.");
			dataControl.sendEmailToRegisteredUsers(message);
			JOptionPane.showMessageDialog(getParent(), "Success! Message sent to all registered users.");
		}
		
	}
	
	
}

