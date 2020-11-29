package User;

public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private float credit;
    private int accountNum;

    public User (String name, String username, String password, String email,  int accountNum, float credit){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountNum = accountNum;
        this.credit = credit;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}