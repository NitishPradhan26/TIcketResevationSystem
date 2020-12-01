package User_interface;

import javax.swing.*;

import Data_control.DataController;
import Data_control.TicketManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cancel ticket page
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class CancellationPage extends JFrame{
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
	 * Enter ticket label to prompt user to enter ticket code (for cancellation)
	 */
	private JLabel enterTicket = new JLabel("Please enter the ticket code:");
	/**
	 * Field for user to enter ticket code (for cancellation)
	 */
	private JTextField enterTicketInput = new JTextField(15);
	/**
	 * Submit information to data controller
	 */
	private JButton submitButton = new JButton("Submit");
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
	 * Manages ticket cancellation
	 */
	private TicketManagement ticketManager = DataController.dataController().ticketManager;
	
	
	/**
	 * Constructs cancellation page
	 */
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
	
	/**
	 * Adds listener to back button
	 * @param listener: listener for back button
	 */
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	/**
	 * Gets user input
	 * @return: ticket id: int
	 */
	public int getTicketID() {
		return Integer.parseInt(enterTicketInput.getText());
	}
	
	/**
	 * Sends user input to ticket manager to cancel ticket
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class cancelTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(ticketManager.cancelTicket(getTicketID())){
				JOptionPane.showMessageDialog(getParent(), "Refund successful. A credit has been added to your account.");
				UIManager instance = UIManager.getUIManager();
				instance.closeCancelPage();
				instance.openHomepage();
			}
			else {
				JOptionPane.showMessageDialog(getParent(), "Refund unsuccessful. Please enter a valid ticket ID.");
			}
		}
	}

}
