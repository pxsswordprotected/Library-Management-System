import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("unused")
class LibraryMS {

    // #region Instance Variables
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel buttonsPanel;
    private JPanel loginPanel;
    private JPanel usrPanel;
    private JPanel pwdPanel;
    private JPanel loginButtonPanel;
    private JButton backButton;
    private JButton studentButton;
    private JButton staffButton;
    private JButton loginButton;
    private JLabel titleLabel;
    private JLabel usrLabel;
    private JLabel pwdLabel;
    private JLabel loginLabel;
    private JLabel loginStatusLabel;
    private JTextField usrField;
    private JPasswordField pwdField;
    private LibraryConstraints mainConstraints;
    private LibraryConstraints loginConstraints;
    private LibraryConstraints buttonConstraints;
    private int currentScreen;

    // const variables for currentScreen
    private final int MAIN_MENU = 1;
    private final int STUDENT_LOGIN = 2;
    private final int STAFF_LOGIN = 3;

    // custom colors
    private final Color BG_CLR = new Color(46, 44, 48);
    private final Color BUTTON_CLR = new Color(98, 97, 99);


    // #endregion

    private LibraryMS() {
        this.frame = new JFrame();
        this.mainPanel = new JPanel();
        this.titlePanel = new JPanel();
        this.titleLabel = new JLabel("", JLabel.CENTER);
        this.buttonsPanel = new JPanel();
        this.loginPanel = new JPanel();
        this.usrPanel = new JPanel();
        this.pwdPanel = new JPanel();
        this.loginButtonPanel = new JPanel();
        this.mainConstraints = new LibraryConstraints();
        this.loginConstraints = new LibraryConstraints();
        this.buttonConstraints = new LibraryConstraints();
        this.loginLabel = new JLabel("", JLabel.CENTER);
        this.usrLabel = new JLabel("");
        this.pwdLabel = new JLabel("");
        this.loginStatusLabel = new JLabel("");
        this.usrField = new JTextField(20);
        this.pwdField = new JPasswordField(20);
        this.studentButton = new JButton("Student Login");
        this.staffButton = new JButton("Staff Login");
        this.backButton = new JButton("Return to menu");
        this.loginButton = new JButton("Sign in");
        this.currentScreen = MAIN_MENU;
    }

    public static void main(String[] args) {
        LibraryMS gui = new LibraryMS();
        gui.go();
    }

