package libms;

//#region IMPORTS
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//#endregion

/**
 *
 * @author Grant Swift
 */
@SuppressWarnings("unused")
public class AdminSearchPage extends LibraryGUI {
    
    //#region
    private JFrame frame;
    private JPanel mainPanel, searchPanel, buttonPanel, searchBarPanel, resultsPanel, filtersPanel, bButtonPanel;
    private LibraryConstraints bButtonCons, searchCons, buttonCons, sBarCons, resultCons, filterCons, mainCons;
    private JButton searchButton, showFiltersButton, backButton;
    private JTextField searchField;
    private JScrollPane scrollPane;
    private JTable result;
    private int searchType;

    //#endregion

    public AdminSearchPage(int sT) {
        this.frame = new JFrame();
        this.searchType = sT;
        
        this.mainPanel = new JPanel();
        this.searchPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.bButtonPanel = new JPanel();
        this.searchBarPanel = new JPanel();
        this.resultsPanel = new JPanel();
        this.filtersPanel = new JPanel();

        this.bButtonCons = new LibraryConstraints();
        this.searchCons = new LibraryConstraints();
        this.sBarCons = new LibraryConstraints();
        this.mainCons = new LibraryConstraints();
        this.resultCons = new LibraryConstraints();

        this.searchButton = new JButton("Search");
        this.showFiltersButton = new JButton();
        this.backButton = new JButton();

        this.result = new JTable();
        this.scrollPane = new JScrollPane(this.result);
        this.searchField = new JTextField(30);
        objects.add(this);
        this.go();
    }
    
    public void go() {
        switch (this.searchType) {
            case Consts.STUDENT_SEARCH:
                this.setCurrentScreen(Consts.STUDENT_SEARCH);
                frame.setTitle("Student Search");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                mainPanel.setLayout(new GridBagLayout());
                searchPanel.setLayout(new GridBagLayout());
                buttonPanel.setLayout(new GridBagLayout());
                bButtonPanel.setLayout(new BoxLayout(bButtonPanel, BoxLayout.Y_AXIS));
                searchBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                resultsPanel.setLayout(new GridBagLayout());
                filtersPanel.setLayout(new GridBagLayout());
                
                searchCons.insets = new Insets(5,5,5,5);
                resultCons.insets = new Insets(5,5,5,5);
                sBarCons.setup();
                mainCons.setGridXY(0,0);

                searchBarPanel.add(this.searchField);
                searchBarPanel.add(this.searchButton);
                searchPanel.add(this.searchBarPanel, this.searchCons);
                mainPanel.add(this.searchPanel, this.mainCons);
                mainCons.gridy++;

                resultsPanel.add(this.scrollPane, this.resultCons);
                mainPanel.add(this.resultsPanel, this.mainCons);

                frame.add(this.mainPanel);
                frame.pack();
                frame.validate();
                frame.repaint();
                frame.setSize(600, 600);
                frame.setResizable(true);
                frame.setVisible(true);
                break;
        
            case Consts.RENTAL_SEARCH:

                break;
            
            case Consts.UPDATE_INVENTORY:
            
                break;
            
            default:
                System.out.println("You should not be calling a search menu from this page.");
                break;
        }
    }

    public class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
