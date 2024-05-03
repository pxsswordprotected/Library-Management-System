package libms;

import objecthandlers.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Grant Swift
 */
public class AdminPanel extends LibraryGUI {

    private JFrame frame;
    private JPanel panel;
    private JLabel welcome;
    private JButton studentSearch, rentalSearch;
    private LibraryConstraints cons;

    public AdminPanel() {
        this.frame = new JFrame();
        this.panel = new JPanel(new GridBagLayout());
        this.welcome = new JLabel("<html><B>Welcome!</b></html>");
        this.studentSearch = new JButton("Search for student");
        this.rentalSearch = new JButton("Search for rental");
        this.cons = new LibraryConstraints();
    }

    public void go() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("DBMU Library");
        new AdminMenuBar(this.frame);

        cons.setGridXY(0, 0);
        cons.anchor = GridBagConstraints.PAGE_START;
        cons.insets = new Insets(50, 5, 10, 5);
        cons.ipady = 20;
        cons.gridwidth = 2;
        cons.weighty = 0.4;
        panel.add(this.welcome, this.cons);

        cons.setGridXY(0, 1);
        cons.gridwidth = 1;
        cons.weighty = 0.5;
        cons.insets = new Insets(0, 5, 5, 10);
        cons.ipady = 60;
        cons.ipadx = 40;
        panel.add(this.studentSearch, this.cons);
        cons.gridx = 1;
        cons.insets = new Insets(0, 10, 5, 5);
        panel.add(this.rentalSearch, this.cons);

        // #region Button Listeners
        studentSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminSearchPage(Consts.STUDENT_SEARCH);
            }
        });
        rentalSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminSearchPage(Consts.RENTAL_SEARCH);
            }
        });
        // #endregion

        frame.add(this.panel);
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
