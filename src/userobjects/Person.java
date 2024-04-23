package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Person {
    private int userID;
    private String name;
    private String email;

    public Person() {
        new Person(000000000, null, null);
    }
    
    public Person(int uID, String name, String email) {
        this.userID = uID;
        this.name = name;
        this.email = email;
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

    public void setUserID(int newID) {
        this.userID = newID;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
}
