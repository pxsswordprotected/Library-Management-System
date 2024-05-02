package libms;

import java.awt.Dimension;
//#region
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//#endregion
import javax.swing.SwingConstants;

/**
 *
 * @author Grant Swift
 */
public class StudentSearchPage extends LibraryGUI {

    // #region
    private JFrame frame;
    private JLabel head;
    private JPanel panel;
    private LibraryConstraints cons;
    private JButton search, back;
    private JTextField input;
    private JScrollPane scrollPane;
    private JTable result;
    // #endregion

    /**
     * @param sT
     */
    public StudentSearchPage(int sT) {
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
            case Consts.BOOK_SEARCH:
                this.setCurrentScreen(Consts.BOOK_SEARCH);
                frame.setTitle("Book Search");
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
                head.setText("<html><B>Find a Book</B></html>");
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

            case Consts.MOVIE_SEARCH:
                this.setCurrentScreen(Consts.MOVIE_SEARCH);
                frame.setTitle("Movie Search");
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
                head.setText("<html><B>Find a movie</B></html>");
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
                System.out.println("You should not be calling an inventory search menu from this page.");
                break;
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
