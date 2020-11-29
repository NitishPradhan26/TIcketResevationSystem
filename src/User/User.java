package User;

public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private float credit;
    private int accountNum;



    public User(String Name, String Username, String Password, String Email, int Accountnum){

        this.name = Name;
        this.username = Username;
        this.password = Password;
        this.email = Email;
        this.accountNum = Accountnum;
        this.credit =0;


    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }


}