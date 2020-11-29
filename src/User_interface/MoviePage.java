package User_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data_control.DataController;
import Theatre_elements.Showing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class MoviePage extends JFrame{
	private JLabel title = new JLabel("Ticket Reservation System");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	private JButton backButton = new JButton("Back to Homepage");
	private Font labelFont = new Font("Verdana", Font.BOLD, 18);
	private Font fieldFont = new Font("Verdana", Font.PLAIN, 16);
	private Color buttonColor = new Color(237,246,249);
	private JButton selectMovieButton = new JButton ("Select");
	private JComboBox movieSelection;
	private JButton selectTheatreButton = new JButton ("Select");
	private JComboBox theatreSelection;
	private Color centerBackgroundColor = new Color(131,197,190);
	private Font questionFont = new Font("Verdana", Font.BOLD, 22);
	private SeatSelection seatSelection;
	private DataController dataControl;
	
	
	public MoviePage() {
		super("Cancellation Page");
		setTitle("Cancel Tickets");
		setSize(new Dimension(400,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		dataControl = DataController.dataController();
		
		//sets title
		north.setBackground(new Color(0,109,119));
		north.setForeground(Color.white);
		Font titleFont= new Font("Verdana", Font.BOLD, 24);
		title.setFont(titleFont);
		title.setForeground(Color.white);
		north.add(title);
		add("North",north);
		
		//content
		//sets layout style and background
		
		center.setLayout(new FlowLayout());
		center.setBackground(centerBackgroundColor);
		JPanel moviePanel = new JPanel(new BorderLayout());
		//sets title
		JLabel selectMovie = new JLabel("Please select a movie:");
		selectMovie.setFont(questionFont);
		moviePanel.add("North",selectMovie);
		//adds dropdown menu to select movie
		movieSelection = new JComboBox(getMovies());
		selectMovie.setLabelFor(movieSelection);
		JPanel movieBarAndButton = new JPanel();
		movieBarAndButton.setBackground(centerBackgroundColor);
		movieSelection.setFont(fieldFont);
		movieBarAndButton.add(movieSelection);
		selectMovieButton.setFont(labelFont);
		selectMovieButton.setBackground(buttonColor);
		addSelectMovieListener(new selectMovieListener());
		movieBarAndButton.add(selectMovieButton);
		moviePanel.add("South", movieBarAndButton);
		moviePanel.setBackground(centerBackgroundColor);
		center.add(moviePanel);
		add("Center", center);
		
		
		backButton.setFont(labelFont);
		backButton.setBackground(buttonColor);
		south.setBackground(new Color(0,109,119));
		south.add(backButton);
		add("South", south);
	}
	
	private String[] getMovies() {
		ArrayList<String> movieArray = dataControl.getMovies();
		String[] strings = new String[movieArray.size()];
		return movieArray.toArray(strings);
	}
	
	private String[] getTheatres() {
		ArrayList<String> theatreArray = dataControl.getTheatres();
		String[] strings = new String[theatreArray.size()];
		return theatreArray.toArray(strings);
	}
	
	private ArrayList<Showing> getShowings(String movieName, String theatreName){
		return dataControl.getShowings(movieName, theatreName);
	}
	
	private void displayTheatreOption() {
		
		JPanel theatrePanel = new JPanel(new BorderLayout());
		JLabel theatreQuestion = new JLabel("Please select theatre:");
		theatreQuestion.setFont(questionFont);
		theatrePanel.setBackground(centerBackgroundColor);
		theatrePanel.add("North", theatreQuestion);
		theatreSelection = new JComboBox(getTheatres());
		JPanel theatreBarAndButton = new JPanel(new FlowLayout());
		theatreBarAndButton.setBackground(centerBackgroundColor);
		theatreSelection.setFont(fieldFont);
		selectTheatreButton.setFont(labelFont);
		selectTheatreButton.setBackground(buttonColor);
		selectTheatreButton.addActionListener(new selectTheatreListener());
		theatreBarAndButton.add(theatreSelection);
		theatreBarAndButton.add(selectTheatreButton);
		theatrePanel.add("South", theatreBarAndButton);
		center.add(theatrePanel);
		Container contentPane = getContentPane();
		contentPane.add(center);
		
	}
	
	public void displayShowings() {
		//make request to show showings based on theatre selected

		JPanel showingPanel = new JPanel();
		showingPanel.setPreferredSize(new Dimension(350,300));
		showingPanel.setBackground(centerBackgroundColor);
		JLabel titleShowing = new JLabel("All Showings:");
		titleShowing.setFont(questionFont);
		titleShowing.setHorizontalAlignment(JLabel.CENTER);
	
        JPanel allShowings = new JPanel();
        allShowings.setLayout(new BoxLayout(allShowings, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(allShowings);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 300,300);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(300,300));
        contentPane.add("Center", scrollPane);
        selectShowingListener SListener = new selectShowingListener();
        ArrayList<Showing> showings = getShowings((String)movieSelection.getSelectedItem(), (String)theatreSelection.getSelectedItem());
        Iterator iterator = showings.iterator();
        while (iterator.hasNext()) {
        	JPanel oneShowing = new JPanel();
        	oneShowing.setLayout(new BorderLayout());
    		oneShowing.setBackground(centerBackgroundColor);
    		oneShowing.setBorder(new EmptyBorder(10,10, 10,10 ));
    		Showing show = (Showing) iterator.next();
    		Date showDate = show.getTime();
    		JLabel date = new JLabel(showDate.getMonth()+"/"+showDate.getDate()+"/"+showDate.getYear());
    		date.setFont(labelFont);
    		oneShowing.add("North", date);
    		JPanel showingsForOneDate = new JPanel(new GridLayout(-1,2));
    		showingsForOneDate.setBackground(buttonColor);
    		Date toCompare = showDate;
    		while (toCompare.compareTo(showDate)==0) {
    			String timeString = show.getTime().getHours()+":"+show.getTime().getMinutes();
    			JLabel timeLabel = new JLabel(timeString);
    			JButton time = new JButton (timeString);
    			showings.remove(show);
    			show = (Showing)iterator.next();
    			toCompare = show.getTime();
    			timeLabel.setLabelFor(time);
    			time.addActionListener(SListener);
    			time.setFont(labelFont);
    			time.setBackground(buttonColor);
    			showingsForOneDate.add(time);
    		}
    		oneShowing.add("Center", showingsForOneDate);
    		allShowings.add(oneShowing);
        }
		contentPane.setBackground(centerBackgroundColor);
		contentPane.add("North", titleShowing);
		showingPanel.add(contentPane);
		center.add(showingPanel);
		Container content = getContentPane();
		content.add(center);
		
	}
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	public void addSelectMovieListener(ActionListener listener) {
		selectMovieButton.addActionListener(listener);
	}
	public void refresh() {
		close();
		open();
	}
	
	public void close() {
		setVisible(false);
		dispose();
	}
	
	public void open() {
		setVisible(true);
	}
	
	
	public class selectMovieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			displayTheatreOption();
			refresh();
		}
		
	}
	
	public class selectTheatreListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			displayShowings();
			refresh();
		}
	}
	
	public class selectShowingListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			seatSelection = new SeatSelection((String)movieSelection.getSelectedItem(), (String)button.getText());
			seatSelection.addBackListener(new navigateSeatToMovie());
			close();
			seatSelection.setVisible(true);
			
		}
	}
	
	public class navigateSeatToMovie implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			seatSelection.close();
			open();
		}
	}

}
