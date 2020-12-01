package Data_control;

import Theatre_elements.Theatre;

import java.util.ArrayList;

/**
 * Catalogue for all theatres in the ticket reservation system.
 * @author Alex Price
 */
public class TheatreCatalogue {
    private ArrayList<Theatre> theatres;

    /**
     * Constructs a new MovieCatalogue with the given movie list.
     * @param theatres list of movies
     */
    public TheatreCatalogue(ArrayList<Theatre> theatres){
        this.theatres = theatres;
    }

    /**
     * Search for a theatre with the given name
     * @param search name of theatre
     * @return theatre with matching name, if any
     */
    public Theatre searchTheatre(String search){
        for(Theatre t:theatres){
            if(t.getName().toLowerCase().equals(search.toLowerCase())){
                return t;
            }
        }
        return null;
    }

    /**
     * Gets the list of theatres.
     * @return list of theatres
     */
    public ArrayList<Theatre> getTheatres(){
        return theatres;
    }
}
