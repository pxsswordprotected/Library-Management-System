package userobjects;

import userobjects.Rental;

/**
 *
 * @author Grant Swift
 */
public class Student extends Person {
    private int classification;
    private int rentalNumber;

    public final int UNDEFINED = 0;
    public final int FRESHMAN = 1;
    public final int SOPHMORE = 2;
    public final int JUNIOR = 3;
    public final int SENIOR = 4;

    public Student(int sID, String name, String email, int classif) {
        super(sID, name, email);
        this.classification = classif;
    }
    public Student() {
        new Student(000000000, null, null, UNDEFINED);
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
}
