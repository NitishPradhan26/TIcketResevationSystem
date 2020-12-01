package User;

/**
 * This class holds related information about a user
 */
public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private float credit;
    private int accountNum;

    /**
     * A constructor
     * @param name, the name of the user
     * @param username, the user name of the account
     * @param password, the password of the account
     * @param email, the email of the user
     * @param accountNum, the account number of the user
     * @param credit, the theater credit of this user
     */
    public User (String name, String username, String password, String email,  int accountNum, float credit){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountNum = accountNum;
        this.credit = credit;
    }

    /**
     * Getter
     * @returnm the username of this user
     */
    public String getUsername(){
        return username;
    }

    /**
     * Getter
     * @returnm the password of this account
     */
    public String getPassword(){
        return password;
    }

    /**
     * Getter
     * @return, the account number of this user
     */
    public int getAccountNum(){
        return accountNum;
    }

    /**
     * Getter
     * @return, the credit related this account
     */
    public float getCredit() {
        return credit;
    }

    /**
     * Setter
     * @param credit,  set the credit value with this param value
     */
    public void setCredit(float credit) {
        this.credit = credit;
    }

    /**
     * Getter
     * @return, the name of this user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return, the email of this user
     */
    public String getEmail(){
        return email;
    }
}