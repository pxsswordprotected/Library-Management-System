package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Staff extends Person{
    private String userName;
    private String password;
    
    public Staff(int sID, String name, String email, String userName, String password) {
        super(sID, name, email);
        this.userName = userName;
        this.password = password;
    }
    public Staff() {
        new Staff(000000000, null, null, null, null);
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
