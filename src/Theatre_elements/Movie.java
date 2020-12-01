package Theatre_elements;

/**
 * A representation of a Movie to be played in a movie theatre.
 * @author Luka Petrovic
 * @since 11/27/20
 */
public class Movie {
	/**
	 * The Movie name
	 */
    private String name;
    /**
     * The Movie's runtime in minutes
     */
    private int length;

    /**
     * Default constructor
     */
    public Movie(){
        name = null;
        length = 0;
    }

    /**
     * Constructs a movie object given a name. Runtime is set to a default value of 120 minutes.
     * @param name
     */
    public Movie(String name){
        this.name = name;
        length = 120;
    }

    /**
     * Constructs a movie object given the Movie's name and runtime.
     * @param name
     * @param length
     */
    public Movie(String name, int length){
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
