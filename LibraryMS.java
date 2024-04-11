import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibraryMS extends Frame {

    private Button btnSearch;
    private TextField tfSearch;
    private Label lblSearch;
    private Label lblResult;

    public LibraryMS() {

        setLayout(new FlowLayout());
        lblSearch = new Label("Search");
        add(lblSearch);

        tfSearch = new TextField();
        tfSearch.setEditable(true);
        add(tfSearch);

        btnSearch = new Button("Search");
        BtnSearchListener listener = new BtnSearchListener();
        btnSearch.addActionListener(listener);

        setTitle("Library Management System");
        setSize(400, 500);

        setVisible(true);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        LibraryMS app = new LibraryMS();
    }

    private class BtnSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
           lblResult.setText("Not yet implemented!");
        }
     }



}