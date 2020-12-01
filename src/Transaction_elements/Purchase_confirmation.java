package Transaction_elements;

/**
 * This class keeps track of the payment and the related payment
 */
public class Purchase_confirmation {


    private Payment payment;
    private Ticket ticket;


    /**
     * A constructor
     * @param Payment, the payment related to the ticket
     * @param ticketA, the ticket purchased for a movie
     */

    public Purchase_confirmation(Payment Payment, Ticket ticketA)
    {
        this.payment = Payment;
        this.ticket = ticketA;


    }



}
