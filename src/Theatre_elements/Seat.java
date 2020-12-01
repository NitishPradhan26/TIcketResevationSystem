package Theatre_elements;

import Transaction_elements.Ticket;

/**
 * A representation of a Seat in a movie theatre.
 * @author Luka Petrovic
 * @since 11/29/20
 */
public class Seat {
	/**
	 * The row of the Seat
	 */
    private int row;
    /**
     * The seat number within the row that the seat is in
     */
    private int seatNo;
    /**
     * The ticket assigned to a seat, if the seat is bought
     */
    private Ticket purchaser;

    /**
     * Constructor if a ticket for the seat is already bought
     * @param row
     * @param seatNo
     * @param ticket
     */
    public Seat(int row, int seatNo, Ticket ticket) {
        purchaser = ticket;
        this.seatNo = seatNo;
        this.row = row;
    }

    /**
     * Constructor if there is currently no ticket bought for the seat
     * @param row
     * @param seatNo
     */
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
    
    /**
     * Checks if a seat is available for purchase
     * @return boolean indicating if a seat is open or not
     */
    public boolean isAvailable() {
        if (purchaser == null) {
            return true;
        }
        return false;
    }

    /**
     * Purchases seat by assigning given ticket to the purchaser field of the seat object.
     * @param t The ticket to be assigned
     */
    public void purchaseSeat(Ticket t) {
        purchaser = t;
        t.setSeat(this);
    }

    /**
     * Cancels seat by removing the purchaser Ticket.
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
