package libms;

//#region IMPORTS
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
    private JPanel mainPanel, buttonsPanel;
    private JButton findStudentButton, findRentalButton, updateInventoryButton;
    private LibraryConstraints frameCons, mainCons;
    private LibraryConstraints[] cons;
    private JButton[] buttons;
    private int currentScreen, lastScreen;
    // #endregion

    public AdminPanel() {
        this.frame = new JFrame();
        this.mainPanel = new JPanel();
        this.buttonsPanel = new JPanel();
        this.findStudentButton = new JButton("Search for student");
        this.findRentalButton = new JButton("Search for rental");
        this.updateInventoryButton = new JButton("Update Library Inventory");
        this.frameCons = new LibraryConstraints();
        this.mainCons = new LibraryConstraints();
        this.cons = new LibraryConstraints[] { this.frameCons, this.mainCons};
        this.buttons = new JButton[] { this.findStudentButton, this.findRentalButton, this.updateInventoryButton };
        this.currentScreen = Consts.ADMIN_PANEL;
        this.lastScreen = Consts.MAIN_MENU;
        objects.add(this);
    }

    public void go() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("DBMU Library");
        this.frame.setLayout(new GridBagLayout());
        mainPanel.setLayout(new GridBagLayout());
        buttonsPanel.setLayout(new BoxLayout(this.buttonsPanel, BoxLayout.X_AXIS));
        new AdminMenuBar(this.frame);
        for (LibraryConstraints c  : this.cons) {
            c.insets = new Insets(5, 5, 5, 5);
            c.setGridXY(0, 0);
            c.anchor = GridBagConstraints.CENTER;
        }

        // #region Button Listeners
        findStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminSearchPage(Consts.STUDENT_SEARCH);
            }
        });
        findRentalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // shift to search screen
            }
        });
        updateInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // shift to search screen
            }
        });
        // #endregion

        for (JButton b : this.buttons) {
            b.setSize(b.getWidth(), 50);
            buttonsPanel.add(b);
        }
        mainPanel.add(this.buttonsPanel);

        frame.add(this.mainPanel);
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    @Override
    public void shift(int screen) {
        switch (screen) {
            case Consts.STUDENT_SEARCH:
                AdminPanel ap = new AdminPanel();
                ap.setLastScreen(this.getCurrentScreen());
                ap.go();
                break;
            case Consts.RENTAL_SEARCH:
            
                break;
            case Consts.UPDATE_INVENTORY:
            
                break;
            default:
                System.out.println("Invalid screen shift to screen " + screen + " attempted");
                break;
        }
    }
}
