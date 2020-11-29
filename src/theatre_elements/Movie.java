package theatre_elements;

public class Movie {
    private String name;
    private int length;

    public Movie(String name, int length){
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }
}
