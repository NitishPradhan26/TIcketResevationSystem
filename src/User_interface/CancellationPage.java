package User_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CancellationPage extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JButton backButton = new JButton("Back to Homepage");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	
	
	public CancellationPage() {
		super("Cancellation Page");
		setTitle("Cancel Tickets");
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
		
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		south.setBackground(new Color(0,109,119));
		south.add(backButton);
		add("South", south);
		
		
		
	}
	
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}

}
