package Data_control;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import Transaction_elements.CreditCard;
import Transaction_elements.Financial_Institution;
import Transaction_elements.Payment;
import Transaction_elements.Ticket;
import User.*;

import java.util.ArrayList;

/**
 * Ticket Management class that handles operations related to tickets in the ticket reservation system.
 * @author Alex Price
 */
public class TicketManagement {

    private DataController dc;

    /**
     * Contructs a new TicketManagement with the given DataController.
     * @param dc DataController to use
     */
    public TicketManagement(DataController dc){
        this.dc = dc;
    }

    /**
     * Purchases a seat with the given parameters.
     * @param user user that purchased the seat.
     * @param showing showing that the ticket is for
     * @param row row of the seat purchased
     * @param col column of the seat purchased
     * @param card credit card used to pay for the ticket
     */
    public void purchaseSeat(User user, Showing showing, int row, int col, CreditCard card){
        Seat seat = new Seat(row, col);
        showing.getPlan().purchaseSeat(seat);
        int ticketNo;
        do{
            ticketNo = (int)(Math.random() * 10000d);
        } while(dc.ticketList.getTicket(ticketNo) != null);
        // Calling the instance of Financial_institution that all users use
        Financial_Institution universalBank = Financial_Institution.getInstance();

        Payment payment = new Payment(card, universalBank);

        Ticket ticket = new Ticket(ticketNo, seat, user, showing, 7.99f, false, payment);
        // Applying the process for the completion of the payment
        payment.completePayment(ticket);
        seat.setPurchaser(ticket);
        dc.ticketList.addTicket(ticket);
        dc.storeTicket(ticket);
    }

    /**
     * Gets a list of ticket purchased by the given user
     * @param userNum number of the user to get tickets for
     * @return list of tickets, if any
     */
    public ArrayList<Ticket> getUserTickets(int userNum){
        for(User u:dc.users){
            if(u.getAccountNum() == userNum){
                return dc.ticketList.getUserTickets(u);
            }
        }
        return null;
    }

    /**
     * Cancels the ticket with the given ticket number, if any.
     * @param ticketId id of the ticket to cancel
     * @return boolean representing if the operation was successful or not
     */
    public boolean cancelTicket(int ticketId){
        Ticket ticket = dc.ticketList.getTicket(ticketId);
        if(ticket == null && ticket.refundTicket()){
            dc.cancelTicket(ticket);
            return true;
        }
        return false;
    }
}