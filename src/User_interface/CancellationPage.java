package User_interface;

import javax.swing.*;

import Data_control.DataController;
import Data_control.TicketManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationPage extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private JButton backButton = new JButton("Back to Homepage");
	private JLabel enterTicket = new JLabel("Please enter the ticket code:");
	private JTextField enterTicketInput = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	private TicketManagement ticketManager = DataController.dataController().ticketManager;
	
	
	public CancellationPage() {
		super("Cancellation Page");
		setTitle("Cancel Tickets");
		setSize(new Dimension(400,200));
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
		
		Color backgroundColor = new Color(131,197,190);
		center.setBackground(backgroundColor);
		JPanel inputAndButton = new JPanel(new FlowLayout());
		enterTicket.setFont(labelFont);
		enterTicket.setLabelFor(enterTicketInput);
		enterTicketInput.setFont(fieldFont);
		submitButton.setFont(labelFont);
		submitButton.setBackground(buttonColor);
		submitButton.addActionListener(new cancelTicketListener());
		inputAndButton.setBackground(backgroundColor);
		inputAndButton.add(enterTicketInput);
		inputAndButton.add(submitButton);
		
		center.add("North", enterTicket);
		center.add("South", inputAndButton);
		add("Center", center);
		
		
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		south.setBackground(new Color(0,109,119));
		south.add(backButton);
		add("South", south);
		
		
		
	}
	
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public int getTicketID() {
		return Integer.parseInt(enterTicketInput.getText());
	}
	
	public class cancelTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ticketManager.cancelTicket(getTicketID());
			JOptionPane.showMessageDialog(getParent(), "Refund successful. A credit has been added to your account.");
			UIManager instance = UIManager.getUIManager();
			instance.closeCancelPage();
			instance.openHomepage();
		}
	}

}
