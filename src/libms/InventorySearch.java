package libms;

//#region IMPORTS
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
//#endregion

/**
 *
 * @author Grant Swift
 */
@SuppressWarnings("unused")
public class InventorySearch extends LibraryGUI {
    
    //#region
    private JFrame frame;
    private JPanel mainPanel, searchPanel, buttonPanel, searchBarPanel, resultsPanel, filtersPanel;
    private LibraryConstraints mainCons, searchCons, buttonCons, sBarCons, resultCons, filterCons;
    private JButton searchButton, nextPageButton, backPageButton, showFiltersButton, searchByButton, returnToAdminPanelButton;
    private JTextField searchField;

    private JPanel[] panels;
    private JButton[] buttons;
    private LibraryConstraints[] constraints;
    //#endregion

    public InventorySearch(JFrame fr) {
        this.frame = fr;
        this.panels = new JPanel[] { this.mainPanel, this.searchPanel, this.buttonPanel, this.searchBarPanel, this.resultsPanel, this.filtersPanel };
        this.constraints = new LibraryConstraints[] { this.mainCons, this.searchCons, this.buttonCons, this.sBarCons, this.resultCons, this.filterCons };
        this.buttons = new JButton[] { this.searchButton, this.nextPageButton, this.backPageButton, this.showFiltersButton, this.searchByButton, this.returnToAdminPanelButton };
    }

    public void go() {

    }
}
