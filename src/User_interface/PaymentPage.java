package User_interface;

import javax.swing.*;

import Data_control.DataController;
import Data_control.TicketManagement;
import Theatre_elements.Showing;
import Transaction_elements.CreditCard;
import User.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Payment page for user to input payment information
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class PaymentPage extends JFrame{
	/**
	 * Title of page
	 */
	private JLabel title = new JLabel("Ticket Reservation System");
	/**
	 * North panel of frame
	 */
	private JPanel north = new JPanel();
	/**
	 * Center panel of frame
	 */
	private JPanel center = new JPanel();
	/**
	 * South panel of frame
	 */
	private JPanel south = new JPanel();
	/**
	 * Redirects user to homepage
	 */
	private JButton backButton = new JButton("Back to Homepage");
	/**
	 * Font for labels and buttons
	 */
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	/**
	 * Font for text fields
	 */
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	/**
	 * Color for buttons (background)
	 */
	private Color buttonColor = new Color(237,246,249);
	/**
	 * Label for user to enter payment information
	 */
	private JLabel bankInfo = new JLabel("Payment Information");
	/**
	 * Label for user to enter credit card
	 */
	private JLabel creditCard = new JLabel("Credit Card:");
	/**
	 * Field for user to input credit card number
	 */
	private JTextField creditCardInput = new JTextField(15);
	/**
	 * Label for user to enter name
	 */
	private JLabel creditCardHolder = new JLabel("Name:");
	/**
	 * Field for user to input name
	 */
	private JTextField creditCardHolderInput = new JTextField(15);
	/**
	 * Label for user to enter email address
	 */
	private JLabel email = new JLabel("Email:");
	/**
	 * Text field for user to enter email address
	 */
	private JTextField emailInput = new JTextField(15);
	/**
	 * Label for user to enter expiry date for credit card
	 */
	private JLabel expiryDate = new JLabel("Expiry:");
	/**
	 * Text field for user to enter expiry date
	 */
	private JTextField expiryDateInput = new JTextField(15);
	/**
	 * Label for user to enter credit card's CVV
	 */
	private JLabel cvv = new JLabel("CVV");
	/**
	 * Text field for user to enter credit card's CVV
	 */
	private JTextField cvvInput = new JTextField(15);
	/**
	 * Background color
	 */
	private Color centerBackgroundColor = new Color(131,197,190);
	/**
	 * Balance due 
	 */
	private float balanceDue;
	/**
	 * Label to display balance
	 */
	private JLabel balance;
	/**
	 * Sends payment information to process transaction
	 */
	private JButton pay = new JButton("Pay now");
	/**
	 * Cancels transaction
	 */
	private JButton cancel = new JButton("Cancel");
	/**
	 * Data controller to access data
	 */
	private DataController dataControl;
	/**
	 * Ticket manager to process ticket purchase
	 */
	private TicketManagement ticketManager;
	/**
	 * Seats bought by user
	 */
	private ArrayList<Integer> seats;
	/**
	 * Showing for tickets purchased
	 */
	private Showing show;
	
	/**
	 * Constructs payment page
	 * @param show: showing for tickets
	 * @param userSelectedSeats: seats user selected
	 * @param balance1: total due
	 */
	public PaymentPage(Showing show, ArrayList<Integer> userSelectedSeats, float balance1) {
		super("Payment Page");
		setTitle("Payment");
		setSize(new Dimension(400,320));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		dataControl = DataController.dataController();
		ticketManager = DataController.dataController().ticketManager;
		this.show=show;
		this.seats=userSelectedSeats;
		this.balanceDue=balance1;
		
		//sets title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);
		setPaymentInfo();
		

	}
	
	/**
	 * Helper function to set payment info on screen
	 */
	private void setPaymentInfo() {
		SpringLayout contentLayout = new SpringLayout();
		center.setLayout(contentLayout);
		center.setBackground(centerBackgroundColor);
		bankInfo.setFont(labelFont);
		contentLayout.putConstraint(SpringLayout.WEST, bankInfo, 85, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, bankInfo, 10, SpringLayout.NORTH, this);
		creditCard.setFont(labelFont);
		creditCard.setLabelFor(creditCardInput);
		creditCardInput.setFont(fieldFont);
		//sets constraints for location of password label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, creditCard, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCard, 40, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, creditCardInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCardInput, 40, SpringLayout.NORTH, this);
		creditCardHolder.setFont(labelFont);
		creditCardHolder.setLabelFor(creditCardHolderInput);
		creditCardHolderInput.setFont(fieldFont);
		//sets constraints for location of expiry date label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, creditCardHolder, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCardHolder, 70, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, creditCardHolderInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, creditCardHolderInput, 70, SpringLayout.NORTH, this);
		email.setFont(labelFont);
		email.setLabelFor(emailInput);
		emailInput.setFont(fieldFont);
		contentLayout.putConstraint(SpringLayout.WEST, email, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, email, 100, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, emailInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, emailInput, 100, SpringLayout.NORTH, this);
		expiryDate.setFont(labelFont);
		expiryDate.setLabelFor(expiryDateInput);
		expiryDateInput.setFont(fieldFont);
		//sets constraints for location of expiry date label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, expiryDate, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDate, 130, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, expiryDateInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDateInput, 130, SpringLayout.NORTH, this);
		cvv.setFont(labelFont);
		cvv.setLabelFor(cvvInput);
		cvvInput.setFont(fieldFont);
		contentLayout.putConstraint(SpringLayout.WEST, cvv, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, cvv, 160, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, cvvInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, cvvInput, 160, SpringLayout.NORTH, this);
		
		DecimalFormat df = new DecimalFormat("##.##");
		balance = new JLabel("Total due: $"+df.format(balanceDue));
		balance.setFont(labelFont);
		contentLayout.putConstraint(SpringLayout.WEST, balance, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, balance, 190, SpringLayout.NORTH, this);
		pay.setFont(labelFont);
		pay.setBackground(buttonColor);
		pay.addActionListener(new paymentListener());
		contentLayout.putConstraint(SpringLayout.WEST, pay, 70, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, pay, 210, SpringLayout.NORTH, this);
		cancel.setFont(labelFont);
		cancel.setBackground(buttonColor);
		cancel.addActionListener(new cancelPaymentListener());
		contentLayout.putConstraint(SpringLayout.WEST, cancel, 210, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, cancel, 210, SpringLayout.NORTH, this);
		center.add(bankInfo);
		center.add(creditCard);
		center.add(creditCardInput);
		center.add(creditCardHolder);
		center.add(creditCardHolderInput);
		center.add(email);
		center.add(emailInput);
		center.add(expiryDate);
		center.add(expiryDateInput);
		center.add(cvv);
		center.add(cvvInput);
		center.add(balance);
		center.add(pay);
		center.add(cancel);
		
		add("Center", center);
	}
	
	/**
	 * Sets total due
	 * @param num: total due
	 */
	public void setBalanceDue(float num) {
		this.balanceDue=num;
	}
	
	/**
	 * Closes page
	 */
	public void close() {
		this.setVisible(false);
		dispose();
	}
	
	/**
	 * Gets name from input field
	 */
	public String getName() {
		return creditCardHolderInput.getText();
	}
	
	/**
	 * Gets email address from input field
	 * @return email: String
	 */
	public String getEmail() {
		return emailInput.getText();
	}
	
	/**
	 * Listener class, closes page if user cancels payment
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class cancelPaymentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int response = JOptionPane.showConfirmDialog(getParent(), "Are you sure you want to cancel?");
			if (response==JOptionPane.YES_OPTION) {
				close();
			}
		}
		
	}
	
	/**
	 * Listener class, processes payment 
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class paymentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			User u = new User(getName(), null, null, getEmail(), rand.nextInt(1000)+1000, 0 );
			CreditCard card = new CreditCard(creditCardInput.getText(), creditCardHolderInput.getText(), expiryDateInput.getText(), Integer.parseInt(cvvInput.getText()));
			for (Integer s: seats) {
				int first_index = s/10;
				int second_index = s%10;

				
				ticketManager.purchaseSeat(u, show, first_index-1, second_index-1, card);
			}
			JOptionPane.showMessageDialog(getParent(), "Purchase successful! Your tickets and receipt have been sent to your email.");
			System.out.println("Purchase successful. Tickets and receipt have been sent to user's email");
			close();
			UIManager.getUIManager().openHomepage();
			
		}
		
	}

}
