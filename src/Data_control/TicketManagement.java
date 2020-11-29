package Data_control;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import Transaction_elements.Ticket;
import User.*;

import java.util.ArrayList;

public class TicketManagement {

    private DataController dc;

    public TicketManagement(){
        this.dc = DataController.dataController();
    }

    public void purchaseSeat(User user, Showing showing, String row, int col){
        Seat seat = new Seat(row, col);
        showing.getPlan().purchaseSeat(seat);
        int ticketNo;
        do{
            ticketNo = (int)(Math.random() * 10000d);
        } while(dc.ticketList.getTicket(ticketNo) != null);
        Ticket ticket = new Ticket(ticketNo, seat, user, showing, 7.99f, false);
        seat.setPurchaser(ticket);
        dc.ticketList.addTicket(ticket);
    }

    public ArrayList<Ticket> getUserTickets(int userNum){
        for(User u:dc.users){
            if(u.getAccountNum() == userNum){
                return dc.ticketList.getUserTickets(u);
            }
        }
        return null;
    }

    public void cancelTicket(int ticketId){
        Ticket ticket = dc.ticketList.getTicket(ticketId);
        float refund = ticket.getPrice();
        if(!(ticket.getUser() instanceof Registered_user)){
            refund *= 0.85f;
        }
        ticket.refundTicket();
        ticket.getUser().setCredit(ticket.getUser().getCredit() + refund);
    }
}
