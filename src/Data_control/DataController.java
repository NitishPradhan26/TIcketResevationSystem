package Data_control;

import Theatre_elements.Movie;
import Theatre_elements.Showing;
import Theatre_elements.Theatre;
import Transaction_elements.Ticket;
import User.*;

import java.util.ArrayList;

/**
 * Data controller class controlling and managing access to data within the ticket reservation system.
 * Uses singleton design pattern, accessed publicly by calling dataController().
 * @author Alex Price
 */
public class DataController {

    private DatabaseManager dbM;
    private MovieCatalogue movieCatalogue;
    private TheatreCatalogue theatreCatalogue;
    private ArrayList<Showing> showings;
    TicketList ticketList;
    ArrayList<User> users;
    public TicketManagement ticketManager;

    private static DataController dataController;

    /**
     * Private constructor for the DataController, constructing a DatabaseManager and associated TicketManagement and Catalogues.
     */
    private DataController(){
        dbM = new DatabaseManager("localhost\\SQLEXPRESS02:60490");
        ticketList = new TicketList(dbM.tickets);
        users = dbM.users;
        movieCatalogue = new MovieCatalogue(dbM.movies);
        theatreCatalogue = new TheatreCatalogue(dbM.theatres);
        ticketManager = new TicketManagement(this);
        showings = dbM.showings;
    }

    /**
     * Gets a list of movie names that are in the database.
     * @return list of movie names
     */
    public ArrayList<String> getMovies(){
        ArrayList<Movie> movieArray = movieCatalogue.getMovies();
        ArrayList<String> movies = new ArrayList<String>();
        for (Movie m: movieArray) {
        	movies.add(m.getName());
        }
        return movies;
    }

    /**
     * Get a list of Movie theatres that are in the database.
     * @return list of theatre names
     */
    public ArrayList<String> getTheatres(){
        ArrayList<Theatre> theatreArray = theatreCatalogue.getTheatres();
        ArrayList<String> theatres = new ArrayList<String>();
        for (Theatre t: theatreArray) {
        	theatres.add(t.getName());
        }
        return theatres;
    }

    /**
     * Get a list of Showings for the given movie name and theatre name.
     * @param movieName name of the movie
     * @param theatreName name of the theatre
     * @return list of showings
     */
    public ArrayList<Showing> getShowings(String movieName, String theatreName) {
        ArrayList<Showing> goodShowings = new ArrayList<>();
        for (Showing s : showings) {
            if (s.getMovie().getName().equals(movieName) && s.getTheatre().getName().equals(theatreName)) {
                goodShowings.add(s);
            }
        }
        return goodShowings;
    }

    /**
     * Gets a user by their username.
     * @param username username of the user
     * @return the associated user, if any
     */
    public User getUser(String username) {
    	for (User u:users) {
    		if (u.getUsername().equals(username)) {
    			return u;
    		}
    	}
    	return null;
    }

    /**
     * Logs in a user to a database.
     * @param username username of the user
     * @param password password of the user
     * @return the associated user, if any
     */
    public User loginUser(String username, String password){
        for(User u:users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    /**
     * Adds a new Registered_user to the database.
     * @param name name of the user
     * @param username username of the user
     * @param password password of the user
     * @param email email address of the user
     * @param creditCardNo credit card number of the user
     * @param ccExpiry credit card expiry date of the user
     * @param ccCVV credit card CVV of the user
     * @param address address of the user
     */
    public void registerUser(String name, String username, String password, String email, String creditCardNo, String ccExpiry, int ccCVV, String address) {
        int accountNo;
        User user = null;
        do {
            user = null;
            accountNo = (int) (Math.random() * 10000d);
            for (User u : users) {
                if (u.getAccountNum() == accountNo) {
                    user = u;
                }
            }
        } while (user != null);
        Registered_user u = new Registered_user(name, username, password, email, accountNo, 0f, creditCardNo, ccExpiry, ccCVV, address);
        users.add(u);
        dbM.addUser(u);
    }

    /**
     * Inserts a ticket into the database.
    * @param ticket ticket to be inserted
     */
    void storeTicket(Ticket ticket){
        dbM.storeTicket(ticket);
    }

    /**
     * Cancels a ticket in the database.
     * @param ticket ticket to be canceled
     */
    void cancelTicket(Ticket ticket){
        dbM.cancelTicket(ticket);
    }

    /**
     * Sends an email with news to all users.
     * @param message email message to be sent
     */
    public void sendEmailToRegisteredUsers(String message) {
    	System.out.println("Email sent to all registered users");
    }

    /**
     * Returns the singleton instance of the DataController
     * @return the DataController
     */
    public static DataController dataController(){
        if(dataController == null){
            dataController = new DataController();
        }
        return dataController;
    }

    public static void main(String[] args){
        //Test main function to test DataController functionality
        dataController().getMovies(); //get all movies as arraylist
        dataController().getTheatres(); //get all theatres as arraylist
        ArrayList<Showing> s = dataController().getShowings("Kung Fu Hustle", "Theatre"); //get all showings for given movie and theatre
        //dataController().registerUser("Bob", "benis@benis.com", "eee", "benis@benis.com", "877987987", "tomorrow", 100, "somewhere"); //register new user
        Registered_user u = (Registered_user)dataController().loginUser("twentyyears", "teaching"); //login a user
        dataController().loginUser("uwu", "uwu"); //fail login
        dataController().ticketManager.purchaseSeat(u, s.get(0), 1, 2, u.getCreditCard()); //purchase ticket
        ArrayList<Ticket> t = dataController().ticketManager.getUserTickets(u.getAccountNum()); //get a users tickets
        dataController().ticketManager.cancelTicket(t.get(0).getTicketNo()); //cancel a ticket
    }

}