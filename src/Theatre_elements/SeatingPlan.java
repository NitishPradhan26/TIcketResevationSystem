package Theatre_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeatingPlan {
    private HashMap<String, Seat> seats;

    /*
     Copies an existing map of seats
     */
    public SeatingPlan(HashMap<String, Seat> seats){
        this.seats = seats;
    }

    /*
     Given a List of currently taken seats, fill the seat map
     */
    public SeatingPlan(ArrayList<Seat> takenSeats){
        seats = new HashMap<>();
        for (Seat s : takenSeats) {
            String key = s.getRow() + s.getSeatNo();
            seats.put(key, s);
        }
    }

    /*
     Purchases seat based off given Seat, in format rowNumber (i.e, "A4");
     */
    public void purchaseSeat(Seat toAdd){
        String key = toAdd.getRow() + toAdd.getSeatNo();

        seats.put(key, toAdd);
    }

    /*
     Cancels a seat based off given String, in format rowNumber (i.e, "A4")
     */
    public void cancelSeat(Seat toRemove){
        seats.remove(toRemove);
    }

    /*
     Edited to return a string representation of this seating plan.
     */
    public ArrayList<Seat> getTakenSeats(){
        ArrayList<Seat> takenSeats = new ArrayList<>();
        for (Map.Entry<String, Seat> theSeats:seats.entrySet()) {
            takenSeats.add(theSeats.getValue());
        }
        return takenSeats;
    }
}