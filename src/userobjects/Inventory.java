package userobjects;

import java.util.ArrayList;

/**
 *
 * @author Grant Swift
 */
@SuppressWarnings("unused")
public class Inventory {
    public static ArrayList<Inventory> books = new ArrayList<Inventory>();
    public static ArrayList<Inventory> movies = new ArrayList<Inventory>();
    public static ArrayList<ArrayList<Inventory>> inventory = new ArrayList<ArrayList<Inventory>>();
    
    static {
        inventory.add(books);
        inventory.add(movies);
    }

    
    private int id;
    private String genre;
    private String title;
    private int year;
    private int type;
    private boolean isRentedOut;

    private int isbn;
    private String publisher;
    private String author;

    private int isan;
    private String director;
    private String producer;

    public final int UNDEFINED = 0;
    public final int BOOK = 1;
    public final int MOVIE = 2;

    public Inventory(int id, String genre, String title, int yr, int type, int isABns, String dirPub, String authProd) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.year = yr;
        this.type = type;
        this.isRentedOut = false;
        switch (type) { // Instantiates variables depending on the type of media (book/movie)
            case BOOK:
                this.isbn = isABns;
                this.publisher = dirPub;
                this.author = authProd;

                this.isan = -1;
                this.director = null;
                this.producer = null;
                break;
            case MOVIE:
                this.isan = isABns;
                this.director = dirPub;
                this.producer = authProd;

                this.isbn = -1;
                this.publisher = null;
                this.author = null;
                break;
        
            default:
                this.isan = -1;
                this.director = null;
                this.producer = null;

                this.isbn = -1;
                this.publisher = null;
                this.author = null;
                break;
        }
    }
    public Inventory(String genre, String title, int yr) { //helper constructor for book/movie classes
        this.genre = genre;
        this.title = title;
        this.year = yr;
    }
    public Inventory() {
        new Inventory(0, null, null, 0, UNDEFINED, -1, null, null);
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public int getType() {return type;}
    public void setType(int type) {this.type = type;}

    public void addBookToInventory(Book b) {
        inventory.get(0).add(new Inventory(b.getId(), b.getGenre(), b.getTitle(), b.getYear(), BOOK, b.getISBN(), b.getPublisher(), b.getAuthor()));
    }
    public void addMovieToInventory(Movie m) {
        inventory.get(1).add(new Inventory(m.getId(), m.getGenre(), m.getTitle(), m.getYear(), MOVIE, m.getISAN(), m.getDirector(), m.getProducer()));
    }
    public void checkOut() {
        this.isRentedOut = true;
    }
    public boolean isRented() {
        return this.isRentedOut;
    }

}
