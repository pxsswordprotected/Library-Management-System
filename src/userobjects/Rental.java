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

    public final double interestRate = 0.70; // daily charge for each day past returnDate

    public Rental(int rNum, double ltFee, double iRate, Date rentDate, Date retDate, Date retdDate) {
        this.rentalNumber = rNum;
        this.lateFee = ltFee;
        this.rentalDate = rentDate;
        this.returnDate = retDate;
        this.returnedDate = retdDate;
    }
    public Rental() {
        this.rentalNumber = 000000000;
        this.lateFee = 0.0;
        this.rentalDate = new Date();
        this.returnDate = new Date();
        this.returnedDate = new Date();
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
