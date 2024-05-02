package libms;

//#region
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
//#endregion

/**
 *
 * @author Grant Swift
 */
public class StudentMenuBar extends StudentPanel {

    // #region Instance Variables
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem exitItem, updateSelf;
    // #endregion

    public StudentMenuBar(JFrame frame) {
        this.frame = frame;
        this.menuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.exitItem = new JMenuItem("Log Out");
        this.updateSelf = new JMenuItem("Update Student Profile");
        this.go();
    }

    public void go() {
        fileMenu.add(exitItem);
        editMenu.add(updateSelf);

        exitItem.addActionListener(new ExitListener());
        updateSelf.addActionListener(new UpdateListener());

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        frame.setJMenuBar(menuBar);
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class UpdateListener implements ActionListener {
        private JDialog updateSelf;
        private JPanel mainPanel;
        private JLabel email;
        private JTextField emailField;
        private JButton create, cancel;
        private LibraryConstraints mainCons;

        public UpdateListener() {
            this.updateSelf = new JDialog(getFrame());
            this.mainPanel = new JPanel(new GridBagLayout());
            this.email = new JLabel("Email: ");
            this.emailField = new JTextField(10);
            this.create = new JButton("Update");
            this.cancel = new JButton("Cancel");
            this.mainCons = new LibraryConstraints();
        }

        public void actionPerformed(ActionEvent e) {
            updateSelf.setTitle("Update Personal Info");
            updateSelf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mainCons.insets = new Insets(5, 5, 5, 5);
            mainCons.setGridXY(0, 0);
            mainCons.anchor = GridBagConstraints.CENTER;

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateSelf.dispose();
                }
            });

            mainCons.setGridXY(0, 0);
            mainCons.anchor = GridBagConstraints.LINE_START;
            mainPanel.add(email, mainCons);

            mainCons.setGridXY(1, 0);
            mainCons.anchor = GridBagConstraints.LINE_END;
            mainPanel.add(emailField, mainCons);

            mainCons.setGridXY(0, 2);
            mainCons.gridwidth = 2;
            mainCons.anchor = GridBagConstraints.CENTER;
            JPanel b = new JPanel(new FlowLayout(FlowLayout.CENTER));
            b.add(create);
            b.add(cancel);
            mainPanel.add(b, mainCons);

            JPanel superPanel = new JPanel(new GridBagLayout());
            LibraryConstraints superCons = new LibraryConstraints();
            superCons.insets = new Insets(25,25,25,25);
            superPanel.add(this.mainPanel, superCons);

            updateSelf.add(superPanel);
            updateSelf.pack();
            updateSelf.validate();
            updateSelf.setResizable(true);
            updateSelf.setVisible(true);
        }
    }
}
