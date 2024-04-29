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

    // #region Instance Variables
    private JFrame frame;
    private JPanel mainPanel;
    private JButton findStudentButton, findRentalButton, updateInventoryButton;
    private LibraryConstraints frameCons, mainCons, buttonCons;
    private LibraryConstraints[] cons;
    private JButton[] buttons;
    // #endregion

    public AdminPanel() {
        this.frame = new JFrame();
        this.mainPanel = new JPanel();
        this.findStudentButton = new JButton("Search for student");
        this.findRentalButton = new JButton("Search for rental");
        this.updateInventoryButton = new JButton("Update Library Inventory");
        this.frameCons = new LibraryConstraints();
        this.mainCons = new LibraryConstraints();
        this.buttonCons = new LibraryConstraints();
        this.cons = new LibraryConstraints[] { this.frameCons, this.mainCons, this.buttonCons };
        this.buttons = new JButton[] { this.findStudentButton, this.findRentalButton, this.updateInventoryButton };
    }

    public void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DBMU Library");
        frame.setLayout(new GridBagLayout());
        mainPanel.setLayout(new GridBagLayout());
        new AdminMenuBar(this.frame);
        for (LibraryConstraints c  : this.cons) {
            c.insets = new Insets(5, 5, 5, 5);
            c.setGridXY(0, 0);
            c.anchor = GridBagConstraints.CENTER;
        }

        // #region Button Listeners
        findRentalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // shift to search screen
            }
        });
        findStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // shift to search screen
            }
        });
        findRentalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // shift to search screen
            }
        });
        // #endregion

        for (JButton b : this.buttons) {
            buttonCons.weighty = 1.0;
            mainPanel.add(b, this.buttonCons);
            buttonCons.gridx++;
        }
        buttonCons.setGridXY(0, 0);

        frame.add(this.mainPanel);
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
