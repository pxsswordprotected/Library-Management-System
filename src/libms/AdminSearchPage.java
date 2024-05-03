package libms;


//#region
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import objecthandlers.*;
import userobjects.*;
import utils.SQLUtil;
//#endregion


/**
 *
 * @author Grant Swift
 */
public class AdminSearchPage extends LibraryGUI {

    // #region
    private JFrame frame;
    private JLabel head;
    private JPanel panel;
    private LibraryConstraints cons;
    private JButton search, back;
    private JTextField input;
    private JScrollPane scrollPane;
    private JTable result;
    private String[] tableColumns;
    private List<Student> studentData;
    private List<Rental> rentalData;
    // #endregion

    /**
     * @param sT
     */
    public AdminSearchPage(int sT) {
        this.frame = new JFrame();
        this.head = new JLabel();

        this.panel = new JPanel(new GridBagLayout());
        this.cons = new LibraryConstraints();

        this.search = new JButton("Search");
        this.back = new JButton("<html>&lt Return</html>");
            this.back.setFocusPainted(false);
            this.back.setMargin(new Insets(0, 0, 0, 0));
            this.back.setContentAreaFilled(false);
            this.back.setBorderPainted(false);
            this.back.setOpaque(false);
            this.back.setHorizontalAlignment(SwingConstants.LEFT);
            this.back.addActionListener(new BackButton());
            this.back.addMouseListener(new BackButton());
        this.result = new JTable();
        this.scrollPane = new JScrollPane(this.result);
        this.input = new JTextField(30);

        this.go(sT);
    }

    public void go(int sT) {

        switch (sT) {
            case Consts.STUDENT_SEARCH:
                this.setCurrentScreen(Consts.STUDENT_SEARCH);
                this.tableColumns = new String[]{"Student ID", "Name", "Classification", "Email", "Rental #"};

                frame.setTitle("Student Search");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                cons.anchor = GridBagConstraints.FIRST_LINE_START;             // RETURN BUTTON
                cons.insets = new Insets(5, 10, 0, 0);
                cons.weighty = 0.1;
                cons.weightx = 0.20;
                cons.setGridXY(0, 0);
                panel.add(this.back, this.cons);

                cons.anchor = GridBagConstraints.CENTER;                 // HEADER TEXT
                cons.insets = new Insets(5, 0, 0, 0);
                cons.setGridXY(1, 0);
                cons.weightx = 0.55;
                cons.ipadx = 25;
                head.setText("<html><B>Search for student</B></html>");
                panel.add(this.head, this.cons);

                cons.setGridXY(0, 1);                                    // SEARCH TEXT FIELD
                cons.weighty = 0.25;
                cons.weightx = 0.75;
                cons.ipadx = 5;
                cons.gridwidth = 2;
                cons.insets = new Insets(5, 15, 0, 0);
                panel.add(this.input, this.cons);

                cons.setGridXY(2, 1);                                    // SEARCH BUTTON
                cons.gridwidth = 0;
                cons.weightx = 0.25;
                cons.anchor = GridBagConstraints.LINE_END;
                cons.insets = new Insets(5, 0, 0, 15);
                panel.add(this.search, this.cons);

                cons.setGridXY(0,2);                                     // RESULTS PANE
                cons.weighty = 0.65;
                cons.ipady = 30;
                cons.anchor = GridBagConstraints.CENTER;
                cons.gridwidth = 3;
                cons.insets = new Insets(5,15,15,15);
                panel.add(this.scrollPane, this.cons);

                frame.add(this.panel);
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
                break;

            case Consts.RENTAL_SEARCH:
                this.setCurrentScreen(Consts.RENTAL_SEARCH);
                this.tableColumns = new String[]{"Rental #", "Assigned Student", "Due Date"};

                frame.setTitle("Rental Search");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                cons.anchor = GridBagConstraints.FIRST_LINE_START;             // RETURN BUTTON
                cons.insets = new Insets(5, 10, 0, 0);
                cons.weighty = 0.1;
                cons.weightx = 0.20;
                cons.setGridXY(0, 0);
                panel.add(this.back, this.cons);

                cons.anchor = GridBagConstraints.CENTER;                 // HEADER TEXT
                cons.insets = new Insets(5, 0, 0, 0);
                cons.setGridXY(1, 0);
                cons.weightx = 0.55;
                cons.ipadx = 25;
                head.setText("<html><B>Search all rentals</B></html>");
                panel.add(this.head, this.cons);

                cons.setGridXY(0, 1);                                    // SEARCH TEXT FIELD
                cons.weighty = 0.25;
                cons.weightx = 0.75;
                cons.ipadx = 5;
                cons.gridwidth = 2;
                cons.insets = new Insets(5, 15, 0, 0);
                panel.add(this.input, this.cons);

                cons.setGridXY(2, 1);                                    // SEARCH BUTTON
                cons.gridwidth = 0;
                cons.weightx = 0.25;
                cons.anchor = GridBagConstraints.LINE_END;
                cons.insets = new Insets(5, 0, 0, 15);
                panel.add(this.search, this.cons);

                cons.setGridXY(0,2);                                     // RESULTS PANE
                cons.weighty = 0.65;
                cons.ipady = 30;
                cons.anchor = GridBagConstraints.CENTER;
                cons.gridwidth = 3;
                cons.insets = new Insets(5,15,15,15);
                panel.add(this.scrollPane, this.cons);

                frame.add(this.panel);
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
                break;

            default:
                System.out.println("You should not be calling an admin search menu from this page.");
                break;
        }
    }

