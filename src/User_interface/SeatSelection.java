package User_interface;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatSelection extends JFrame{
	private String movie;
	private String showing;
	private int [][] seats = new int [5][5];
	private ArrayList<String> userSelectedSeats = new ArrayList<String>();
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private JPanel seatPanel;
	private JButton backButton = new JButton("Back");
	private JButton selectSeatButton = new JButton("Select Seats");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	private Color selectedSeatColor = new Color(153, 218, 240);
	private Color centerBackgroundColor = new Color(131,197,190);
	private Color takenSeatColor = new Color(111, 171, 191);
	private final int TAKEN_SEAT = 1;
	private final int EMPTY_SEAT = 0;
	private final int SELECTED_SEAT = -1;
	
	public SeatSelection(String movie, String showing) {
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
		setSeatAvailability();
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
	
	public void displaySeats(){
		seatPanel = new JPanel(new GridLayout(5,5));
		seatPanel.setBorder(new EmptyBorder(20,20,20,20));
		seatPanel.setBackground(centerBackgroundColor);
		selectSeatListener ssl = new selectSeatListener();
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				JButton seat = new JButton(Integer.toString(i)+Integer.toString(j));
				seat.addActionListener(ssl);
				if (seats[i-1][j-1]==TAKEN_SEAT) {
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
	
	
	public void setSeatAvailability() {
		//make request to database 
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i==0) {
					seats[i][j]=TAKEN_SEAT;
				}
				else {
					seats[i][j]=EMPTY_SEAT;
				}
				
			}
		}
	}
	
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public void close() {
		setVisible(false);
		dispose();
	}
	
	public class selectSeatListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton tempButton = (JButton)e.getSource();
			int seatNum = Integer.parseInt(tempButton.getText());
			int firstIndex = (seatNum/10)-1;
			int secondIndex = (seatNum%10)-1;
			if (seats[firstIndex][secondIndex]==SELECTED_SEAT) {
				userSelectedSeats.remove(tempButton.getText());
				tempButton.setBackground(buttonColor);
				seats[firstIndex][secondIndex]=EMPTY_SEAT;
			}
			else if (seats[firstIndex][secondIndex]==EMPTY_SEAT) {
				userSelectedSeats.add(tempButton.getText());
				tempButton.setBackground(selectedSeatColor);
				seats[firstIndex][secondIndex]=SELECTED_SEAT;
			}
			else {
				JOptionPane.showMessageDialog(getParent(), "Seat already taken. Please select another.");
			}
			
		}
	}
	
	
	public class confirmSeatListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String message = "You have selected seats:";
			for (String s: userSelectedSeats) {
				message+= " "+s;
			}
			message+=". Please confirm your seat selection.";
			int value = JOptionPane.showConfirmDialog(getParent(), message);
			if (value==JOptionPane.YES_OPTION) {
				//send seat selection to database, get payment info 
				PaymentPage payment = new PaymentPage();
				float value1 = (float) ((float)userSelectedSeats.size()*10.0);
				payment.setBalanceDue(value1);
				payment.setVisible(true);
				close();
			}
		}
	}
}
