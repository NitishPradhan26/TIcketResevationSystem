package Transaction_elements;
public class CreditCard {

    private String creditCardNumber;
    private String cardHolderName;
    private String expiryDate;
    private int CVV;


    public CreditCard(String CreditCardNumber, String CardHolderName, String ExpiryDate , int cvv){

        this.cardHolderName = CardHolderName;
        this.creditCardNumber = CreditCardNumber;
        this.expiryDate = ExpiryDate;
        this.CVV = cvv;

    }

    public String getCCNum(){
        return creditCardNumber;
    }


    void makePayment(Float amount){


    }


}
