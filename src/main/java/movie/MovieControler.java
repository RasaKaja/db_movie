package movie;

import java.sql.SQLException;
import java.util.Scanner;

public class MovieControler {
    MovieRepository movieRepository = new MovieRepository();
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    public void createTable(){
        try {
            movieRepository.createTable();
            System.out.println("Movie table created successfully.");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Movie creation failed.");
        }
    }

    public void addMovie(){
        try {
            System.out.println("Add movie to the list.");

            System.out.print("Movie title: ");
            String title = scanner.nextLine();

            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            System.out.print("Year of release: ");
            int yearOfRelease = intScanner.nextInt();

            Movie movie = new Movie(title, genre, yearOfRelease);
            movieRepository.create(movie);

            System.out.println(title + " added to table.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to add a movie to the list.");
        }
    }

    public void allMovie(){
        try {
            System.out.println(movieRepository.getAll());
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot receive movie list from database at the moment");
        }
    }

    public void updateMovie(){
        try{
            System.out.println("Update movie.");
            System.out.print("Enter id of movie you want to update: ");
            int id = intScanner.nextInt();

            // find product from the database with ID provide by USer
            Movie movie = movieRepository.findById(id);

            // read new movie title from user and set new title to movie
            System.out.print("Title: (" + movie.title + "): ");
            movie.title = scanner.nextLine();

            System.out.print("Genre: (" + movie.genre + "): ");
            movie.genre = scanner.nextLine();

            System.out.print("Year of release: (" + movie.yearOfRelease + "): ");
            movie.yearOfRelease = intScanner.nextInt();

            movieRepository.update(movie);
            System.out.println(movie.title + " updated successfully.");

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to update movie.");
        }
    }

    public void deleteById(){
        System.out.println("Delete movie by Id.");

        System.out.print("Enter movie id: ");
        int id = intScanner.nextInt();

        try{
            movieRepository.delete(id);
            System.out.println("Movie deleted successfylly.");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot delete movie by this id: " + id);
        }

    }
}

