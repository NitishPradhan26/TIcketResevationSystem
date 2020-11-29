package Transaction_elements;

public class Purchase_confirmation {


    private Payment payment;
    private Ticket ticket;


    public Purchase_confirmation(Payment Payment, Ticket ticketA)
    {
        this.payment = Payment;
        this.ticket = ticketA;


    }



}
