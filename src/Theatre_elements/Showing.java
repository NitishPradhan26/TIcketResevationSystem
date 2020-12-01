package Theatre_elements;



/**
 * A representation of a movie showing at a theatre.
 * @author Luka Petrovic
 * @since 11/29/20
 *
 */
public class Showing {
	/**
	 * The Movie being played at this Showing
	 */
    private Movie movie;
    /**
     * The time the Showing is being held
     */
    private MyDate time;
    /**
     * The Showing's Seating Plan (arrangement of Seats)
     */
    private SeatingPlan plan;
    /**
     * The theatre the showing is being held at
     */
    private Theatre theatre;

    /**
     * Constructor when given all necessary objects.
     * @param movie 
     * @param date
     * @param plan
     * @param theatre
     */
    public Showing(Movie movie, MyDate date, SeatingPlan plan, Theatre theatre){
        this.movie = movie;
        this.time = date;
        this.plan = plan;
        this.theatre = theatre;
    }

    /**
     * Constructor when a MyDate has not been given.
     * @param movie
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param plan
     * @param theatre
     */
    public Showing(Movie movie, int year, int month, int day, int hour, int minute, SeatingPlan plan, Theatre theatre){
        this.movie = movie;
        this.time = new MyDate(year, month, day, hour, minute);
        this.plan = plan;
        this.theatre = theatre;
    }

    /**
     * Constructor when only given a movie name
     * @param movieName
     * @param date
     * @param plan
     * @param theatre
     */
    public Showing(String movieName, MyDate date, SeatingPlan plan, Theatre theatre){
        this.movie = new Movie(movieName);
        this.time = date;
        this.plan = plan;
        this.theatre = theatre;
    }

    /**
     * Constructor when there is no seating plan 
     * @param movie
     * @param theatre
     * @param date
     */
    public Showing(Movie movie, Theatre theatre, MyDate date){
        this.movie = movie;
        this.theatre = theatre;
        this.time = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MyDate getTime() {
        return time;
    }

    public void setTime(MyDate time) {
        this.time = time;
    }

    public SeatingPlan getPlan() {
        return plan;
    }

    public void setPlan(SeatingPlan plan) {
        this.plan = plan;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
