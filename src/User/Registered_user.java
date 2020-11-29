package User;

import Transaction_elements.CreditCard;

public class Registered_user extends User {

    private CreditCard creditCard;
    private String address;

    public Registered_user(String name, String username, String password, String email, int accountNum, float credit, String creditCardNo, String ccExpiry, int ccCVV, String address) {
        super(name, username, password, email, accountNum, credit);
        this.creditCard = new CreditCard(creditCardNo, name, ccExpiry, ccCVV);
        this.address = address;
    }
}
