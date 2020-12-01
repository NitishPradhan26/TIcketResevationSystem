package Transaction_elements;

/**
 * This class is used to store information related to credit card
 *
 */

public class CreditCard {

    private String creditCardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int CVV;

    /**
     * A constructor for the class that initializes its private variables
     * @param CreditCardNumber, number of the card
     * @param CardHolderName, The name of the credit card owner
     * @param ExpiryDate, the date at which the credit card's validation ends
     * @param cvv, The cvv
     */
    public CreditCard(String CreditCardNumber, String CardHolderName, String ExpiryDate , int cvv){

        this.cardHolderName = CardHolderName;
        this.creditCardNumber = CreditCardNumber;
        this.expiryDate = ExpiryDate;
        this.CVV = cvv;

    }

    /**
     * A getter
     * @return, returns credit card number
     */

    public String getCCNum(){
        return creditCardNumber;
    }




}
