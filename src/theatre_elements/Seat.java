package Theatre_elements;

import Transaction_elements.Ticket;

public class Seat {
    private char row;
    private char seatNo;
    private Ticket purchaser;

    public Seat(char row, char seatNo){
        this.row = row;
        this.seatNo = seatNo;
        this.purchaser = null;
    }

    public void setTicket(Ticket ticket){
        this.purchaser = ticket;
    }

}
