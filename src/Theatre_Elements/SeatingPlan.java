package Theatre_Elements;

import Transaction_elements.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeatingPlan {
    private HashMap<String, ArrayList<Seat>> seats;
    /*
     Creates a 10x10 Seating plan with new Seats
     */
    public SeatingPlan(){
        seats = new HashMap<>();
        char rowLetter = 'A';
        while(rowLetter < 'K'){
            ArrayList<Seat> rowSeats = new ArrayList<>();
            for(int i = 0; i <= 10; i++){
                rowSeats.add(new Seat(String.valueOf(rowLetter), i));
            }
            seats.put(String.valueOf(rowLetter), rowSeats);
            rowLetter++;
        }
    }

    /*
     Copies an existing map of seats
     */
    public SeatingPlan(HashMap<String, ArrayList<Seat>> seats){
        this.seats = seats;
    }

    /*
     Purchases seat based off given String, in format rowNumber (i.e, "A4") - might need to be edited
     */
    public void purchaseSeat(String seatRequest){
        String row = String.valueOf(seatRequest.charAt(0));
        int seat = Integer.parseInt(String.valueOf(seatRequest.charAt(1)));

        seats.get(row).get(seat).purchaseSeat(new Ticket());//arguments??
    }

    /*
     Cancels a seat based off given String, in format rowNumber (i.e, "A4") 
     */
    public void cancelSeat(String seatRequest){
        String row = String.valueOf(seatRequest.charAt(0));
        int seat = Integer.parseInt(String.valueOf(seatRequest.charAt(1)));

        seats.get(row).get(seat).cancelSeat();
    }

    /*
     Edited to return a string representation of this seating plan.
     */
    public String displaySeats(){
        String output = "";
        for (Map.Entry<String, ArrayList<Seat>> entry: seats.entrySet()) {
            output += entry.getKey() + " ";
            for (Seat s:entry.getValue()) {
                output += s.toString();
            }
            output += "\n";
        }
        return output;
    }


}

