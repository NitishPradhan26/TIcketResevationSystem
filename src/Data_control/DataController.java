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
//        dbM = new DatabaseManager("localhost\\SQLEXPRESS02:60490");
//        ticketList = new TicketList(dbM.tickets);
//        users = dbM.users;
//        movieCatalogue = new MovieCatalogue(dbM.movies);
//        theatreCatalogue = new TheatreCatalogue(dbM.theatres);
//        ticketManager = new TicketManagement(this);
//        showings = dbM.showings;
    }

    public ArrayList<String> getMovies(){
//        ArrayList<Movie> movieArray = movieCatalogue.getMovies();
        ArrayList<String> movies = new ArrayList<String>();
//        for (Movie m: movieArray) {
//        	movies.add(m.getName());
//        }
        movies.add("Toy Story");
        movies.add("Toy Story 2");
        return movies;
    }
    public ArrayList<String> getTheatres(){
//        ArrayList<Theatre> theatreArray = theatreCatalogue.getTheatres();
        ArrayList<String> theatres = new ArrayList<String>();
//        for (Theatre t: theatreArray) {
//        	theatres.add(t.getName());
//        }
        theatres.add("Cineplex");
        return theatres;
    }

    public ArrayList<Showing> getShowings(String movieName, String theatreName) {
        ArrayList<Showing> goodShowings = new ArrayList<>();
//        for (Showing s : showings) {
//            if (s.getMovie().getName().equals(movieName) && s.getTheatre().getName().equals(theatreName)) {
//                goodShowings.add(s);
//            }
//        }
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 29, 3, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 29, 4, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 29, 5, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 29, 6, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 29, 7, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 30, 3, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 30, 4, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 11, 31, 3, 00), null, new Theatre("Cineplex", "1234 Address") ));
        goodShowings.add(new Showing(new Movie("Toy Story", 120), new MyDate(2020, 12, 01, 4, 00), null, new Theatre("Cineplex", "1234 Address") ));
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
        users.add(new Registered_user(name, username, password, email, accountNo, 0f, creditCardNo, ccExpiry, ccCVV, address));
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
        dataController().registerUser("Bob", "benis@benis.com", "eee", "benis@benis.com", "877987987", "tomorrow", 100, "somewhere"); //register new user
        User u = dataController().loginUser("bigsina", "assignmentiseasy"); //login a user
        dataController().loginUser("uwu", "uwu"); //fail login
        dataController().ticketManager.purchaseSeat(u, s.get(0), "A", 2); //purchase ticket
        ArrayList<Ticket> t = dataController().ticketManager.getUserTickets(u.getAccountNum()); //get a users tickets
        dataController().ticketManager.cancelTicket(t.get(0).getTicketNo()); //cancel a ticket
    }

}