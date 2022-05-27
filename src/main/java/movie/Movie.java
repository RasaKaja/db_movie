package movie;

public class Movie {
    private int id;
    public String title;
    public String genre;
    public int yearOfRelease;

    // create constructor to help to create a new product easier
    public Movie(String title, String genre, int yearOfRelease){
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Movie id " + id + ", title='" + title + ", genre='" + genre + ", yearOfRelease=" + yearOfRelease;
    }
}

