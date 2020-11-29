package Data_control;

import Theatre_elements.Theatre;

import java.util.ArrayList;

public class TheatreCatalogue {
    private ArrayList<Theatre> theatres;

    public TheatreCatalogue(ArrayList<Theatre> theatres){
        this.theatres = theatres;
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
