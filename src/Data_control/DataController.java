package Data_control;

import Theatre_elements.Movie;
import Theatre_elements.MyDate;
import Theatre_elements.Seat;
import Theatre_elements.Showing;
import Theatre_elements.Theatre;
import Transaction_elements.Ticket;
import User.*;

import java.util.ArrayList;

public class DataController {

    private DatabaseManager dbM;
    private MovieCatalogue movieCatalogue;
    private TheatreCatalogue theatreCatalogue;
    private ArrayList<Showing> showings;
    TicketList ticketList;
    ArrayList<User> users;
    public TicketManagement ticketManager;

    private static DataController dataController;

    private DataController(){
        dbM = new DatabaseManager("localhost\\SQLEXPRESS02:60490");
        ticketList = new TicketList(dbM.tickets);
        users = dbM.users;
        movieCatalogue = new MovieCatalogue(dbM.movies);
        theatreCatalogue = new TheatreCatalogue(dbM.theatres);
        ticketManager = new TicketManagement(this);
        showings = dbM.showings;
    }

    public ArrayList<String> getMovies(){
        ArrayList<Movie> movieArray = movieCatalogue.getMovies();
        ArrayList<String> movies = new ArrayList<String>();
        for (Movie m: movieArray) {
        	movies.add(m.getName());
        }
        return movies;
    }
    public ArrayList<String> getTheatres(){
        ArrayList<Theatre> theatreArray = theatreCatalogue.getTheatres();
        ArrayList<String> theatres = new ArrayList<String>();
        for (Theatre t: theatreArray) {
        	theatres.add(t.getName());
        }
        return theatres;
    }

    public ArrayList<Showing> getShowings(String movieName, String theatreName) {
        ArrayList<Showing> goodShowings = new ArrayList<>();
        for (Showing s : showings) {
            if (s.getMovie().getName().equals(movieName) && s.getTheatre().getName().equals(theatreName)) {
                goodShowings.add(s);
            }
        }
        return goodShowings;
    }
    
    public User getUser(String username) {
    	for (User u:users) {
    		if (u.getUsername().equals(username)) {
    			return u;
    		}
    	}
    	return null;
    }

    public User loginUser(String username, String password){
        for(User u:users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

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

    void storeTicket(Ticket ticket){
        dbM.storeTicket(ticket);
    }

    void cancelTicket(Ticket ticket){
        dbM.cancelTicket(ticket);
    }
    
    public void sendEmailToRegisteredUsers(String message) {
    	System.out.println("Email sent to all registered users");
    }

    public static DataController dataController(){
        if(dataController == null){
            dataController = new DataController();
        }
        return dataController;
    }

    public static void main(String[] args){
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