package Theatre_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A representation of a movie theatre's seating plan.
 * @author Luka Petrovic
 * @since 11/29/20
 */
public class SeatingPlan {
	/**
	 * The layout of seats in the SeatingPlan
	 */
    private Seat[][] seats;

 
    /**
     * Given a List of currently taken seats, initialize the seating plan accordingly
     * @param takenSeats the list of taken seats
     */
    public SeatingPlan(ArrayList<Seat> takenSeats){
        seats = new Seat[5][5];
        for (Seat s : takenSeats){
            seats[s.getRow()-1][s.getSeatNo()-1] = s;
        }
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 5; j++) {
        		if(seats[i][j] == null) {
        			seats[i][j] = new Seat(i,j);
        		}
        	}
        }
    }

    /**
     * Purchases a Seat based off given Seat.
     * @param toAdd the purchased seat, which replace an unsold seat 
     */
    public void purchaseSeat(Seat toAdd){
    	seats[toAdd.getRow()][toAdd.getSeatNo()] = toAdd;
    }

    /**
     * Cancels a seat based off given Seat
     * @param toRemove the Seat representing the seat to be removed.
     */
    public void cancelSeat(Seat toRemove){
    	seats[toRemove.getRow()][toRemove.getSeatNo()] = new Seat(toRemove.getRow(),toRemove.getSeatNo());
    }

    /**
     * Checks if a Seat in the plan is already taken by another user.
     * @param row the row to be checked
     * @param seatNo the seat number within the row to be checked
     * @return a boolean indicating if the seat is taken
     */
    public boolean isTaken(int row, int seatNo) {
        try {
            if (seats[row][seatNo].isAvailable()) {
                return false;
            } else {
                return true;
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Gets a representation of this seating plan, which shows if a seat is already taken or not. 0 = Available, 1 = Taken
     * @return a 2d Array representation of this seating plan.
     */
    public int[][] getTakenSeats(){
    	int[][] takenSeats = new int[5][5];
    	for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		if(seats[i][j].isAvailable()) {
        			takenSeats[i][j] = 0;
        		}
        		else {
        			takenSeats[i][j] = 1;
        		}
        	}
        }
        return takenSeats;
    }
}