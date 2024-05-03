package objecthandlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import userobjects.Rental;
import userobjects.Student;
import utils.SQLUtil;

public class RentalHandler {
    private SQLUtil sqlUtil;

    public RentalHandler() {
        sqlUtil = new SQLUtil();
    }

    public boolean addRental(Rental rental) {
        String query = "INSERT INTO Rental (rNo, lateFee, interestRate, rentalDate, dueDate, returnedDate, sUID, stfUID) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = sqlUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, rental.getRentalNumber());
            preparedStatement.setDouble(2, rental.getLateFee());
            preparedStatement.setDouble(3, rental.interestRate);
            preparedStatement.setDate(4, new java.sql.Date(rental.getRentalDate().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(rental.getReturnDate().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(rental.getReturnedDate().getTime()));
            preparedStatement.setInt(7, rental.getStudentID());
            preparedStatement.setInt(8, rental.getStaffID());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean removeRental(int rentalNumber) {
        String query = "DELETE FROM Rental WHERE rNo = ?";
        try {
            PreparedStatement preparedStatement = sqlUtil.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, rentalNumber);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Rental> getAllRentals() {
        List<Rental> rentals = new ArrayList<>();
        String query = "SELECT * FROM Rental";
        try {
            ResultSet resultSet = sqlUtil.executeQuery(query);
            while (resultSet.next()) {
                int rNo = resultSet.getInt("uID");
                double lateFee = resultSet.getDouble("lateFee");
                Date rentalDate = resultSet.getDate("rentalDate");
                Date dueDate = resultSet.getDate("dueDate");
                Date returnedDate = resultSet.getDate("returnedDate");
                int studentID = resultSet.getInt("sUID");
                int staffID = resultSet.getInt("stfUID");
                rentals.add(new Rental(rNo, lateFee, rentalDate, dueDate, returnedDate, studentID, staffID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RentalHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rentals;
    }

    public SQLUtil getSqlUtil() {
        return this.sqlUtil;
    }
    
}
