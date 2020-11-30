package Theatre_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeatingPlan {
    private Seat[][] seats;

 
    /*
     Given a List of currently taken seats, fill the seat map
     */
    public SeatingPlan(ArrayList<Seat> takenSeats){
        seats = new Seat[5][5];
        for (Seat s : takenSeats){
            seats[s.getRow()-1][s.getSeatNo()-1] = s;
        }
        
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		if(seats[i][j] == null) {
        			seats[i][j] = new Seat(i,j);
        		}
        	}
        }
      
    }

    /*
     Purchases seat based off given Seat, in format rowNumber (i.e, "A4");
     */
    public void purchaseSeat(Seat toAdd){
    	seats[toAdd.getRow()][toAdd.getSeatNo()] = toAdd;
    }

    /*
     Cancels a seat based off given String, in format rowNumber (i.e, "A4")
     */
    public void cancelSeat(Seat toRemove){
    	seats[toRemove.getRow()][toRemove.getSeatNo()] = new Seat(toRemove.getRow(),toRemove.getSeatNo());
    }

    public boolean isTaken(int row, int seatNo) {
    	if(seats[row][seatNo].isAvailable()) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    /*
     Edited to return a 2d Array representation of this seating plan.
     0 = Available
     1 = Taken
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