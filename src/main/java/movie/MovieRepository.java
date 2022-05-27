package movie;

import database.DBHandler;

import java.sql.SQLException;

public class MovieRepository {
    DBHandler dbHandler = new DBHandler();

    // create a table for movie
    public void createTable() throws SQLException{
        String query = "CREATE TABLE movie (id int(11) PRIMARY KEY, title varchar(255) NOT NULL, genre varchar (255), yearOfRelease int(4) NOT NULL)";
    }


}


//Note that a table named MOVIE may already exist. In that case, delete it.