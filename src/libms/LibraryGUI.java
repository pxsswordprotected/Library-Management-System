package libms;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import objecthandlers.BookHandler;
import objecthandlers.StaffHandler;
import objecthandlers.StudentHandler;

/**
 *
 * @author Grant Swift
 */
public class LibraryGUI {

    private JFrame frame;
    private JPanel mainPanel, titlePanel, buttonsPanel, loginPanel, loginButtonPanel;
    private JButton backButton, studentButton, staffButton, loginButton;
    private JLabel titleLabel, usrLabel, pwdLabel, loginLabel, loginStatusLabel;
    private LibraryConstraints mainConstraints, loginConstraints, buttonConstraints;
    private JTextField usrField;
    private JPasswordField pwdField;
    private int currentScreen, lastScreen;
    private BookHandler bookHandler;


    public LibraryGUI() {

        bookHandler = new BookHandler();



        this.frame = new JFrame();
        this.mainPanel = new JPanel();
        this.titlePanel = new JPanel();
        this.titleLabel = new JLabel("", JLabel.CENTER);
        this.buttonsPanel = new JPanel();
        this.loginPanel = new JPanel();
        this.loginButtonPanel = new JPanel();
        this.mainConstraints = new LibraryConstraints();
        this.loginConstraints = new LibraryConstraints();
        this.buttonConstraints = new LibraryConstraints();
        this.loginLabel = new JLabel("", JLabel.CENTER);
        this.usrLabel = new JLabel("");
        this.pwdLabel = new JLabel("");
        this.loginStatusLabel = new JLabel("", JLabel.CENTER);
        this.usrField = new JTextField(20);
        this.pwdField = new JPasswordField(20);
        this.studentButton = new JButton("Student Login");
        this.staffButton = new JButton("Staff Login");
        this.backButton = new JButton("Return to menu");
        this.loginButton = new JButton("Sign in");
        this.currentScreen = Consts.MAIN_MENU;
    }

