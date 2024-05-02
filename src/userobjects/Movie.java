package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Movie extends Inventory {
    private int id; 
    private int isan;
    private String director;
    private String studio;
    
    public Movie(String genre, String title, int yr, int id, int isan, String dir, String studio) {
        super(genre, title, yr);
        this.id = id; // Setting ID
        this.isan = isan;
        this.director = dir;
        this.studio = studio;
    }

    // Getter and setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public int getISAN() {
        return isan;
    }
    public void setISAN(int isan) {
        this.isan = isan;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

}
