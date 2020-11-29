package User_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Homepage extends JFrame {
	private JLabel title = new JLabel("Ticket Reservation System");
	private JLabel subtitle;
	private String userName;
	private boolean registeredUser = false;
	private JButton cancelTicketButton= new JButton("Cancel Tickets");
	private JButton purchaseTicketButton= new JButton("Purchase Tickets");
	private JButton loginButton = new JButton("Login");
	private JButton registerButton = new JButton("Register");
	private JPanel north;
	private JPanel center = new JPanel();
	private Font buttonFont = new Font("Verdana", Font.BOLD, 18);
	private Color buttonColor = new Color(237,246,249);
	
	public Homepage(){
		//window related operations
		super("Homepage");
		setTitle("Ticket Reservation System");
		setSize(new Dimension(400,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		//sets background, font and font colour of title
		displayNorthPanel();

		
		//button related operations
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
	
	private void setRegisteredUserName() {
		if (!registeredUser) {
			subtitle = new JLabel("WELCOME UNREGISTERED USER");
		}
		else {
			subtitle = new JLabel("WELCOME "+userName.toUpperCase());
		}
		subtitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		subtitle.setForeground(Color.white);
		north.add(subtitle);
	}

	public void addPurchaseTicketListener(ActionListener listener) {
		purchaseTicketButton.addActionListener(listener);
	}
	
	public void addCancelTicketListener(ActionListener listener) {
		cancelTicketButton.addActionListener(listener);
	}
	
	public void addLoginListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	public void addRegisterListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}
	
	public void setUsername(String username) {
		this.userName = username;
		registeredUser=true;
		displayNorthPanel();
	}
	
	public String getUsername() {
		return userName;
	}
	
	public boolean getRegisteredUser() {
		return registeredUser;
	}
	
	public void closeHomepage() {
		setVisible(false);
		dispose();
	}
	
	
}

