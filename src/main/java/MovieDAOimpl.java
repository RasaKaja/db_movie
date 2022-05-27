import movie.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOimpl implements MovieDAO{
    Connection connection;
    String connectionUrl = "jdbc:mysql://localhost:3306/movie";
    String user = "root";
    String password = "MySQL55";

    public MovieDAOimpl(){
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            String query = "CREATE TABLE movie (id int(11) PRIMARY KEY, title varchar(255) NOT NULL, genre varchar (255), yearOfRelease int(4) NOT NULL)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
    }

    @Override
    public void deleteTable() {
        try {
            String query = "DROP TABLE IF EXISTS movie";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void createMovie(Movie movie) {
            try {
                String query = "INSERT INTO movie(title, genre, yearOfRelease) VALUES (?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, movie.title);
                preparedStatement.setString(2, movie.genre);
                preparedStatement.setInt(3, movie.yearOfRelease);

                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteMovie(int id) {
        try {
            String query = "DELETE FROM movie WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateMovieTitle(int id, String newTitle) {
        try {
            String query = "UPDATE movie SET title = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "title");
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        try {
            String query = "SELECT * FROM movie WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet result = preparedStatement.getResultSet();
            Movie movie = new Movie();
            if (result.next()){
                movie.title = result.getString("title");
                movie.genre = result.getString("genre");
                movie.yearOfRelease = result.getInt("yearOfRelease");
                movie.id = result.getInt("id");
            }
            return Optional.of(movie);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        try {
            String query = "SELECT * FROM movie";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            List<Movie> movies = new ArrayList<>();
            while (result.next()){
                Movie movie = new Movie();
                movie.title = result.getString("title");
                movie.genre = result.getString("genre");
                movie.yearOfRelease = result.getInt("yearOfRelease");
                movie.id = result.getInt("id");

                movies.add(movie);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
