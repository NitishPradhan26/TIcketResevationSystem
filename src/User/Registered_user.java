package User;
public class Registered_user extends User {

    private String creditCardNumber;
    private String address;



    public Registered_user(String Name, String Username, String Password, String Email, int Accountnum,String CreditCardNumber,String Address) {
        super(Name, Username, Password, Email, Accountnum);

        this.creditCardNumber = CreditCardNumber;
        this.address = Address;
    }



}
