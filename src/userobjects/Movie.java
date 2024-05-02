package userobjects;

/**
 *
 * @author Grant Swift
 */
public class Movie extends Inventory{
    private int isan;
    private String director;
    private String producer;
    
    public Movie(String genre, String title, int yr, int isan, String dir, String prod) {
        super(genre, title, yr);
        this.isan = isan;
        this.director = dir;
        this.producer = prod;
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
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }

}
