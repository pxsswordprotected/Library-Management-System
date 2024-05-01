package userobjects;

import userobjects.Rental;

/**
 *
 * @author Grant Swift
 */
public class Student extends Person {
    private int classification;
    private int rentalNumber;
    private String password;
    private int uID;

    public final int UNDEFINED = 0;
    public final int FRESHMAN = 1;
    public final int SOPHMORE = 2;
    public final int JUNIOR = 3;
    public final int SENIOR = 4;

    public Student(int uID, String name, String email, String password, int classif) {
        super(uID, name, email, password);
        this.classification = classif;
        this.password = password;
        this.uID = uID;
    }
    public Student() {
        new Student(000000000, null, null, null,  UNDEFINED);
    }

    public int getClassification() {
        return classification;
    }
    public void setClassification(int classif) {
        this.classification = classif;
    }
    public int getRentalNumber() {
        return rentalNumber;
    }
    public void setRentalNumber(int rNum) {
        this.rentalNumber = rNum;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getuID() {
        return uID;
    }
}
