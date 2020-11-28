package users;

public class User {
    private String name;
    private String username;
    private String password;
    private String email;
    private int accountNum;
    private float credit;

    public User (String name, String username, String password, String email,  int accountNum, float credit){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountNum = accountNum;
        this.credit = credit;
    }

    public int getAccountNum(){
        return accountNum;
    }
}
