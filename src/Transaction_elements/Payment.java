package Transaction_elements;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  This class contains the information related to a payment process
 */
public class Payment {

    private CreditCard creditCard;
    private Financial_Institution bank;
    private Timestamp timeStamp;


    /**
     * A constructor to initializes its values
     * @param CreditCard, the credit card related to a particular payment
     * @param Bank, the bank to contact to complete the process payment
     */
    public Payment(CreditCard CreditCard,Financial_Institution Bank){
        this.creditCard = CreditCard;
        this.bank = Bank;
        this.timeStamp = new Timestamp(System.currentTimeMillis());


    }

    /**
     * Constructs an empty payment.
     */
    public Payment() {
        this.timeStamp = new Timestamp(System.currentTimeMillis());
    }

    /**
     * This function completes the payment process by either contacting the bank or by reducing the credit he has in his account
     * @param ticket
     */


    public void completePayment(Ticket ticket){

        System.out.println(" Ticket purchase process start........");
        if(ticket.getUser().getCredit() < ticket.getPrice()) {

            System.out.println(" The user does not have enough credit in his account, so contacting his bank");
            this.bank.processPayment(this);
        }

        else{

            System.out.println(" Reducing the User.s credit by the amount of the price of the ticket");

            float temp = ticket.getUser().getCredit() - ticket.getPrice();
            ticket.getUser().setCredit(temp);

        }

        System.out.println(" Process complete, proceed to make the purchase confirmation");

    }

    /**
     * This function checks if the refund is possible
     * @return, true if refund possible, false if not
     */

    public boolean completeRefund(){

        System.out.println(" Ticket refund start........ ");

        Timestamp refund = new Timestamp(System.currentTimeMillis());
        float timeOfPurchase = this.timeStamp.getTime();
        float timeOfRefund = refund.getTime();

        // Calculating time passed in hours

        float totalhoursPassed = (timeOfRefund - timeOfPurchase)/(1000 *60*60);

        // checking the validation of the refund

        if( totalhoursPassed < 72){

            System.out.print(" The refund is validated by the theater: proceed to transfer the credit and make the refund confirmation");

            // return true if the refund is validated

            return true;

        }

        else{
            // return false if the refund is validated


            return false;
        }

    }


}

