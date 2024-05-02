package objecthandlers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import userobjects.Rental;
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

    
}
