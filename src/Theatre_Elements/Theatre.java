package Theatre_Elements;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String name;
    private String address;
    private ArrayList<Showing> showings;
    private ArrayList<Movie> movies;


    public Theatre(String name, String address, List<Showing> showings, List<Movie> movies){
        this.name = name;
        this.address = address;
        this.showings = (ArrayList<Showing>) showings;
        this.movies = (ArrayList<Movie>) movies;
    }

    public Theatre(){
        name = null;
        address = null;
        showings = new ArrayList<>();
        movies = new ArrayList<>();
    }

    public Theatre(String name, String address){
        this.name = name;
        this.address = address;
        showings = new ArrayList<>();
        movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }

    public void setShowings(ArrayList<Showing> showings) {
        this.showings = showings;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void addShowing(Showing s){
        showings.add(s);

        //add showing movie to movies if not already in movies
        for (Movie m:movies) {
            if(s.getMovie().getName().equalsIgnoreCase(m.getName())){
                return;
            }
        }

        movies.add(s.getMovie());
    }

    public void addMovie(Movie m){
        movies.add(m);
    }



}
