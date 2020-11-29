package Transaction_elements;

import User.*;
public class Ticket {


    private Seat seat;


    private User user;
    private Showing showing;


    private float price;
    private boolean cancelled;


    public Ticket( Seat Seat,User userA, Showing showingA, float Price, boolean Cancelled)

    {

        this.seat = Seat;
        this.user = userA;
        this.showing = showingA;
        this.price = Price;
        this.cancelled = false;


    }

    public void refundTransfer(){


        float refund= (float) (this.user.getCredit() + (price - (0.15*price)));
        this.user.setCredit(refund);

        System.out.println(" refund credit succesfully added to the client account ");

        this.cancelled = true;
    }

    public User getUser() {
        return user;
    }

    public float getPrice() {
        return price;
    }




}