    public void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DBMU Library");
        mainPanel.setLayout(new GridBagLayout());
        mainConstraints.setGridXY(0, 0);
        mainConstraints.anchor = GridBagConstraints.CENTER;

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titleLabel.setText("Welcome to the Database Management University Library!");
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, mainConstraints);
        mainConstraints.setGridXY(0, 1);
        mainConstraints.insets = new Insets(20, 10, 20, 10);

        buttonsPanel.setLayout(new GridBagLayout());
        loginPanel.setLayout(new GridBagLayout());
        loginButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        loginConstraints.setGridXY(0, 0);
        loginConstraints.anchor = GridBagConstraints.CENTER;

        buttonConstraints.setGridXY(0, 0);
        buttonConstraints.anchor = GridBagConstraints.CENTER;

        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentScreen(Consts.STUDENT_LOGIN);
                buttonsPanel.removeAll();
                mainPanel.remove(buttonsPanel);
                mainPanel.revalidate();
                loginConstraints.insets = new Insets(5, 10, 0, 10);

                loginLabel.setText("Enter your Student ID and password");
                loginConstraints.gridwidth = 2;
                loginPanel.add(loginLabel, loginConstraints);
                loginConstraints.gridwidth = 1;

                usrLabel.setText("Student ID: ");
                usrLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                loginConstraints.setGridXY(0, 1);
                loginPanel.add(usrLabel, loginConstraints);
                loginConstraints.setGridXY(1, 1);
                loginPanel.add(usrField, loginConstraints);

                pwdLabel.setText("  Password: ");
                pwdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                loginConstraints.setGridXY(0, 2);
                loginPanel.add(pwdLabel, loginConstraints);
                loginConstraints.setGridXY(1, 2);
                loginPanel.add(pwdField, loginConstraints);

                loginConstraints.setGridXY(0, 3);
                loginConstraints.gridwidth = 2;
                loginButtonPanel.add(backButton);
                loginButtonPanel.add(loginButton);
                loginPanel.add(loginButtonPanel, loginConstraints);

                mainConstraints.setGridXY(0, 1);
                loginConstraints.setGridXY(0, 0);
                mainPanel.add(loginPanel, mainConstraints);
                mainPanel.revalidate();
                mainPanel.repaint();

            }
        });
        buttonsPanel.add(studentButton, buttonConstraints);
        buttonConstraints.setGridXY(1, 0);

        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentScreen(Consts.STAFF_LOGIN);
                buttonsPanel.removeAll();
                mainPanel.remove(buttonsPanel);
                mainPanel.revalidate();
                loginConstraints.insets = new Insets(5, 10, 0, 10);

                loginLabel.setText("Enter your Staff ID and password");
                loginConstraints.gridwidth = 2;
                loginPanel.add(loginLabel, loginConstraints);
                loginConstraints.gridwidth = 1;

                usrLabel.setText("  Staff ID: ");
                loginConstraints.anchor = GridBagConstraints.LINE_END;
                loginConstraints.setGridXY(0, 1);
                loginPanel.add(usrLabel, loginConstraints);
                loginConstraints.anchor = GridBagConstraints.CENTER;
                loginConstraints.setGridXY(1, 1);
                loginPanel.add(usrField, loginConstraints);

                pwdLabel.setText("  Password: ");
                loginConstraints.anchor = GridBagConstraints.LINE_END;
                loginConstraints.setGridXY(0, 2);
                loginPanel.add(pwdLabel, loginConstraints);
                loginConstraints.anchor = GridBagConstraints.CENTER;
                loginConstraints.setGridXY(1, 2);
                loginPanel.add(pwdField, loginConstraints);

                loginConstraints.setGridXY(0, 3);
                loginConstraints.gridwidth = 2;
                loginButtonPanel.add(backButton);
                loginButtonPanel.add(loginButton);
                loginPanel.add(loginButtonPanel, loginConstraints);

                mainConstraints.setGridXY(0, 1);
                loginConstraints.setGridXY(0, 0);
                loginPanel.revalidate();
                loginPanel.repaint();
                mainPanel.add(loginPanel, mainConstraints);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        buttonsPanel.add(staffButton, buttonConstraints);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentScreen(Consts.MAIN_MENU);
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

                mainConstraints.setGridXY(0, 1);
                mainPanel.add(buttonsPanel, mainConstraints);
                mainPanel.revalidate();
                mainPanel.repaint();

            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginConstraints.setGridXY(0, 4);
                String username = usrField.getText();
                String password = new String(pwdField.getPassword());
                StudentHandler stuhandle = new StudentHandler();
                StaffHandler stfhand = new StaffHandler();

                // Login success (placeholder condition)
                if (stuhandle.login(username, password) == true) {
                    loginStatusLabel.setText("Success! Redirecting...");
                    loginStatusLabel.setForeground(Color.GREEN);
                    shift(Consts.STUDENT_PANEL);
                    frame.dispose();
                }
                else if (stfhand.login(username, password) == true) {
                    loginStatusLabel.setText("Success! Redirecting...");
                    loginStatusLabel.setForeground(Color.GREEN);
                    shift(Consts.ADMIN_PANEL);
                    frame.dispose();
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
        });

        mainPanel.add(buttonsPanel, mainConstraints);
        frame.add(mainPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void shift(int screen) {
        switch (screen) {
            case Consts.ADMIN_PANEL:
                AdminPanel ap = new AdminPanel();
                ap.go();
                break;
            case Consts.STUDENT_PANEL:
                StudentPanel sp = new StudentPanel();
                sp.go();
                break;
            default:
                System.out.println("Invalid screen shift to screen " + screen + " attempted");
                break;
        }
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public int getLastScreen() {
        return this.lastScreen;
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    public void setCurrentScreen(int screen) {
        this.currentScreen = screen;
    }

    public void setLastScreen(int screen) {
        this.lastScreen = screen;
    }

    // Convienience Methods for GridBagConstraints objects
    public class LibraryConstraints extends GridBagConstraints {

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

        public void setup() {
            this.insets = new Insets(5, 5, 5, 5);
            this.setGridXY(0, 0);
            this.anchor = GridBagConstraints.CENTER;
        }

        public void reset() {
            this.insets = new Insets(5, 5, 5, 5);
            this.anchor = GridBagConstraints.CENTER;
        }
    }

    public static void main(String[] args) {
        StaffHandler stf = new StaffHandler();
        stf.addStaff(Consts.admin);
        LibraryGUI gui = new LibraryGUI();
        gui.go();
    }
}