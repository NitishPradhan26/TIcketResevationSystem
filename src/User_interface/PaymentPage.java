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

public class PaymentPage extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private JButton backButton = new JButton("Back to Homepage");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	private JLabel bankInfo = new JLabel("Banking Information");
	private JLabel creditCard = new JLabel("Credit Card:");
	private JTextField creditCardInput = new JTextField(15);
	private JLabel creditCardHolder = new JLabel("Name:");
	private JTextField creditCardHolderInput = new JTextField(15);
	private JLabel email = new JLabel("Email:");
	private JTextField emailInput = new JTextField(15);
	private JLabel expiryDate = new JLabel("Expiry:");
	private JTextField expiryDateInput = new JTextField(15);
	private JLabel cvv = new JLabel("CVV");
	private JTextField cvvInput = new JTextField(15);
	private Color centerBackgroundColor = new Color(131,197,190);
	private float balanceDue;
	private JLabel balance;
	private JButton pay = new JButton("Pay now");
	private JButton cancel = new JButton("Cancel");
	private DataController dataControl;
	private TicketManagement ticketManager;
	private ArrayList<String> seats;
	private Showing show;
	
	public PaymentPage(Showing show, ArrayList<String> seats) {
		super("Payment Page");
		setTitle("Payment");
		setSize(new Dimension(400,320));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		dataControl = DataController.dataController();
		ticketManager = DataController.dataController().ticketManager;
		this.show=show;
		this.seats=seats;
		
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
		balance = new JLabel("Balance: $"+df.format(balanceDue));
		balance.setFont(labelFont);
		contentLayout.putConstraint(SpringLayout.WEST, balance, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, balance, 190, SpringLayout.NORTH, this);
		pay.setFont(labelFont);
		pay.setBackground(buttonColor);
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
	
	public void setBalanceDue(float num) {
		this.balanceDue=num;
	}
	
	public void close() {
		this.setVisible(false);
		dispose();
	}
	
	public String getName() {
		return creditCardHolderInput.getText();
	}
	
	public String getEmail() {
		return emailInput.getText();
	}
	
	public class cancelPaymentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int response = JOptionPane.showConfirmDialog(getParent(), "Are you sure you want to cancel?");
			if (response==JOptionPane.YES_OPTION) {
				close();
			}
		}
		
	}
	
	public class paymentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			HashMap<Integer, Character> rowMapping = new HashMap<Integer, Character>();
			char j='A';
			for (int i=0; i<5; i++) {
				rowMapping.put(i, j);
				j++;
			}
			Random rand = new Random();
			User u = new User(getName(), null, null, getEmail(), rand.nextInt(1000)+1000, 0 );
			for (String s: seats) {
				int seat = Integer.parseInt(s);
				int first_index = seat/10;
				int second_index = seat%10;

				CreditCard card = new CreditCard(creditCardInput.getText(), creditCardHolderInput.getText(), expiryDateInput.getText(), Integer.parseInt(cvvInput.getText()));
				ticketManager.purchaseSeat(u, show, rowMapping.get(first_index).toString(), second_index, card);
			}
			JOptionPane.showMessageDialog(getParent(), "Purchase successful!");
		}
		
	}
	
//	public static void main(String[] args) {
//		PaymentPage pay = new PaymentPage();
//		pay.setVisible(true);
//	}
}
