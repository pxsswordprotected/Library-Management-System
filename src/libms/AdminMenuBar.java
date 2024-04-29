package libms;

//#region IMPORTS
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
//#endregion

/**
 *
 * @author Grant Swift
 */
public class AdminMenuBar extends AdminPanel {

    // #region Instance Variables
    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu fileMenu, addInvItemMenu;
    private JMenuItem addStudentItem, addRentalItem, addBookItem, addMovieItem;
    // #endregion

    public AdminMenuBar(JFrame frame) {
        this.frame = frame;
        this.menuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.addStudentItem = new JMenuItem("New Student");
        this.addRentalItem = new JMenuItem("New Rental");
        this.addInvItemMenu = new JMenu("Add to inventory");
        this.addBookItem = new JMenuItem("New Book");
        this.addMovieItem = new JMenuItem("New Movie");
        this.go();
    }

    public void go() {
        fileMenu.add(addStudentItem);
        fileMenu.add(addRentalItem);
        fileMenu.add(addInvItemMenu);
        addInvItemMenu.add(addBookItem);
        addInvItemMenu.add(addMovieItem);

        addStudentItem.addActionListener(new NewStudentListener());
        addRentalItem.addActionListener(new NewRentalListener());
        addBookItem.addActionListener(new NewBookListener());
        addMovieItem.addActionListener(new NewMovieListener());

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    class NewStudentListener implements ActionListener {
        private JDialog addStudent;
        private JPanel textPanel, fieldPanel, mainPanel, buttonPanel;
        private JLabel studentID, studentPassword, studentFName, studentLName, studentEmail;
        private JTextField sIDField, sPwdField, sFNField, sLNField, sEmlField;
        private JLabel[] labels;
        private JTextField[] fields;
        private JButton create, cancel;
        private LibraryConstraints frameCons, mainCons, fieldCons, textCons, buttonCons;
        private LibraryConstraints[] constraints;

        public NewStudentListener() {
            this.addStudent = new JDialog(getFrame());
            this.mainPanel = new JPanel();
            this.textPanel = new JPanel();
            this.fieldPanel = new JPanel();
            this.buttonPanel = new JPanel();
            this.studentEmail = new JLabel("Email: ");
            this.studentPassword = new JLabel("Password: ");
            this.studentID = new JLabel("Student ID: ");
            this.studentFName = new JLabel("First Name: ");
            this.studentLName = new JLabel("Last Name: ");
            this.sEmlField = new JTextField(10);
            this.sFNField = new JTextField(10);
            this.sIDField = new JTextField(10);
            this.sLNField = new JTextField(10);
            this.sPwdField = new JTextField(10);
            this.create = new JButton("Create Student");
            this.cancel = new JButton("Cancel");
            this.frameCons = new LibraryConstraints();
            this.mainCons = new LibraryConstraints();
            this.textCons = new LibraryConstraints();
            this.fieldCons = new LibraryConstraints();
            this.buttonCons = new LibraryConstraints();

            this.labels = new JLabel[] { this.studentFName, this.studentLName, this.studentID, this.studentEmail, this.studentPassword };
            this.fields = new JTextField[] { this.sFNField, this.sLNField, this.sIDField, this.sEmlField, this.sPwdField };
            this.constraints = new LibraryConstraints[] { this.frameCons, this.mainCons, this.textCons, this.fieldCons, this.buttonCons };
        }

        public void actionPerformed(ActionEvent e) {
            addStudent.setTitle("New Student");
            addStudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addStudent.setLayout(new GridBagLayout());
            mainPanel.setLayout(new GridBagLayout());
            textPanel.setLayout(new GridBagLayout());
            fieldPanel.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());

            for (LibraryConstraints l : constraints) {
                l.insets = new Insets(5, 5, 5, 5);
                l.setGridXY(0, 0);
            }
            fieldCons.insets = new Insets(5, 5, 5, 0);
            frameCons.anchor = GridBagConstraints.CENTER;
            mainCons.anchor = GridBagConstraints.CENTER;
            fieldCons.anchor = GridBagConstraints.LINE_END;
            textCons.anchor = GridBagConstraints.LINE_START;
            buttonCons.anchor = GridBagConstraints.CENTER;

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addStudent.dispose();
                }
            });

            mainPanel.add(fieldPanel, mainCons);
            buttonPanel.add(create, buttonCons);
            buttonCons.setGridXY(1, 0);
            buttonPanel.add(cancel, buttonCons);

            for (int i = 0; i < labels.length; i++) {
                fieldCons.setGridXY(1, i);
                textCons.gridy = i;
                fieldPanel.add(labels[i], textCons);
                fieldPanel.add(fields[i], fieldCons);
            }

            addStudent.add(mainPanel, frameCons);
            frameCons.setGridXY(0, 1);
            addStudent.add(buttonPanel, frameCons);
            addStudent.pack();
            addStudent.validate();
            addStudent.setSize(280, 300);
            addStudent.setResizable(true);
            addStudent.setVisible(true);
        }
    }

    class NewRentalListener implements ActionListener {
        private JDialog addRental;
        private JPanel textPanel, fieldPanel, mainPanel, buttonPanel;
        private JLabel rentNum, returnDate, studentID, currentDate;
        private JTextField renField, retField, sIDField, curField;
        private JLabel[] labels;
        private JTextField[] fields;
        private JButton create, cancel;
        private LibraryConstraints frameCons, mainCons, fieldCons, textCons, buttonCons;
        private LibraryConstraints[] contraints;

        public NewRentalListener() {
            this.addRental = new JDialog(getFrame());
            this.mainPanel = new JPanel();
            this.textPanel = new JPanel();
            this.fieldPanel = new JPanel();
            this.buttonPanel = new JPanel();
            this.rentNum = new JLabel("Rental Number: ");
            this.returnDate = new JLabel("Return By: ");
            this.studentID = new JLabel("Student ID: ");
            this.currentDate = new JLabel("Current Date: ");
            this.renField = new JTextField(10);
            this.retField = new JTextField(10);
            this.sIDField = new JTextField(10);
            this.curField = new JTextField(10);
            this.create = new JButton("Create Rental");
            this.cancel = new JButton("Cancel");
            this.frameCons = new LibraryConstraints();
            this.mainCons = new LibraryConstraints();
            this.textCons = new LibraryConstraints();
            this.fieldCons = new LibraryConstraints();
            this.buttonCons = new LibraryConstraints();

            this.labels = new JLabel[] { this.rentNum, this.returnDate, this.studentID, this.currentDate };
            this.fields = new JTextField[] { this.renField, this.retField, this.sIDField, this.curField };
            this.contraints = new LibraryConstraints[] { frameCons, mainCons, textCons, fieldCons, buttonCons };
        }

        public void actionPerformed(ActionEvent e) {
            addRental.setTitle("New Rental");
            addRental.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addRental.setLayout(new GridBagLayout());
            mainPanel.setLayout(new GridBagLayout());
            textPanel.setLayout(new GridBagLayout());
            fieldPanel.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());

            for (LibraryConstraints l : contraints) {
                l.insets = new Insets(5, 5, 5, 5);
                l.setGridXY(0, 0);
            }
            fieldCons.insets = new Insets(5, 5, 5, 0);
            frameCons.anchor = GridBagConstraints.CENTER;
            mainCons.anchor = GridBagConstraints.CENTER;
            fieldCons.anchor = GridBagConstraints.LINE_END;
            textCons.anchor = GridBagConstraints.LINE_START;
            buttonCons.anchor = GridBagConstraints.CENTER;

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addRental.dispose();
                }
            });

            mainPanel.add(fieldPanel, mainCons);
            buttonPanel.add(create, buttonCons);
            buttonCons.setGridXY(1, 0);
            buttonPanel.add(cancel, buttonCons);

            for (int i = 0; i < labels.length; i++) {
                fieldCons.setGridXY(1, i);
                textCons.gridy = i;
                fieldPanel.add(labels[i], textCons);
                fieldPanel.add(fields[i], fieldCons);
            }

            addRental.add(mainPanel, frameCons);
            frameCons.setGridXY(0, 1);
            addRental.add(buttonPanel, frameCons);
            addRental.pack();
            addRental.validate();
            addRental.setSize(280, 300);
            addRental.setResizable(true);
            addRental.setVisible(true);
        }
    }

    class NewBookListener implements ActionListener {
        private JDialog addBook;
        private JPanel textPanel, fieldPanel, mainPanel, buttonPanel;
        private JLabel title, genre, year, publisher, author, isbn;
        private JTextField tField, gField, yField, pField, aField, iField;
        private JLabel[] labels;
        private JTextField[] fields;
        private JButton create, cancel;
        private LibraryConstraints frameCons, mainCons, fieldCons, textCons, buttonCons;
        private LibraryConstraints[] contraints;

        public NewBookListener() {
            this.addBook = new JDialog(getFrame());
            this.mainPanel = new JPanel();
            this.textPanel = new JPanel();
            this.fieldPanel = new JPanel();
            this.buttonPanel = new JPanel();
            this.title = new JLabel("Title: ");
            this.genre = new JLabel("Genre: ");
            this.year = new JLabel("Year: ");
            this.publisher = new JLabel("Publisher: ");
            this.author = new JLabel("Author: ");
            this.isbn = new JLabel("ISBN: ");
            this.tField = new JTextField(10);
            this.gField = new JTextField(10);
            this.yField = new JTextField(10);
            this.pField = new JTextField(10);
            this.aField = new JTextField(10);
            this.iField = new JTextField(10);
            this.create = new JButton("Create Book");
            this.cancel = new JButton("Cancel");
            this.frameCons = new LibraryConstraints();
            this.mainCons = new LibraryConstraints();
            this.textCons = new LibraryConstraints();
            this.fieldCons = new LibraryConstraints();
            this.buttonCons = new LibraryConstraints();

            this.labels = new JLabel[] { this.title, this.author, this.genre, this.year, this.publisher, this.isbn };
            this.fields = new JTextField[] { this.tField, this.aField, this.gField, this.yField, this.pField,
                    this.iField };
            this.contraints = new LibraryConstraints[] { frameCons, mainCons, textCons, fieldCons, buttonCons };
        }

        public void actionPerformed(ActionEvent e) {
            addBook.setTitle("Add New Book");
            addBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addBook.setLayout(new GridBagLayout());
            mainPanel.setLayout(new GridBagLayout());
            textPanel.setLayout(new GridBagLayout());
            fieldPanel.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());

            for (LibraryConstraints l : contraints) {
                l.insets = new Insets(5, 5, 5, 5);
                l.setGridXY(0, 0);
            }
            fieldCons.insets = new Insets(0, 5, 0, 0);
            frameCons.anchor = GridBagConstraints.CENTER;
            mainCons.anchor = GridBagConstraints.CENTER;
            fieldCons.anchor = GridBagConstraints.LINE_END;
            textCons.anchor = GridBagConstraints.LINE_START;
            buttonCons.anchor = GridBagConstraints.CENTER;

            mainPanel.add(fieldPanel, mainCons);

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addBook.dispose();
                }
            });

            buttonPanel.add(create, buttonCons);
            buttonCons.setGridXY(1, 0);
            buttonPanel.add(cancel, buttonCons);

            for (int i = 0; i < labels.length; i++) {
                fieldCons.setGridXY(1, i);
                textCons.gridy = i;
                fieldPanel.add(labels[i], textCons);
                fieldPanel.add(fields[i], fieldCons);
            }

            addBook.add(mainPanel, frameCons);
            frameCons.setGridXY(0, 1);
            addBook.add(buttonPanel, frameCons);
            addBook.pack();
            addBook.validate();
            addBook.setSize(280, 300);
            addBook.setResizable(true);
            addBook.setVisible(true);
        }
    }

    class NewMovieListener implements ActionListener {
        private JDialog addMovie;
        private JPanel textPanel, fieldPanel, mainPanel, buttonPanel;
        private JLabel title, genre, year, producer, director, isan;
        private JTextField tField, gField, yField, pField, dField, iField;
        private JLabel[] labels;
        private JTextField[] fields;
        private JButton create, cancel;
        private LibraryConstraints frameCons, mainCons, fieldCons, textCons, buttonCons;
        private LibraryConstraints[] contraints;

        public NewMovieListener() {
            this.addMovie = new JDialog(getFrame());
            this.mainPanel = new JPanel();
            this.textPanel = new JPanel();
            this.fieldPanel = new JPanel();
            this.buttonPanel = new JPanel();
            this.title = new JLabel("Title: ");
            this.genre = new JLabel("Genre: ");
            this.year = new JLabel("Year: ");
            this.producer = new JLabel("Producer: ");
            this.director = new JLabel("Director: ");
            this.isan = new JLabel("ISAN: ");
            this.tField = new JTextField(10);
            this.gField = new JTextField(10);
            this.yField = new JTextField(10);
            this.pField = new JTextField(10);
            this.dField = new JTextField(10);
            this.iField = new JTextField(10);
            this.create = new JButton("Create Movie");
            this.cancel = new JButton("Cancel");
            this.frameCons = new LibraryConstraints();
            this.mainCons = new LibraryConstraints();
            this.textCons = new LibraryConstraints();
            this.fieldCons = new LibraryConstraints();
            this.buttonCons = new LibraryConstraints();

            this.labels = new JLabel[] { this.title, this.director, this.genre, this.year, this.producer, this.isan };
            this.fields = new JTextField[] { this.tField, this.dField, this.gField, this.yField, this.pField,
                    this.iField };
            this.contraints = new LibraryConstraints[] { frameCons, mainCons, textCons, fieldCons, buttonCons };
        }

        public void actionPerformed(ActionEvent e) {
            addMovie.setTitle("Add New Movie");
            addMovie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addMovie.setLayout(new GridBagLayout());
            mainPanel.setLayout(new GridBagLayout());
            textPanel.setLayout(new GridBagLayout());
            fieldPanel.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());

            for (LibraryConstraints l : contraints) {
                l.insets = new Insets(5, 5, 5, 5);
                l.setGridXY(0, 0);
            }
            fieldCons.insets = new Insets(0, 5, 0, 0);
            frameCons.anchor = GridBagConstraints.CENTER;
            mainCons.anchor = GridBagConstraints.CENTER;
            fieldCons.anchor = GridBagConstraints.LINE_END;
            textCons.anchor = GridBagConstraints.LINE_START;
            buttonCons.anchor = GridBagConstraints.CENTER;

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addMovie.dispose();
                }
            });

            mainPanel.add(fieldPanel, mainCons);
            buttonPanel.add(create, buttonCons);
            buttonCons.setGridXY(1, 0);
            buttonPanel.add(cancel, buttonCons);

            for (int i = 0; i < labels.length; i++) {
                fieldCons.setGridXY(1, i);
                textCons.gridy = i;
                fieldPanel.add(labels[i], textCons);
                fieldPanel.add(fields[i], fieldCons);
            }

            addMovie.add(mainPanel, frameCons);
            frameCons.setGridXY(0, 1);
            addMovie.add(buttonPanel, frameCons);
            addMovie.pack();
            addMovie.validate();
            addMovie.setSize(280, 300);
            addMovie.setResizable(true);
            addMovie.setVisible(true);
        }
    }
}
