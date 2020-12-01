package Transaction_elements;

    /**
    * This class keeps track of the ticket that has been refunded
    */
public class Refund_confirmation {

    private Ticket ticket;

    /**
     * A constructor
     * @param ticketR, the tickets that has been refunded
     */
    public Refund_confirmation(Ticket ticketR){

        this.ticket = ticketR;
    }

}
