package Theatre_elements;

import Transaction_elements.Ticket;

public class Seat {
    private int row;
    private int seatNo;
    private Ticket purchaser;

    public Seat(int row, int seatNo, Ticket ticket) {
        purchaser = ticket;
        this.seatNo = seatNo;
        this.row = row;
    }

    public Seat(int row, int seatNo) {
        purchaser = null;
        this.seatNo = seatNo;
        this.row = row;
    }

    public Seat() {
        row = 0;
        seatNo = 0;
        purchaser = null;
    }

    public boolean isAvailable() {
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
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
        return "|" + row + seatNo + "| ";
    }
}
