package User;

import Transaction_elements.CreditCard;

/**
 * This class hild information about an a registered user
 */
public class Registered_user extends User {

    private CreditCard creditCard;
    private String address;


    /**
     * A constructor
     * @param name, the name
     * @param username, the user name
     * @param password, the password of this account
     * @param email, the email related this account
     * @param accountNum, the account number realted this account
     * @param credit, the theater credit in this account
     * @param creditCardNo, the credit card num of this user
     * @param ccExpiry, the expirary date of the credit card
     * @param ccCVV, the cvv related this credit card
     * @param address, the address fo this user
     */
    public Registered_user(String name, String username, String password, String email, int accountNum, float credit, String creditCardNo, String ccExpiry, int ccCVV, String address) {
        super(name, username, password, email, accountNum, credit);
        this.creditCard = new CreditCard(creditCardNo, name, ccExpiry, ccCVV);
        this.address = address;
    }

    /**
     * Getter
     * @returnm the credit card object
     */

    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Getter
     * @return, the address of the registered user
     */
    public String getAddress(){
        return address;
    }
}
