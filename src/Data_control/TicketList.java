package Data_control;

import Transaction_elements.Ticket;
import User.User;

import java.util.ArrayList;

/**
 * Class containing all tickets in the ticket reservation system.
 * @author Alex Price
 */
public class TicketList {
    private ArrayList<Ticket> tickets;

    /**
     * Constructs a TicketList with the given list of tickets
     * @param tickets list of tickets
     */
    public TicketList(ArrayList<Ticket> tickets){
        this.tickets = tickets;
    }

    /**
     * Adds a new Ticket to the TicketList.
     * @param ticket ticket to add
     */
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    /**
     * Gets the Ticket with the matching ticket number
     * @param ticketNo number of ticket
     * @return ticket with matching number, if any
     */
    public Ticket getTicket(int ticketNo){
        for(Ticket t:tickets){
            if(ticketNo == t.getTicketNo()){
                return t;
            }
        }
        return null;
    }

    /**
     * Gets a list of all tickets that belong to a given user.
     * @param user user to search for tickets with
     * @return list of tickets, if any
     */
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
