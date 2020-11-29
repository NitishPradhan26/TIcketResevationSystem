package Theatre_elements;

import Transaction_elements.Ticket;

public class Seat {
    private String row;
    private int seatNo;
    private Ticket purchaser;

    public Seat(String row, int seatNo, Ticket ticket) {
        purchaser = ticket;
        this.seatNo = seatNo;
        this.row = row;
    }

    public Seat(String row, int seatNo) {
        purchaser = null;
        this.seatNo = seatNo;
        this.row = row;
    }

    public Seat() {
        row = null;
        seatNo = 0;
        purchaser = null;
    }

    public boolean isAvailble() {
        if (purchaser == null) {
            return true;
        }
        return false;
    }

    /*
     Purchases seat by assigning given ticket to the purchaser field of this.
     */
    public void purchaseSeat(Ticket t) {
        purchaser = t;
        t.setSeat(this);
    }

    /*
     Cancels seat by removing the purchaser Ticket.
     */
    public void cancelSeat() {
        purchaser = null;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public Ticket getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Ticket purchaser) {
        this.purchaser = purchaser;
    }

    @Override
    public String toString() {
        return "|" + seatNo + "| ";
    }
}
