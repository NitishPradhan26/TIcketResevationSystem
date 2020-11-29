package Transaction_elements;
public class CreditCard {

    private String creditCardNumber;
    private String cardHolderName;
    private String expiryDate;


    public CreditCard(String CreditCardNumber, String CardHolderName, String ExpiryDate ){

        this.cardHolderName = CardHolderName;
        this.creditCardNumber = CreditCardNumber;
        this.expiryDate = ExpiryDate;

    }


    void makePayment(Float amount){


    }


}
