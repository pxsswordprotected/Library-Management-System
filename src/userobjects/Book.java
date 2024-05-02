package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Book extends Inventory {
    private int isbn;
    private String publisher;
    private String author;
    private int id; 


    public Book(String genre, String title, int yr,int id, int isbn, String publisher, String author) {
        super(genre, title, yr);
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
        this.id = id;
    }
        // Getter and setters
        public int getID() {
            return id;
        }
    
        public void setID(int id) {
            this.id = id;
        }

    public int getISBN() {
        return isbn;
    }
    public void setISBN(int isbn) {
        this.isbn = isbn;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
