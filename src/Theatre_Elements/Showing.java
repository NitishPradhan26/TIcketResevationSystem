package Theatre_Elements;

import java.util.Date;

public class Showing {
    private Movie movie;
    private Date time;
    private SeatingPlan plan;
    private Theatre theatre;

    /*
     * Constructor when given all necessary objects.
     */
    public Showing(Movie movie, Date date, SeatingPlan plan, Theatre theatre){
        this.movie = movie;
        this.time = date;
        this.plan = plan;
        this.theatre = theatre;
    }

    /*
     * C'tor when date has not been constructed.
     */
    public Showing(Movie movie, int year, int month, int day, int hour, int minute, SeatingPlan plan, Theatre theatre){
        this.movie = movie;
        this.time = new Date(year, month, day, hour, minute);
        this.plan = plan;
        this.theatre = theatre;
    }

    /*
        Ctor given a movie name
     */
    public Showing(String movieName, Date date, SeatingPlan plan, Theatre theatre){
        this.movie = new Movie(movieName);
        this.time = date;
        this.plan = plan;
        this.theatre = theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
