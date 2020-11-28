package data_control;

import transaction_elements.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    ArrayList<Ticket> tickets;

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
}
