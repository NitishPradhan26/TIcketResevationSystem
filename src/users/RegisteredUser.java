package users;

public class RegisteredUser extends User{

    private String creditCardNo;
    private String address;

    public RegisteredUser(String name, String username, String password, String email, int accountNum, float credit, String creditCardNo, String address) {
        super(name, username, password, email, accountNum, credit);
        this.creditCardNo = creditCardNo;
        this.address = address;
    }
}
