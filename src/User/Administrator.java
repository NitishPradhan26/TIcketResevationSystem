package User;

/**
 * This class stores the info about the administer
 */
public class Administrator extends User {

    /**
     * A constructor
     * @param name, the name
     * @param username the user name
     * @param password, the passord of this account
     * @param email, the email of this administer
     * @param accountNum, the account number
     * @param credit, the credit balance related to this account
     */
    public Administrator(String name, String username, String password, String email, int accountNum, float credit) {
        super(name, username, password, email, accountNum, credit);
    }
}