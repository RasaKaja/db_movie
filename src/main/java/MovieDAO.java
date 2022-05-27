import movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    void createTable();
    void deleteTable();

    void createMovie(final Movie movie);
    void deleteMovie(int id);
    void updateMovieTitle(int id, String newTitle);
    Optional<Movie> findMovieById(int id);
    List<Movie> findAll();

}
