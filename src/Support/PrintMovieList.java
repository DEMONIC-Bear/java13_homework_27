package Support;

import DataBase.Movie;

import java.util.List;

public class PrintMovieList {
    public void printMovieList(List<Movie> list) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        for (Movie m : list) {
            System.out.printf("%-42s | %-5s | %-11s | %-18s | %-14s |\n", m.getName(), m.getYear(), m.getDescription(), m.getDirector().getFullName(), m.getCast());
        }
    }

    public void printSomeMovie(Movie movie) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-14s |\n", movie.getName(), movie.getYear(), movie.getDescription(), movie.getDirector().getFullName(), movie.getCast());
    }

    public void printActorAndActorRoles(String name, String name1, String role) {
        System.out.printf("%-42s | %-20s |\n", name, name1, role);

    }
}
