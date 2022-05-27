import movie.Movie;
import movie.MovieControler;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie movie = new Movie("Fast and furious 1", "Drama", 2012);
//        Movie movie1 = new Movie("The Godfather", "Crime family", 1972);
//        Movie movie2 = new Movie("Pulp fiction", "Crime, drama", 1994);
//        Movie movie3 = new Movie("Fight club", "Drama", 1999);
//        Movie movie4 = new Movie("Matrica", "Action, Sci-Fi", 1999);

        MovieControler movieControler = new MovieControler();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Movie Service.");

        String input = "";

        do {
            System.out.println("""
                    What would you like to do?
                    1. add movie
                    2. update movie by title (or id)
                    3. delete movie by id                    
                    4. show all movies
                    0. QUIT the program
                    """);

            input = scanner.nextLine();

            switch (input){
                case "1":
                    //add movie
                    break;
                case "2":
                    //update movie
                    break;
                case "3":
                    //delete movie
                    break;
                case "4":
                    //show all movies
                    break;
                default:
                    System.out.println("Please enter a valid value.");
                    break;
            }
        } while (!input.equals("0"));

    }
}


//add any three records to the MOVIES table
//update one selected record (use the PreparedStatement)
//delete selected record with specified id
//display all other records in the database
//In the task, focus on the correct use of the JDBC API. All queries can be made directly in the main method.
// Use a single connection to execute all queries. However, remember to use try-with-resources when opening
// a connection and creating objects such a Statement or PreparedStatement.
// Also, don't worry about exception handling in this task (in case of error, display stack trace).