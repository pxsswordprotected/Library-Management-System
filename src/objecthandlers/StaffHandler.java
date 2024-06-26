package objecthandlers;

import userobjects.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQLUtil;

public class StaffHandler {
    private SQLUtil sqlUtil;

    public StaffHandler() {
        sqlUtil = new SQLUtil();
    }

    public boolean login(String userName, String password) {
        String query = "SELECT * FROM Staff WHERE userName = '" + userName + "' AND password = '" + password + "'";
        try {
            ResultSet resultSet = sqlUtil.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    public boolean updateStaffInfo(int uID, String firstName, String lastName, String email) {
        String query = "UPDATE Person SET name = '" + firstName + " " + lastName + "', email = '" + email + "' WHERE uID = " + uID;
        int rowsAffected = sqlUtil.executeUpdate(query);
        if (rowsAffected > 0) {
            return true;
        }
        return false;
    }

    public int addStaff(Staff staff) {
        String cmdTemplate = "INSERT INTO Staff(uID, name, email, userName, password) VALUES (%d, '%s', '%s', '%s', %s)";
        String stmStr = String.format(cmdTemplate, staff.getUserID(), staff.getName(), staff.getEmail(), staff.getUserName(), staff.getPassword());
        return sqlUtil.executeUpdate(stmStr);
    }
}
