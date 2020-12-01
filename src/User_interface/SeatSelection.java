package User_interface;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data_control.DataController;
import Data_control.TicketManagement;
import Theatre_elements.Seat;
import Theatre_elements.SeatingPlan;
import Theatre_elements.Showing;
import User.*;
import User_interface.UIManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Seat selection page for users to select seats
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class SeatSelection extends JFrame{
	/**
	 * Selected movie
	 */
	private String movie;
	/**
	 * Selected showing
	 */
	private String showing;
	/**
	 * Selected show
	 */
	private Showing show;
	/**
	 * Seating plan
	 */
	private SeatingPlan seats;
	/**
	 * Array that represents seating plan
	 */
	private int[][] seatArray;
	/**
	 * Stores seats selected by user
	 */
	private ArrayList<Integer> userSelectedSeats = new ArrayList<Integer>();
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
	 * Panel to store seats 
	 */
	private JPanel seatPanel;
	/**
	 * Navigates back to movie page
	 */
	private JButton backButton = new JButton("Back");
	/**
	 * Proceeds to complete transaction
	 */
	private JButton selectSeatButton = new JButton("Select Seats");
	/**
	 * Font for labels and buttons
	 */
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	/**
	 * Font for text field
	 */
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	/**
	 * Color for buttons
	 */
	private Color buttonColor = new Color(237,246,249);
	/**
	 * Color for seat when it is selected by user
	 */
	private Color selectedSeatColor = new Color(153, 218, 240);
	/**
	 * Color for background
	 */
	private Color centerBackgroundColor = new Color(131,197,190);
	/**
	 * Color for seat when it is taken already
	 */
	private Color takenSeatColor = new Color(111, 171, 191);
	
	/**
	 * Constructs seat selection page
	 * @param movie: selected movie
	 * @param showing: selected showing
	 * @param seats: seating plan for showing
	 */
	public SeatSelection(String movie, String showing, SeatingPlan seats) {
		super("Seat Selection");
		setTitle("Seat Selection");
		setSize(new Dimension(400,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		this.movie=movie;
		this.showing=showing;
		
		//sets title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);
		
		center.setLayout(new BorderLayout());
		center.setBackground(centerBackgroundColor);
		JPanel info = new JPanel();
		info.setBackground(centerBackgroundColor);
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		JLabel movieLabel = new JLabel("Movie: "+movie);
		movieLabel.setFont(labelFont);
		info.add(movieLabel);
		JLabel showingLabel = new JLabel("Showing: "+showing);
		showingLabel.setFont(labelFont);
		info.add(showingLabel);
		center.add("North", info);
		this.seats = seats;
		seatArray = this.seats.getTakenSeats();
		displaySeats();
		center.add("Center", seatPanel);
		selectSeatButton.setBackground(buttonColor);
		selectSeatButton.setFont(labelFont);
		selectSeatButton.addActionListener(new confirmSeatListener());
		center.add("South", selectSeatButton);
		add("Center", center);
		
		
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		south.setBackground(new Color(0,109,119));
		south.add(backButton);
		add("South", south);
	}
	
	/**
	 * displays seats onto page
	 */
	public void displaySeats(){
		seatPanel = new JPanel(new GridLayout(5,5));
		seatPanel.setBorder(new EmptyBorder(20,20,20,20));
		seatPanel.setBackground(centerBackgroundColor);
		selectSeatListener ssl = new selectSeatListener();
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				JButton seat = new JButton(Integer.toString(i)+Integer.toString(j));
				seat.addActionListener(ssl);
				if (seats.isTaken(i-1,j-1)) {
					seat.setBackground(takenSeatColor);
				}
				else {
					seat.setBackground(buttonColor);
				}
				seat.setFont(labelFont);
				seatPanel.add(seat);
			}
		}
		
	}
	

	
	/**
	 * adds listener to back button
	 * @param listener
	 */
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	/**
	 * closes page
	 */
	public void close() {
		setVisible(false);
		dispose();
	}
	
	/**
	 * sets showing
	 * @param show
	 */
	public void setShow(Showing show) {
		this.show=show;
	}
	
	/**
	 * sets seating plan
	 * @param seatPlan
	 */
	public void setSeats(SeatingPlan seatPlan) {
		this.seats=seatPlan;
	}
	
	/**
	 * Listener class, records seats selected by user, removes seats when deselected
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class selectSeatListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton tempButton = (JButton)e.getSource();
			int seatNum = Integer.parseInt(tempButton.getText());
			int taken = seatArray[seatNum/10-1][seatNum%10-1];
			if (taken==1) {
				JOptionPane.showMessageDialog(getParent(), "Seat already taken. Please select another.");
			}
			else if(taken==0) {
				seatArray[seatNum/10-1][seatNum%10-1]=-1;
				userSelectedSeats.add(seatNum);
				tempButton.setBackground(selectedSeatColor);
			}
			else {
				seatArray[seatNum/10-1][seatNum%10-1]=0;
				userSelectedSeats.remove(userSelectedSeats.indexOf(seatNum));
				tempButton.setBackground(buttonColor);
			}
			
		}
	}
	
	
	/**
	 * Listener class, processes seat selection and payment 
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class confirmSeatListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//confirms seat selection from user
			String message = "You have selected seats:";
			for (Integer s: userSelectedSeats) {
				message+= " "+s;
			}
			message+=". Please confirm your seat selection.";
			int value = JOptionPane.showConfirmDialog(getParent(), message);
			if (value==JOptionPane.YES_OPTION) {
				UIManager manager = UIManager.getUIManager();
				//processes payment if user is already logged in
				if (manager.registeredUser()) {
					DataController dc = DataController.dataController();
					TicketManagement tm = dc.ticketManager;
					User u = dc.getUser(manager.getUsername());
					if (u==null) {
						JOptionPane.showMessageDialog(getParent(), "Account not found. Transaction cancelled.");
						close();
					}
					else {
						for (Integer s: userSelectedSeats) {
							int first_index = s/10-1;
							int second_index = s%10-1;
							tm.purchaseSeat(u, show, first_index, second_index, ((Registered_user) u).getCreditCard());
						}
						JOptionPane.showMessageDialog(getParent(), "Purchase successful! Your tickets and receipt have been sent to your email.");
						System.out.println("Purchase successful. Tickets and receipt have been sent to user's email");
						close();
						manager.openHomepage();
						
					}
				}
				else {
					float balance = (float) ((float)userSelectedSeats.size()*10.0);
					int response = JOptionPane.showConfirmDialog(getParent(), "Are you a registered user?");
					if (response==JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(getParent(), "Please navigate to the homepage and login using your name and password, and try again.");
					}
					//proceeds to payment page if user is not registered
					else if (response==JOptionPane.NO_OPTION){
						PaymentPage payment = new PaymentPage(show, userSelectedSeats, balance);
						payment.setVisible(true);
						close();
					}
				}
			}
			//closes page if user cancels
			if (value==JOptionPane.CANCEL_OPTION) {
				close();
			}
		}
	}
}
