package Data_control;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import Transaction_elements.CreditCard;
import Transaction_elements.Financial_Institution;
import Transaction_elements.Payment;
import Transaction_elements.Ticket;
import User.*;

import java.util.ArrayList;

public class TicketManagement {

    private DataController dc;

    public TicketManagement(DataController dc){
        this.dc = dc;
    }

    public void purchaseSeat(User user, Showing showing, int row, int col, CreditCard card){
        // This function also needs to have a credit card object as an argument

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

    }

    public ArrayList<Ticket> getUserTickets(int userNum){
        for(User u:dc.users){
            if(u.getAccountNum() == userNum){
                return dc.ticketList.getUserTickets(u);
            }
        }
        return null;
    }

    public boolean cancelTicket(int ticketId){
        Ticket ticket = dc.ticketList.getTicket(ticketId);
        if(ticket == null){
            return false;
        }
        else {
            ticket.refundTicket();
            return true;
        }
    }
}