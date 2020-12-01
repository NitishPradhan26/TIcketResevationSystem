package Data_control;

import Theatre_elements.*;
import Transaction_elements.Payment;
import Transaction_elements.Ticket;
import User.Administrator;
import User.Registered_user;
import User.User;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Database manager class to handle reading and writing to the theatre database.
 * @author Alex Price
 */
public class DatabaseManager {

    private Connection connection;
    ArrayList<User> users;
    ArrayList<Movie> movies;
    ArrayList<Theatre> theatres;
    ArrayList<Showing> showings;
    ArrayList<Ticket> tickets;

    /**
     * Constructs a DatabaseManager and loads all data from the database into memory.
     * @param db url to connect to the database with
     */
    public DatabaseManager (String db){
        String connectionUrl =
                "jdbc:sqlserver://" + db + ";"
                        + "database=ensf480;"
                        + "user=ENSF480;"
                        + "password=ENSF480;"
                        + "loginTimeout=10;";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        loadUsers();
        loadMovies();
        loadTheatres();
        loadShowings();
    }

    /**
     * Helper function to create a Statement and query the database.
     * @param query query to perform
     * @return result of the query
     */
    private ResultSet queryDB(String query){
        try {
            Statement statement = connection.createStatement();
            return  statement.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper function to create a Statement and update the database.
     * @param query update to perform on the database
     */
    private void updateDB(String query){
        try{
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println("Changed "+result+" row(s) in the database.");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads all users from the database and stores them in variable users.
     */
    private void loadUsers(){
        users = new ArrayList<>();
        ResultSet userSet = queryDB("SELECT Name, Username, Password, Email, AccountNum, Credit, CreditCardNumber, Address, RegisteredUser, Administrator FROM users");
        try {
            while (userSet.next()) {
                if(userSet.getInt(9) == 1){
                    users.add(new Registered_user(userSet.getString(1), userSet.getString(2),
                            userSet.getString(3), userSet.getString(4), userSet.getInt(5),
                            userSet.getFloat(6), userSet.getString(7), "", 0, userSet.getString(8)));
                }
                else if (userSet.getInt(10) == 1){
                    users.add(new Administrator(userSet.getString(1), userSet.getString(2),
                            userSet.getString(3), userSet.getString(4), userSet.getInt(5),
                            userSet.getFloat(6)));
                }
                else {
                    users.add(new User(userSet.getString(1), userSet.getString(2),
                            userSet.getString(3), userSet.getString(4), userSet.getInt(5),
                            userSet.getFloat(6)));
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads all movies from the database and stores them in variable movies.
     */
    private void loadMovies(){
        movies = new ArrayList<>();
        ResultSet movieSet = queryDB("SELECT Name, Length FROM movie");
        try {
            while (movieSet.next()) {
                movies.add(new Movie(movieSet.getString(1), movieSet.getInt(2)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads all theatres from the database and stores them in variable theatres.
     */
    private void loadTheatres(){
        theatres = new ArrayList<>();
        ResultSet theatreSet = queryDB("SELECT Name, Address FROM theatre");
        try {
            while (theatreSet.next()) {
                theatres.add(new Theatre(theatreSet.getString(1), theatreSet.getString(2)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads all showings from the database with tickets and seats properly constructed and stores them into variables tickets and showings.
     */
    private void loadShowings(){
        showings = new ArrayList<>();
        tickets = new ArrayList<>();
        ResultSet showingSet = queryDB("SELECT MovieName, TheatreName, ShowTime FROM showing");
        try {
            while (showingSet.next()) {
                String movieName = showingSet.getString(1);
                String theatreName = showingSet.getString(2);
                String showingTime = showingSet.getString(3);
                DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy h:mma");
                java.util.Date date = dateFormat.parse(showingTime);
                Showing showing = new Showing(findMovie(movieName), findTheatre(theatreName), new MyDate(date));
                SeatingPlan plan = new SeatingPlan(loadSeats(movieName, theatreName, showingTime, showing));
                showing.setPlan(plan);
                showings.add(showing);
            }
        }
        catch (SQLException | ParseException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the taken seats from the database for the given showing.
     * @param movie movie name
     * @param theatre threatre name
     * @param time string representing the date and time of the showing
     * @param showing showing reference to fill generated Tickets with
     * @return list of all seats in the given showing
     */
    private ArrayList<Seat> loadSeats(String movie, String theatre, String time, Showing showing){
        ArrayList<Seat> seats = new ArrayList<>();
        ResultSet seatSet = queryDB("SELECT Row, Col, TicketNo FROM seat WHERE MovieName='" + movie + "' AND TheatreName='" + theatre + "' AND ShowTime='" + time + "'");
        try {
            while (seatSet.next()) {
                Seat seat = new Seat(seatSet.getString(1).charAt(0) - 'A' + 1, Integer.parseInt(seatSet.getString(2)));
                seat.setPurchaser(loadTicket(seatSet.getInt(3), seat, showing));
                seats.add(seat);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return seats;
    }

    /**
     * Loads the Ticket associated with the given ticketNo.
     * @param ticketNo ticket number to load
     * @param seat seat to generate Ticket with
     * @param showing showing to generate Ticket with
     * @return generated Ticket
     */
    private Ticket loadTicket(int ticketNo, Seat seat, Showing showing){
        ResultSet set = queryDB("SELECT UserAccnt, Price, Cancelled FROM ticket WHERE TicketNo='" + ticketNo + "'");
        try{
            set.next();
            Ticket ticket = new Ticket(ticketNo, seat, findUser(set.getInt(1)), showing, set.getFloat(2), set.getBoolean(3), new Payment());
            tickets.add(ticket);
            return ticket;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Finds a movie with a matching name.
     * @param name name of the movie to search for
     * @return the found Movie, if any
     */
    private Movie findMovie(String name){
        for(Movie m:movies){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    /**
     * Finds a theatre with a matching name.
     * @param name name of the theatre to search for
     * @return the found Theatre, if any
     */
    private Theatre findTheatre(String name){
        for(Theatre t:theatres){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }

    /**
     * Finds the user with the matching account number, if any
     * @param accountNum account number of user
     * @return the found User, if any
     */
    private User findUser(int accountNum){
        if(accountNum == 0){
            return null;
        }
        for(User u:users){
            if(u.getAccountNum() == accountNum){
                return u;
            }
        }
        return null;
    }

    /**
     * Inserts the given Registered User into the database.
     * @param u user to insert
     */
    public void addUser(Registered_user u){
        updateDB(String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', %d, 0, '%s', '%s', 1, null)",
                u.getName(), u.getUsername(), u.getPassword(), u.getEmail(), u.getAccountNum(), u.getCreditCard().getCCNum(), u.getAddress()));
    }

    /**
     * Inserts the given Ticket into the database.
     * @param ticket ticket to insert
     */
    public void storeTicket(Ticket ticket){
        try {
            char row =  (char)(ticket.getSeat().getRow() + 'A');
            SimpleDateFormat dbFormat = new SimpleDateFormat("MMMM d, yyyy h:mma"), myDateFormat = new SimpleDateFormat("M/d/yyyy H:m");
            String dateTime = dbFormat.format(myDateFormat.parse(ticket.getShowing().getTime().toString()));
            updateDB(String.format("INSERT INTO seat VALUES ('%s', 'Theatre', '%c', %d, %d, '%s')",
                    ticket.getShowing().getMovie().getName(), row, ticket.getSeat().getSeatNo()+1, ticket.getTicketNo(), dateTime));
            int userNum = ticket.getUser().getAccountNum();
            if(ticket.getUser().getUsername() == null){
                userNum = 0;
            }
            updateDB(String.format("INSERT INTO ticket VALUES ('%s', 'Theatre', '%c', %d, %d, %d, null, '%s', '%.2f')",
                    ticket.getShowing().getMovie().getName(), row, ticket.getSeat().getSeatNo()+1, ticket.getTicketNo(), userNum, dateTime, ticket.getPrice()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cancels a Ticket within the database, removing the seat entry and setting the ticket as 'cancelled'.
     * @param ticket ticket to cancel
     */
    public void cancelTicket(Ticket ticket){
        updateDB("DELETE FROM seat WHERE TicketNo='" + ticket.getTicketNo()+"'");
        updateDB("UPDATE ticket SET Cancelled=1 WHERE TicketNo='"+ticket.getTicketNo()+"'");
    }
}
