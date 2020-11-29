package Data_control;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import Transaction_elements.Ticket;
import User.User;

public class TicketManagement {

    private DataController dc;

    public TicketManagement(DataController dc){
        this.dc = dc;
    }

    public void purchaseSeat(User user, Showing showing, char row, char col){
        Seat seat = new Seat(row, col);
        showing.addSeat(seat);
        int ticketNo;
        do{
            ticketNo = (int)(Math.random() * 10000d);
        } while(dc.ticketList.getTicket(ticketNo) != null);
        Ticket ticket = new Ticket(ticketNo, seat, user, showing, 7.99f, false);
        seat.setTicket(ticket);
        dc.ticketList.addTicket(ticket);
    }

    //TODO finish function once combined
    public void cancelTicket(int ticketId){

    }
}
