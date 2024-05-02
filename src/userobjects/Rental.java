package userobjects;

import java.util.Date;
import java.util.ArrayList;


/**
 *
 * @author Grant Swift
 */
public class Rental {
    private int rentalNumber;
    private double lateFee;
    private Date rentalDate;
    private Date returnDate;
    private Date returnedDate;
    private ArrayList<Inventory> rentalItems;
    private int studentID; // Associated student ID
    private int staffID;   // Associated staff ID

    public final double interestRate = 0.70; // daily charge for each day past returnDate

    public Rental(int rNum, double ltFee, Date rentDate, Date retDate, Date retdDate, int studentID, int staffID) {
        this.rentalNumber = rNum;
        this.lateFee = ltFee;
        this.rentalDate = rentDate;
        this.returnDate = retDate;
        this.returnedDate = retdDate;
        this.studentID = studentID;
        this.staffID = staffID;
    }
    public Rental() {
        this.rentalNumber = 000000000;
        this.lateFee = 0.0;
        this.rentalDate = new Date();
        this.returnDate = new Date();
        this.returnedDate = new Date();
    }
    //getters and setters
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public int getStaffID() {
        return staffID;
    }
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    public int getRentalNumber() {
        return rentalNumber;
    }
    public void setRentalNumber(int rentalNumber) {
        this.rentalNumber = rentalNumber;
    }
    public double getLateFee() {
        return lateFee;
    }
    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
    public Date getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Date getReturnedDate() {
        return returnedDate;
    }
    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void Rent() {
        for (Inventory i : rentalItems) {
            i.checkOut();
        }
    }
}
