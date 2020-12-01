package Transaction_elements;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import User. *;

/**
 * This class keeps track of the related information and function of ticket purchase and ticket cancelation
 */
public class Ticket {
    private int ticketNo;
    private Seat seat;
    private User user;
    private Showing showing;
    private float price;
    private boolean cancelled;
    private Payment payment;

    /**
     * A constructor
     * @param ticketNo, the number of the ticket
     * @param seat, the seat of the ticket
     * @param user, the buyer of the ticket
     * @param showing , the showing related to the ticket
     * @param price , the prices of  the ticket
     * @param cancelled, the state of the ticket
     * @param p, the payment info related to the ticker purchase
     */
    public Ticket(int ticketNo, Seat seat, User user, Showing showing, float price, boolean cancelled, Payment p){
        this.ticketNo = ticketNo;
        this.seat = seat;
        this.user = user;
        this.showing = showing;
        this.price = price;
        this.cancelled = cancelled;
        this.payment =p;
    }

    /**
     * This function refunds the ticket if valid, if not returns an error
     * @return if the operation was successful
     */
    public boolean refundTicket(){
        boolean temp = this.payment.completeRefund();
        if(temp){
            if(this.getUser() instanceof Registered_user) {
                // return true if the refund is validated
                this.refundRegisteredUser();
            }
            else{
                this.RefundUnRegisteredUser();
            }
        }
        else{
            System.out.println(" Refund failed : passed the 72 hours mark");
            return false;
        }
        this.cancelled = true;
        seat.setPurchaser(null);
        return true;
    }

    /**
     * Refund process for the registered user
     */
    public void refundRegisteredUser(){


        float refund= (float) (this.user.getCredit() +price);
        this.user.setCredit(refund);

        System.out.println(" refund credit succesfully added to the client account ");

        this.cancelled = true;
    }

    /**
     * Refund process for the unregistered user
     */

    public  void RefundUnRegisteredUser(){

        if(user != null) {
            float refund = (float) (this.user.getCredit() + (price - (0.15 * price)));
            this.user.setCredit(refund);
        }

        System.out.println(" refund credit succesfully added to the client account ");

        this.cancelled = true;
    }

    /**
     * This function return the state of the ticket
     * @return, boolean value
     */

    public boolean getCancelled(){
        return cancelled;
    }

    /**
     * Getter
     * @return, the user object related to this ticket
     */
    public User getUser(){
        return user;
    }

    /**
     * Getter
     * @return, the prices of the ticket
     */
    public float getPrice(){
        return price;
    }

    /**
     * Getter
     * @return, the ticket no of the ticket
     */
    public int getTicketNo() {
        return ticketNo;
    }

    /**
     * Setter
     * @param seat, initializes the seat varialbe of this ticket with seat object provided
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * Getter
     * @return, the object of seat class related to this ticket
     */
    public Seat getSeat(){
        return seat;
    }

    /**
     * Getter
     * @return, the object of showing related to this ticket
     */

    public Showing getShowing() {
        return showing;
    }
}
