package Data_control;

import Theatre_elements.Movie;

import java.util.ArrayList;

/**
 * Catalogue for all movies in the ticket reservation system.
 * @author Alex Price
 */
public class MovieCatalogue {
    private ArrayList<Movie> movies;

    /**
     * Constructs a new MovieCatalogue with the given movie list.
     * @param movies list of movies
     */
    public MovieCatalogue(ArrayList<Movie> movies){
        this.movies = movies;
    }

    /**
     * Search for a movie with the given name
     * @param search name of movie
     * @return movie with matching name, if any
     */
    public Movie searchMovie(String search){
        for(Movie m:movies){
            if(m.getName().toLowerCase().equals(search.toLowerCase())){
                return m;
            }
        }
        return null;
    }

    /**
     * Gets the list of movies.
     * @return list of movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}