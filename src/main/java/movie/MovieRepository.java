package movie;

import database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieRepository {
    DBHandler dbHandler = new DBHandler();

    // create a table for movie
    public void createTable() throws SQLException{
        String query = "CREATE TABLE movie (id int(11) PRIMARY KEY, title varchar(255) NOT NULL, genre varchar (255), yearOfRelease int(4) NOT NULL)";

        // create prepared statement to help execute query
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void create(Movie movie) throws SQLException{
        String query = "INSERT INTO movie(title, genre, yearOfRelease) VALUES (?, ?, ?)";

        // create prepared statement to help execute query
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        // set values for the ? place holders
        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3, movie.yearOfRelease);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Movie> getAll() throws SQLException{
        //specify query to get all columns in the product table
        String query = "SELECT * FROM movie";

        //create statement variable
        Statement statement = dbHandler.getConnection().createStatement();

        // query the statement with the query string created and store the result in a result set
        ResultSet result = statement.executeQuery(query);

        // create arraylist to hold the result gotten from database
        ArrayList<Movie> movie = new ArrayList<>();

        // loop through result with result.next() and save each record to the arraylist
        while (result.next()){
            int id = result.getInt("id");
            String title = result.getString("title");
            String genre = result.getString("genre");
            int yearOfRelease = result.getInt("yearOfRelease");

            movie.add(new Movie(id, title, genre, yearOfRelease));
        }
        statement.close();
        return movie;
    }

    public Movie findById(int id) throws SQLException{
        String query = "SELECT * FROM movie WHERE id = ?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();

        if (result.next()){
            int resultId = result.getInt("id");
            String title = result.getString("title");
            String genre = result.getString("genre");
            int yearOfRelease = result.getInt("yearOfRelease");

            return new Movie(resultId, title, genre, yearOfRelease);
        } else {
            return null;
        }
    }

    public void delete(int id) throws SQLException{
        String query = "DELETE FROM movie WHERE id = ?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void update(Movie movie) throws SQLException{
        String query = "UPDATE movie SET title = ?, genre = ?, yearOfRelease = ? WHERE id = ?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        // set values for ? placeholder
        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3, movie.yearOfRelease);
        preparedStatement.setInt(4, movie.getId());

        preparedStatement.execute();
        preparedStatement.close();
    }
}
