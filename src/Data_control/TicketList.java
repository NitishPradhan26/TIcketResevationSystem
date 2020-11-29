package Data_control;

import Transaction_elements.Ticket;
import User.User;

import java.util.ArrayList;

public class TicketList {
    private ArrayList<Ticket> tickets;

    public TicketList(ArrayList<Ticket> tickets){
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public Ticket getTicket(int ticketNo){
        for(Ticket t:tickets){
            if(ticketNo == t.getTicketNo()){
                return t;
            }
        }
        return null;
    }

    public ArrayList<Ticket> getUserTickets(User user){
        ArrayList<Ticket> userTickets = new ArrayList<>();
        for(Ticket t:tickets){
            if(t.getUser() == user){
                userTickets.add(t);
            }
        }
        return userTickets;
    }
}
