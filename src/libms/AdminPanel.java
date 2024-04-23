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
@SuppressWarnings("unused")
public class AdminPanel extends LibraryGUI {
    
    //#region Instance Variables
    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu addInvItemMenu;
    private JMenuItem addStudentItem, addRentalItem;
    private JMenuItem addBookItem, addMovieItem;

    private JPanel mainPanel;

    private JButton findStudentButton;
    private JButton findRentalButton;
    //#endregion
    
    public AdminPanel() {
        this.frame = new JFrame();
        this.menuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.addStudentItem = new JMenuItem("New Student");
        this.addRentalItem = new JMenuItem("New Rental");
        this.addInvItemMenu = new JMenu("Add to inventory");
        this.addBookItem = new JMenuItem("New Book");
        this.addMovieItem = new JMenuItem("New Movie");
        this.mainPanel = new JPanel();
    }
    
    public void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DBMU Library");
        frame.setLayout(new GridLayout(1, 1));
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
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    class NewStudentListener implements ActionListener {
        private JPopupMenu addStudent;
        public void actionPerformed(ActionEvent e) {
            // add new student popup menu
        }
    }
    class NewRentalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // add new rental popup menu
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
        private LibraryConstraints frameCons, mainCons, textCons, fieldCons, buttonCons; 

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

            this.labels = new JLabel[]{this.title, this.author, this.genre, this.year, this.publisher, this.isbn};
            this.fields = new JTextField[]{this.tField, this.aField, this.gField, this.yField, this.pField, this.iField};
        }

        public void actionPerformed(ActionEvent e) {
            addBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addBook.setLayout(new GridLayout(1, 0));
            mainPanel.setLayout(new GridBagLayout());
            textPanel.setLayout(new GridBagLayout());
            fieldPanel.setLayout(new GridBagLayout());
            buttonPanel.setLayout(new GridBagLayout());

            mainCons.setGridXY(0, 0);
            mainCons.anchor = GridBagConstraints.CENTER;
            mainCons.insets = new Insets(5, 5, 5, 5);

            textCons.setGridXY(0, 0);
            textCons.anchor = GridBagConstraints.LINE_START;
            textCons.insets = new Insets(5, 5, 5, 5);

            fieldCons.setGridXY(0, 0);
            fieldCons.anchor = GridBagConstraints.LINE_END;
            fieldCons.insets = new Insets(5, 5, 5, 5);

            buttonCons.setGridXY(0, 0);
            buttonCons.anchor = GridBagConstraints.CENTER;
            buttonCons.insets = new Insets(5, 5, 5, 5);

            mainPanel.add(textPanel, mainCons);
            mainCons.setGridXY(1, 0);
            mainPanel.add(fieldPanel, mainCons);

            buttonPanel.add(create, buttonCons);
            buttonCons.setGridXY(1, 0);
            buttonPanel.add(cancel, buttonCons);

            for (int i = 0; i < 6; i++) {
                textCons.gridy = i;
                fieldCons.gridy = i;
                textPanel.add(labels[i]);
                fieldPanel.add(fields[i]);
            }

            addBook.add(mainPanel);
            frameCons.setGridXY(0, 1);
            addBook.add(buttonPanel, frameCons);
            addBook.pack();
            addBook.validate();
            addBook.setSize(200, 300);
            addBook.setResizable(true);
            addBook.setVisible(true);
        }
    }
    class NewMovieListener implements ActionListener {
        private JPopupMenu addMovie;

        public void actionPerformed(ActionEvent e) {
            // add new movie popup menu
        }
    }
}
