package User_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Data_control.DataController;
import Theatre_elements.MyDate;
import Theatre_elements.Showing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Displays movies, theatres and their showings
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class MoviePage extends JFrame{
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
	 * Enters movie selection
	 */
	private JButton selectMovieButton = new JButton ("Select");
	/**
	 * List of movies for user to select
	 */
	private JComboBox movieSelection;
	/**
	 * Enters theatre selection
	 */
	private JButton selectTheatreButton = new JButton ("Select");
	/**
	 * List of theatres for user to select
	 */
	private JComboBox theatreSelection;
	/**
	 * Color for background (center of page)
	 */
	private Color centerBackgroundColor = new Color(131,197,190);
	/**
	 * Font for request labels
	 */
	private Font questionFont = new Font("Verdana", Font.BOLD, 22);
	/**
	 * Seat selection page
	 */
	private SeatSelection seatSelection;
	/**
	 * Data controller to access data
	 */
	private DataController dataControl;
	
	
	/**
	 * Constructs the movie page
	 */
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
	
	/**
	 * Returns list of movies from data control
	 * @return movies: String[]
	 */
	private String[] getMovies() {
		ArrayList<String> movieArray = dataControl.getMovies();
		String[] strings = new String[movieArray.size()];
		return movieArray.toArray(strings);
	}
	
	/**
	 * Returns list of theatres from data control
	 * @return theatres: String[]
	 */
	private String[] getTheatres() {
		ArrayList<String> theatreArray = dataControl.getTheatres();
		String[] strings = new String[theatreArray.size()];
		return theatreArray.toArray(strings);
	}
	
	/**
	 * Returns all showings for specified movie and theatre from data control 
	 * @param movieName: specified movie
	 * @param theatreName: specified theatre
	 * @return all showings: ArrayList of Showings
	 */
	private ArrayList<Showing> getShowings(String movieName, String theatreName){
		return dataControl.getShowings(movieName, theatreName);
	}
	
	/**
	 * Helper function to display theatre options
	 */
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
	
	/**
	 * Helper function to display all showings 
	 */
	public void displayShowings() {
		
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
        ArrayList<ArrayList<Showing>> sortedShowings = getShowingsPerDate(showings);
        Iterator iterator = sortedShowings.iterator();
        //displays all showings for each date 
        while (iterator.hasNext()) {
        	JPanel oneShowing = new JPanel();
        	oneShowing.setLayout(new BorderLayout());
    		oneShowing.setBackground(centerBackgroundColor);
    		oneShowing.setBorder(new EmptyBorder(10,10, 10,10 ));
    		ArrayList<Showing> showingOnDate = (ArrayList<Showing>) iterator.next();
    		Iterator showingIterator = showingOnDate.iterator();
    		JLabel date = new JLabel(showingOnDate.get(0).getTime().getDateString());
    		date.setFont(labelFont);
    		oneShowing.add("North", date);
    		JPanel showingsForOneDate = new JPanel(new GridLayout(-1,2));
    		showingsForOneDate.setBackground(buttonColor);
    		while (showingIterator.hasNext()) {
    			Showing show = (Showing) showingIterator.next();
    			JLabel timeLabel = new JLabel(show.getTime().getTimeString());
    			showingButton time = new showingButton (show, show.getTime().getTimeString());
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
	/**
	 * Adds listener for back to homepage button
	 * @param listener: listener for back to homepage button
	 */
	public void addBackListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	/**
	 * Adds listener for select movie button
	 * @param listener: listener for select movie button
	 */
	public void addSelectMovieListener(ActionListener listener) {
		selectMovieButton.addActionListener(listener);
	}
	/**
	 * Refreshes page 
	 */
	public void refresh() {
		close();
		open();
	}
	
	/**
	 * Closes page
	 */
	public void close() {
		setVisible(false);
		dispose();
	}
	
	/**
	 * Opens page
	 */
	public void open() {
		setVisible(true);
	}
	
	/**
	 * Helper function to categorize showings by date
	 * @param allShowings: arraylist of all showings
	 * @return arraylist of arraylist of showings
	 */
	private ArrayList<ArrayList<Showing>> getShowingsPerDate(ArrayList<Showing> allShowings){
		ArrayList<ArrayList<Showing>> showingsPerDate = new ArrayList<ArrayList<Showing>>();
		int index=0;
		int size=allShowings.size();
		boolean found=false;
		while (index<size) {
			Showing show = allShowings.get(index);
			if (showingsPerDate.size()==0) {
				ArrayList<Showing> day = new ArrayList<Showing>();
				day.add(show);
				showingsPerDate.add(day);
				index++;
				continue;
			}
			else {
				for (int i=0; i<showingsPerDate.size();i++) {
					MyDate toCompare = showingsPerDate.get(i).get(0).getTime();
					if (toCompare.compareDates(show.getTime())) {
						showingsPerDate.get(i).add(show);
						found=true;
						break;
					}
				}
				if (!found) {
					ArrayList<Showing> day = new ArrayList<Showing>();
					day.add(show);
					showingsPerDate.add(day);
				}
				index++;
				found=false;
			}
		}
		return showingsPerDate;
	}
	
	
	/**
	 * Listener class, displays theatre
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class selectMovieListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			displayTheatreOption();
			refresh();
		}
		
	}
	
	/**
	 * Listener class, displays showings based on movie and theatre
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class selectTheatreListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			displayShowings();
			refresh();
		}
	}
	
	/**
	 * Listener class, displays seating plan for selected showing 
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class selectShowingListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			showingButton button = (showingButton)e.getSource();
			seatSelection = new SeatSelection((String)movieSelection.getSelectedItem(), (String)button.getShowing().getTime().toString(), button.getShowing().getPlan());
			seatSelection.setShow(button.getShowing());
			seatSelection.addBackListener(new navigateSeatToMovie());
			close();
			seatSelection.setVisible(true);
			
		}
	}
	
	/**
	 * Listener class, navigates from seating page back to movie page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateSeatToMovie implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			seatSelection.close();
			open();
		}
	}

}
