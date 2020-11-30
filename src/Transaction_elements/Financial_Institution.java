package Transaction_elements;

public class Financial_Institution {

    private static Financial_Institution instance = new Financial_Institution();
    private String name = "World Bank";


    private Financial_Institution(){}

    public static Financial_Institution getInstance(){

        return instance;
    }




    void processPayment(Payment process){
        // Assuming that the the customer has a valid bank account
        System.out.println(" Searching the account with respective creditcard's infomration..");
        System.out.println("  creditCardNumber : match \n  cardHolderName: match \n expiryDate : match");
        System.out.println(" Account found, increasing the credit by the the amount of the ticket and sending money to the seller...");

    }



}