    public class AdminSearchButton implements ActionListener {
        private int searchType;
        public AdminSearchButton(int sT){
            this.searchType = sT;
        }
        
        public void actionPerformed(ActionEvent e) {
            String query;
            String searchVal;
            Object[][] res;
            Object[] data;
            Student stu;
            Rental ren;
            switch (searchType) {
                case STUDENT_SEARCH:
                    StudentHandler stuHandler = new StudentHandler();
                    searchVal = input.getText();
                    query = String.format("SELECT * FROM Student WHERE name = %s ", searchVal);
                    res = new Object[studentData.size()][5];
                    try {
                        ResultSet resultSet = stuHandler.getSqlUtil().executeQuery(query);
                        while (resultSet.next()) {
                            int uID = resultSet.getInt("uID");
                            String name = resultSet.getString("name");
                            String email = resultSet.getString("email");
                            String password = resultSet.getString("password");
                            int classification = resultSet.getInt("Classification");
                            studentData.add(new Student(uID, name, email, password, classification));
                        }
                        for (int i = 0; i < studentData.size(); i++) {
                            stu = studentData.get(i);
                            data = new Object[]{stu.getuID(), stu.getName(), stu.getClassification(), stu.getEmail(), stu.getRentalNumber()};
                            for (int k = 0; k < 5; k++) {
                                res[i][k] = data[k];
                            }
                        }
                    } catch (SQLException e1) {
                        Logger.getLogger(AdminSearchButton.class.getName()).log(Level.SEVERE, null, e1);
                    }
                    result = new JTable(res, tableColumns);
                    break;
            
                case RENTAL_SEARCH:
                    RentalHandler renHandler = new RentalHandler();
                    searchVal = input.getText();
                    query = String.format("SELECT * FROM Rental WHERE name = %s ", searchVal);
                    res = new Object[rentalData.size()][3];
                    try {
                        ResultSet resultSet = renHandler.getSqlUtil().executeQuery(query);
                        while (resultSet.next()) {
                            int rNo = resultSet.getInt("uID");
                            double lateFee = resultSet.getDouble("lateFee");
                            Date rentalDate = resultSet.getDate("rentalDate");
                            Date dueDate = resultSet.getDate("dueDate");
                            Date returnedDate = resultSet.getDate("returnedDate");
                            int studentID = resultSet.getInt("sUID");
                            int staffID = resultSet.getInt("stfUID");
                            rentalData.add(new Rental(rNo, lateFee, rentalDate, dueDate, returnedDate, studentID, staffID));
                        }
                        for (int i = 0; i < rentalData.size(); i++) {
                            ren = rentalData.get(i);
                            data = new Object[]{ren.getRentalNumber(), ren.getLateFee(), ren.getRentalDate(), ren.getReturnDate(), ren.getReturnedDate(), ren.getStudentID(), ren.getStaffID()};
                            for (int k = 0; k < 7; k++) {
                                res[i][k] = data[k];
                            }
                        }
                    } catch (SQLException e1) {
                        Logger.getLogger(AdminSearchButton.class.getName()).log(Level.SEVERE, null, e1);
                    }
                    result = new JTable(res, tableColumns);
                    break;
            }
        }
    }

    public class BackButton implements MouseListener, ActionListener {
        public void mouseEntered(MouseEvent evt) {
            back.setText("<html>&lt <u>Return</u></html>");
        }
        public void mouseExited(MouseEvent evt) {
            back.setText("<html>&lt Return</html>");
        }
        public void mousePressed(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
