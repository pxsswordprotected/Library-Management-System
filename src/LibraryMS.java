import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

@SuppressWarnings("unused")
public class LibraryMS {

    public LibraryMS() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Library Management System");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("DBMS Library");
        titlePanel.add(titleLabel);

        JPanel bodyPanel = new JPanel();
        JLabel bodyLabel = new JLabel("Log in to continue.");
        bodyPanel.add(bodyLabel);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        setGridXY(constraints, 0, 0);

        JLabel userNameLabel = new JLabel("Enter your username");
        JLabel pwdLabel = new JLabel("Enter your password");
        
        JTextField userNameField = new JTextField(20);
        JPasswordField pwdField = new JPasswordField(20);

        buttonsPanel.add(userNameLabel, constraints);
        constraints.gridx = 1;
        buttonsPanel.add(userNameField, constraints);
        setGridXY(constraints, 0, 3);
        
        buttonsPanel.add(pwdLabel, constraints);
        constraints.gridx = 1;
        buttonsPanel.add(pwdField, constraints);
        setGridXY(constraints, 0, 4);
        
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;


        JButton studentButton = new JButton("Student Login");
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bodyLabel.setText("Enter your student ID and password");

            }
        });

        buttonsPanel.add(studentButton, constraints);

        mainPanel.add(titlePanel);
        mainPanel.add(bodyPanel);
        mainPanel.add(buttonsPanel);
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void setGridXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }

    public static void main(String[] args) {
        new LibraryMS();
    }

}