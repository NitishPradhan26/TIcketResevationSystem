package User_interface;

import java.awt.*;
import java.awt.event.ActionListener;


import javax.swing.*;

public class Homepage extends JFrame {
	private JLabel title = new JLabel("Ticket Reservation System");
	private JButton cancelTicketButton= new JButton("Cancel Tickets");
	private JButton purchaseTicketButton= new JButton("Purchase Tickets");
	private JButton loginButton = new JButton("Login");
	private JPanel north = new JPanel();
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
		setVisible(true);
		setLayout(new BorderLayout());
		
		//sets background, font and font colour of title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);

		
		//button related operations
		center.setLayout(new BorderLayout());
		center.setBackground(new Color(131,197,190));
		JPanel ticketLayout = new JPanel (new GridLayout());
		cancelTicketButton.setFont(buttonFont);
		cancelTicketButton.setBackground(buttonColor);
		ticketLayout.add(cancelTicketButton);
		purchaseTicketButton.setFont(buttonFont);
		purchaseTicketButton.setBackground(buttonColor);
		ticketLayout.add(purchaseTicketButton);
		center.add("Center", ticketLayout);
		JPanel loginB = new JPanel (new GridLayout());
		loginButton.setFont(buttonFont);
		loginButton.setBackground(buttonColor);
		loginB.add(loginButton);
		center.add("South", loginB);
		add("Center", center);
		
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
	
	
	
	public static void main(String[] args) {
		Homepage h = new Homepage();
	}
}

