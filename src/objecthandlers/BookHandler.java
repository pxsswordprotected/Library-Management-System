package objecthandlers;

import userobjects.Book;
import utils.SQLUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookHandler {
    
    private SQLUtil sqlUtil;
    
    public BookHandler() {
        sqlUtil = new SQLUtil();
    }

    public void addBook(Book book) {
        // Add book to Inventory table
        String insertInventoryQuery = "INSERT INTO Inventory (ID, genre, title, year) VALUES "
                + "(" + book.getID() + ", '" + book.getGenre() + "', '" + book.getTitle() + "', " + book.getYear() + ")";
        sqlUtil.executeUpdate(insertInventoryQuery);
        
        // Add book to Book table
        String insertBookQuery = "INSERT INTO Book (ID, ISBN, Author, Publisher) VALUES "
                + "(" + book.getID() + ", " + book.getISBN() + ", '" + book.getAuthor() + "', '" + book.getPublisher() + "')";
        sqlUtil.executeUpdate(insertBookQuery);
        
        // Close connection
        sqlUtil.closeConnection();
    }
}
