package objecthandlers;

import userobjects.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQLUtil;

public class StudentHandler {
    private SQLUtil sqlUtil;

    public StudentHandler() {
        sqlUtil = new SQLUtil();
    }

    public int addStudent(Student student) {
        String cmdTemplate = "INSERT INTO Student(uID, name, email, password, Classification) VALUES (%d, '%s', '%s', '%s', %d)";
        String stmStr = String.format(cmdTemplate, student.getuID(), student.getName(), student.getEmail(), student.getPassword(), student.getClassification());
        return sqlUtil.executeUpdate(stmStr);
    }

    public int deleteStudent(int uID) {
        String stm = String.format("DELETE FROM Student WHERE uID = %d", uID);
        return sqlUtil.executeUpdate(stm);
    }

    public int updateStudent(Student student) {
        String cmdTemplate = "UPDATE Student SET name='%s', email='%s', password='%s', Classification=%d WHERE uID=%d";
        String stmStr = String.format(cmdTemplate, student.getName(), student.getEmail(), student.getPassword(), student.getClassification(), student.getuID());
        return sqlUtil.executeUpdate(stmStr);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try {
            ResultSet resultSet = sqlUtil.executeQuery(query);
            while (resultSet.next()) {
                int uID = resultSet.getInt("uID");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int classification = resultSet.getInt("Classification");
                students.add(new Student(uID, name, email, password, classification));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public boolean login(String userName, String password) {
        String query = "SELECT * FROM Student WHERE userName = '" + userName + "' AND password = '" + password + "'";
        try {
            ResultSet resultSet = sqlUtil.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }

    public SQLUtil getSqlUtil() {
        return this.sqlUtil;
    }
}