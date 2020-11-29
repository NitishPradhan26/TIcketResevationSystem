package Theatre_elements;

import java.util.List;

public class SeatingPlan {
    private List<Seat> seats;

    public SeatingPlan(List<Seat> seats){
        this.seats = seats;
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }
}
