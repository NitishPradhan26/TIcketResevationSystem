package User_interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import Data_control.DataController;

public class Homepage extends JFrame {
	private JLabel title = new JLabel("Ticket Reservation System");
	private JLabel subtitle;
	private String userName;
	private boolean registeredUser = false;
	private boolean isAdmin = false;
	private JButton cancelTicketButton= new JButton("Cancel Tickets");
	private JButton purchaseTicketButton= new JButton("Purchase Tickets");
	private JButton loginButton = new JButton("Login");
	private JButton registerButton = new JButton("Register");
	private JButton sendNewsButton = new JButton("Send Movie News");
	private JPanel north;
	private JPanel center;
	private Font buttonFont = new Font("Verdana", Font.BOLD, 18);
	private Color buttonColor = new Color(237,246,249);
	private DataController dataControl;
	
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
		
		if (!isAdmin) {
			//button related operations
			displayUserButtons();
		}
		else {
			displayAdminButton();
		}
		
		
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
	
	private void displayAdminButton() {
		if (center!=null) {
			remove(center);
		}
		center = new JPanel();
		sendNewsButton.setBackground(buttonColor);
		sendNewsButton.setFont(buttonFont);
		center.add(sendNewsButton);
	}
	
	private void setRegisteredUserName() {
		if (!registeredUser) {
			subtitle = new JLabel("WELCOME UNREGISTERED USER");
		}
		else if(isAdmin) {
			subtitle = new JLabel("WELCOME ADMINISTRATOR");
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
		displayUserButtons();
	}
	
	public String getUsername() {
		return userName;
	}
	
	public boolean getRegisteredUser() {
		return registeredUser;
	}
	
	public void setIsAdmin() {
		isAdmin =true;
		displayNorthPanel();
		displayAdminButton();
	}
	
	public void closeHomepage() {
		setVisible(false);
		dispose();
	}
	
	public class sendNewsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String message = JOptionPane.showInputDialog("Please enter the news to send to all registered users.");
			dataControl.sendEmailToRegisteredUsers(message);
			JOptionPane.showMessageDialog(getParent(), "Success! Message sent to all registered users.");
		}
		
	}
	
	
}

