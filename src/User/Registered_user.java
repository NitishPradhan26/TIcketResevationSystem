package User;
public class Registered_user extends User {

    private String creditCardNumber;
    private String address;

    public Registered_user(String name, String username, String password, String email, int accountNum, float credit, String creditCardNo, String address) {
        super(name, username, password, email, accountNum, credit);
        this.creditCardNumber = creditCardNo;
        this.address = address;
    }
}