    private void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Library Management System");
        frame.setLayout(new GridLayout(1, 1));
        mainPanel.setLayout(new GridBagLayout());
        mainConstraints.setGridXY(0, 0);
        mainConstraints.anchor = GridBagConstraints.CENTER;

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel.setText("Welcome to the DBM University Library!");
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, mainConstraints);
        mainConstraints.setGridXY(0, 1);
        mainConstraints.insets = new Insets(20, 10, 20, 10);

        buttonsPanel.setLayout(new GridBagLayout());
        loginPanel.setLayout(new GridBagLayout());
        usrPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        pwdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        loginConstraints.setGridXY(0, 0);
        loginConstraints.anchor = GridBagConstraints.CENTER;

        buttonConstraints.setGridXY(0, 0);
        buttonConstraints.anchor = GridBagConstraints.CENTER;

        studentButton.addActionListener(new StudentListener());
        buttonsPanel.add(studentButton, buttonConstraints);
        buttonConstraints.setGridXY(1, 0);

        staffButton.addActionListener(new StaffListener());
        buttonsPanel.add(staffButton, buttonConstraints);

        backButton.addActionListener(new BackListener());
        loginButton.addActionListener(new LoginListener());

        mainPanel.add(buttonsPanel, mainConstraints);
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.getContentPane().setBackground(BG_CLR);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    class StudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentScreen = STUDENT_LOGIN;
            buttonsPanel.removeAll();
            mainPanel.remove(buttonsPanel);
            mainPanel.revalidate();

            loginLabel.setText("Enter your Student ID and password");
            loginPanel.add(loginLabel, loginConstraints);
            usrLabel.setText("Student ID: ");
            usrPanel.add(usrLabel);
            usrPanel.add(usrField);
            pwdLabel.setText("Password:   ");
            pwdPanel.add(pwdLabel);
            pwdPanel.add(pwdField);

            loginConstraints.setGridXY(0, 1);
            loginPanel.add(usrPanel, loginConstraints);

            loginConstraints.setGridXY(0, 2);
            loginPanel.add(pwdPanel, loginConstraints);

            loginConstraints.setGridXY(0, 3);
            loginConstraints.fill = GridBagConstraints.NONE;
            loginButtonPanel.add(backButton, loginConstraints);
            loginButtonPanel.add(loginButton, loginConstraints);
            loginPanel.add(loginButtonPanel, loginConstraints);

            loginConstraints.setGridXY(0, 0);
            mainConstraints.setGridXY(0, 1);
            mainPanel.add(loginPanel, mainConstraints);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    class StaffListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentScreen = STAFF_LOGIN;
            buttonsPanel.removeAll();
            loginPanel.removeAll();
            mainPanel.remove(buttonsPanel);
            mainPanel.revalidate();
            mainPanel.repaint();

            loginLabel.setText("Enter your Staff ID and password");
            loginPanel.add(loginLabel, loginConstraints);
            usrLabel.setText("Staff ID:    ");
            usrPanel.add(usrLabel);
            usrPanel.add(usrField);
            pwdLabel.setText("Password:   ");
            pwdPanel.add(pwdLabel);
            pwdPanel.add(pwdField);

            loginConstraints.setGridXY(0, 1);
            loginPanel.add(usrPanel, loginConstraints);

            loginConstraints.setGridXY(0, 2);
            loginPanel.add(pwdPanel, loginConstraints);

            loginConstraints.setGridXY(0, 3);
            loginConstraints.fill = GridBagConstraints.NONE;
            loginButtonPanel.add(backButton, loginConstraints);
            loginButtonPanel.add(loginButton, loginConstraints);
            loginPanel.add(loginButtonPanel, loginConstraints);

            loginConstraints.setGridXY(0, 0);
            mainConstraints.setGridXY(0, 1);
            mainPanel.add(loginPanel, mainConstraints);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentScreen = MAIN_MENU;
            loginPanel.removeAll();
            loginPanel.revalidate();
            loginPanel.repaint();
            mainPanel.remove(loginPanel);
            mainPanel.revalidate();
            mainPanel.revalidate();

            buttonConstraints.setGridXY(0, 0);
            buttonConstraints.anchor = GridBagConstraints.CENTER;
            buttonsPanel.add(studentButton, buttonConstraints);
            buttonConstraints.setGridXY(1, 0);
            buttonsPanel.add(staffButton, buttonConstraints);
            buttonsPanel.revalidate();
            buttonsPanel.repaint();

            mainConstraints.setGridXY(0,1);
            mainPanel.add(buttonsPanel, mainConstraints);
            mainPanel.revalidate();
            mainPanel.repaint();

        }
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loginConstraints.setGridXY(0, 4);
            // Login success (placeholder condition)
            if (usrField.getText().equals("gas056") && new String(pwdField.getPassword()).equals("1234")) {
                loginStatusLabel.setText("Success! Redirecting...");
                loginStatusLabel.setForeground(Color.GREEN);
                // #region For when i have database access
                switch (currentScreen) {
                    case STUDENT_LOGIN:
                        // send to library database
                        break;

                    case STAFF_LOGIN:
                        // send to admin page
                        break;
                
                    default:
                        // unreachable
                        break;
                }
                // #endregion
            }
            else { // Login failure
                loginStatusLabel.setText("Sign in failed! Double check your User ID/Password.");
                loginStatusLabel.setForeground(Color.RED);
            }
            loginPanel.add(loginStatusLabel, loginConstraints);
            loginConstraints.setGridXY(0, 0);
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    class LibraryConstraints extends GridBagConstraints {

        public void setGridXY(int x, int y) {
            this.gridx = x;
            this.gridy = y;
        }

        public void setGridSize(int w, int h) {
            this.gridwidth = w;
            this.gridheight = h;
        }

        public void setGridWeight(double x, double y) {
            this.weightx = x;
            this.weighty = y;
        }

        public void resetGridWeight() {
            this.weightx = 0.0;
            this.weighty = 0.0;
        }
    }

}