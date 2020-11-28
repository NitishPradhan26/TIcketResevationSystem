package data_control;

import theatre_elements.Showing;
import transaction_elements.Ticket;
import users.User;

public class TicketManagement {

    private DataController dc;

    public TicketManagement(DataController dc){
        this.dc = dc;
    }

    //TODO finish function once combined
    public void purchaseSeat(User user, Showing showing, char row, char col){
        //showing.addSeat(new Seat())
        int ticketNo;
        do{
            ticketNo = (int)(Math.random() * 10000d);
        } while(dc.ticketList.getTicket(ticketNo) != null);
        //dc.ticketList.addTicket(new Ticket(ticketNo, seat, user, 7.99f, false));
    }

    //TODO finish function once combined
    public void cancelTicket(int ticketId){

    }
}
