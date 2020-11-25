package data_control;

import theatre_elements.Theatre;

import java.util.ArrayList;
import java.util.List;

public class TheatreCatalogue {
    private List<Theatre> theatres;

    public TheatreCatalogue(){
        theatres = new ArrayList<>();
    }

    public Theatre searchTheatre(String search){
        for(Theatre t:theatres){
            if(t.getName().toLowerCase().equals(search.toLowerCase())){
                return t;
            }
        }
        return null;
    }
}
