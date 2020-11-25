package data_control;

import theatre_elements.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogue {
    private List<Movie> movies;

    public MovieCatalogue(){
        movies = new ArrayList<>();
    }

    public Movie searchMovie(String search){
        for(Movie m:movies){
            if(m.getName().toLowerCase().equals(search.toLowerCase())){
                return m;
            }
        }
        return null;
    }
}