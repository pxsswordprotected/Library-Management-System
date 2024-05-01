package libms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Grant Swift
 */
public class AdminPanel extends LibraryGUI {

    // #region Instance Variables
    private JFrame frame;
    private JPanel mainPanel, buttonsPanel;
    private JButton findStudentButton, findRentalButton, updateInventoryButton;
    private LibraryConstraints frameCons, mainCons;
    private LibraryConstraints[] cons;
    private JButton[] buttons;
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
                new AdminSearchPage(Consts.RENTAL_SEARCH);
            }
        });
        updateInventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
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

    public class UpdateInventoryListener implements ActionListener {
        
        

        public UpdateInventoryListener() {

        }
        
        public void actionPerformed(ActionEvent e) {

        }
    }
}
