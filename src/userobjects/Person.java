package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Person {
    private int userID;
    private String name;
    private String email;
    private String password;

    public Person() {
        new Person(000000000, null, null, null);
    }
    
    public Person(int uID, String name, String email, String password) {
        this.userID = uID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setUserID(int newID) {
        this.userID = newID;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public void setPassword(String newPass) {
        this.password = newPass;
    }
}
