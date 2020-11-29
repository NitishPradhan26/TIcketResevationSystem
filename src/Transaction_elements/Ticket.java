package Transaction_elements;

import Theatre_elements.Seat;
import Theatre_elements.Showing;
import User.User;

public class Ticket {
    private int ticketNo;
    private Seat seat;
    private User user;
    private Showing showing;
    private float price;
    private boolean cancelled;

    public Ticket(int ticketNo, Seat seat, User user, Showing showing, float price, boolean cancelled){
        this.ticketNo = ticketNo;
        this.seat = seat;
        this.user = user;
        this.showing = showing;
        this.price = price;
        this.cancelled = cancelled;
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
}
