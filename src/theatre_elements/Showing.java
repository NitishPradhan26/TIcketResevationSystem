package theatre_elements;

import java.sql.Timestamp;

public class Showing {
    private Movie movie;
    private String time;
    private SeatingPlan plan;
    private Theatre theatre;

    public Showing(Movie movie, Theatre theatre, String time){
        this.movie = movie;
        this.time = time;
        this.theatre = theatre;
    }

    public void setPlan(SeatingPlan plan){
        this.plan = plan;
    }

    public Movie getMovie(){
        return movie;
    }

    public Theatre getTheatre(){
        return theatre;
    }

    public String getTime(){
        return time;
    }
}
