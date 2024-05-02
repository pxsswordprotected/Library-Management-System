package objecthandlers;

import userobjects.Movie;
import utils.SQLUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieHandler {
    
    private SQLUtil sqlUtil;
    
    public MovieHandler() {
        sqlUtil = new SQLUtil();
    }

    public void addMovie(Movie movie) {
        // Add movie to Inventory table
        String insertInventoryQuery = "INSERT INTO Inventory (ID, genre, title, year) VALUES "
                + "(" + movie.getID() + ", '" + movie.getGenre() + "', '" + movie.getTitle() + "', " + movie.getYear() + ")";
        sqlUtil.executeUpdate(insertInventoryQuery);
        
        // Add movie to Movie table
        String insertMovieQuery = "INSERT INTO Movie (ID, ISAN, Director, Studio) VALUES "
                + "(" + movie.getID() + ", " + movie.getISAN() + ", '" + movie.getDirector() + "', '" + movie.getProducer() + "')";
        sqlUtil.executeUpdate(insertMovieQuery);
        
        // Close connection
        sqlUtil.closeConnection();
    }
}
