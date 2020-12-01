package Transaction_elements;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import User. *;

public class Ticket {
    private int ticketNo;
    private Seat seat;
    private User user;
    private Showing showing;
    private float price;
    private boolean cancelled;
    private Payment payment;

    public Ticket(int ticketNo, Seat seat, User user, Showing showing, float price, boolean cancelled, Payment p){
        this.ticketNo = ticketNo;
        this.seat = seat;
        this.user = user;
        this.showing = showing;
        this.price = price;
        this.cancelled = cancelled;
        this.payment =p;
    }

    public void refundTicket(){
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
            System.out.println(" Refund failed");
        }
        this.cancelled = true;
        seat.setPurchaser(null);
    }


    public void refundRegisteredUser(){


        float refund= (float) (this.user.getCredit() +price);
        this.user.setCredit(refund);

        System.out.println(" refund credit succesfully added to the client account ");

        this.cancelled = true;
    }

    public  void RefundUnRegisteredUser(){

        if(user != null) {
            float refund = (float) (this.user.getCredit() + (price - (0.15 * price)));
            this.user.setCredit(refund);
        }

        System.out.println(" refund credit succesfully added to the client account ");

        this.cancelled = true;
    }


    public boolean getCancelled(){
        return cancelled;
    }

    public User getUser(){
        return user;
    }

    public float getPrice(){
        return price;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat(){
        return seat;
    }

    public Showing getShowing() {
        return showing;
    }
}
