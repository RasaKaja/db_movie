package movie;

import java.sql.SQLException;
import java.util.Scanner;

public class MovieControler {
    MovieRepository movieRepository = new MovieRepository();

    public void createTable(){
        try {
            movieRepository.createTable();
            System.out.println("Movie table created successfully.");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Movie creation failed.");
        }
    }

    public void
}

