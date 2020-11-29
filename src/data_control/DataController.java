package Data_control;

import Theatre_elements.Movie;
import Theatre_elements.Showing;
import Theatre_elements.Theatre;
import User.User;

import java.util.ArrayList;

public class DataController {

    private DatabaseManager dbM;
    private MovieCatalogue movieCatalogue;
    private TheatreCatalogue theatreCatalogue;
    private ArrayList<Showing> showings;
    TicketList ticketList;
    private ArrayList<User> users;
    public TicketManagement ticketManager;

    public DataController(){
        dbM = new DatabaseManager("localhost\\SQLEXPRESS02:60490");
        ticketList = new TicketList(dbM.tickets);
        users = dbM.users;
        movieCatalogue = new MovieCatalogue(dbM.movies);
        theatreCatalogue = new TheatreCatalogue(dbM.theatres);
        ticketManager = new TicketManagement(this);
        showings = dbM.showings;
    }

    public Movie searchMovie(String name){
        return movieCatalogue.searchMovie(name);
    }

    public Theatre searchTheatre(String name){
        return theatreCatalogue.searchTheatre(name);
    }

    public ArrayList<Showing> getShowings(String movieName, String theatreName){
        ArrayList<Showing> goodShowings = new ArrayList<>();
        for(Showing s: showings){
            if(s.getMovie().getName().equals(movieName) && s.getTheatre().getName().equals(theatreName)){
                goodShowings.add(s);
            }
        }
        return goodShowings;
    }

    public static void main(String[] args){
        DataController dc = new DataController();
        System.out.println(dc.searchMovie("Kung Fu Hustle").getName());
        System.out.println(dc.searchTheatre("Theatre").getName());
        System.out.println(dc.getShowings("Kung Fu Hustle", "Theatre").get(0).getTime());
    }

}