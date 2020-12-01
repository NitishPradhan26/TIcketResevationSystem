package Transaction_elements;

    /**
    * This class represents the Bank of all the users. Its uses a singleton pattern tp preserve its its uniqeness
    */
public class Financial_Institution {

    private static Financial_Institution instance = new Financial_Institution();
    private String name = "World Bank";

    /**
     * Private construction, it cannot be instanciated.
     */
    private Financial_Institution(){}

    /**
     * A Getter
     * @return, the only instance of this class
     */
    public static Financial_Institution getInstance(){

        return instance;
    }


        /**
         * This function stimulates what happens when the user inputs his/her credit card information to buy a ticket
         * @param process, contains the creddit card related to it
         */
    void processPayment(Payment process){
        // Assuming that the the customer has a valid bank account
        System.out.println(" Searching the account with respective creditcard's infomration..");
        System.out.println(" creditCardNumber : match \n  cardHolderName: match \n expiryDate : match");
        System.out.println(" Account found, increasing the credit by the the amount of the ticket and sending money to the seller...");

    }



}

