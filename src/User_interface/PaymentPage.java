package User_interface;

import javax.swing.*;
import java.awt.*;

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
	private JLabel expiryDate = new JLabel("Expiry:");
	private JTextField expiryDateInput = new JTextField(15);
	private JLabel cvv = new JLabel("CVV");
	private JTextField cvvInput = new JTextField(15);
	private Color centerBackgroundColor = new Color(131,197,190);
	
	public PaymentPage() {
		super("Payment Page");
		setTitle("Payment");
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
		expiryDate.setFont(labelFont);
		expiryDate.setLabelFor(expiryDateInput);
		expiryDateInput.setFont(fieldFont);
		//sets constraints for location of expiry date label and its field 
		contentLayout.putConstraint(SpringLayout.WEST, expiryDate, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDate, 70, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, expiryDateInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, expiryDateInput, 70, SpringLayout.NORTH, this);
		cvv.setFont(labelFont);
		cvv.setLabelFor(cvvInput);
		cvvInput.setFont(fieldFont);
		contentLayout.putConstraint(SpringLayout.WEST, cvv, 7, SpringLayout.WEST, this);
		contentLayout.putConstraint(SpringLayout.NORTH, cvv, 100, SpringLayout.NORTH, this);
		contentLayout.putConstraint(SpringLayout.WEST, cvvInput, 15, SpringLayout.EAST, creditCard);
		contentLayout.putConstraint(SpringLayout.NORTH, cvvInput, 100, SpringLayout.NORTH, this);
		center.add(bankInfo);
		center.add(creditCard);
		center.add(creditCardInput);
		center.add(expiryDate);
		center.add(expiryDateInput);
		center.add(cvv);
		center.add(cvvInput);
		
		add("Center", center);
	}
	
	public static void main(String[] args) {
		PaymentPage pay = new PaymentPage();
		pay.setVisible(true);
	}
}
