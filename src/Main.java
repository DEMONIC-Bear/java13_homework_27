import DataBase.Movie;
import Support.FileService;
import Support.PrintMovieList;
import Support.SearchMovie;
import Support.SortMovie;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<Movie> moviesList = fileService.getMovieList();
        PrintMovieList printMovieList = new PrintMovieList();
        boolean check = true;
        while (check) {
            System.out.println("========================================================================================");
            System.out.println("""

                    What do you want to do?
                    [1]  - Display all movies                     [2]  - Search movie by title
                    [3]  - Sort movies by Name (up)               [4]  - Sort movies by Name (down)
                    [5]  - Sort movies by Release year (up)       [6]  - Sort movies by Release year (down)
                    [7]  - Sort movies by Director (up)           [8]  - Sort movies by Director (down)
                    [9]  - Find movies with your favorite actor?  [10] - Find movies from your favorite director?
                    [11] - Find movies by release year?           [12] - Display movies with your actor's role?
                    [13] - Display actors and roles (up)?         [14] - Display actors and roles (down)
                                                        [0] - EXIT
                               """);
            System.out.println("========================================================================================");

            int userSelect = new Scanner(System.in).nextInt();
            try {
                if (userSelect < 1 && userSelect > 3) throw new RuntimeException();
                SearchMovie searchByAllParameters = new SearchMovie();
                SortMovie sortMovieByAllParameters = new SortMovie();
                switch (userSelect) {
                    case 0 -> check = false;
                    case 1 -> printMovieList.printMovieList(moviesList);
                    case 2 -> {
                        System.out.println("Enter movie name: ");
                        String movieName = new Scanner(System.in).nextLine();
                        String s = movieName.substring(0, 1).toUpperCase() + movieName.substring(1);
                        searchByAllParameters.searchMovieByName(s);
                    }
                    case 3, 4 -> {
                        moviesList = sortMovieByAllParameters.sortMovieByName(userSelect);
                        printList(moviesList);
                    }
                    case 5, 6 -> {
                        moviesList = sortMovieByAllParameters.sortMovieByYear(userSelect);
                        printList(moviesList);
                    }
                    case 7, 8 -> {
                        moviesList = sortMovieByAllParameters.sortMovieByDirector(userSelect);
                        printList(moviesList);
                    }
                    case 9 -> {
                        System.out.println("Enter actor name: ");
                        try {
                            String name = new Scanner(System.in).nextLine();
                            String s = name.substring(0, 1).toUpperCase() + name.substring(1);
                            searchByAllParameters.searchMovieByActorName(s);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 10 -> {
                        System.out.println("Enter director name: ");
                        try {
                            String name = new Scanner(System.in).nextLine();
                            String s = name.substring(0, 1).toUpperCase() + name.substring(1);
                            searchByAllParameters.searchMovieByDirector(s);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 11 -> {
                        System.out.println("Enter movie year: ");
                        try {
                            int year = new Scanner(System.in).nextInt();
                            searchByAllParameters.searchMovieByYear(year);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 12 -> {
                        System.out.println("Enter the role of your actor: ");
                        try {
                            String role = new Scanner(System.in).nextLine();
                            String s = role.substring(0, 1).toUpperCase() + role.substring(1);
                            searchByAllParameters.searchMovieByActorRole(s);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 13, 14 -> searchByAllParameters.searchActorAndActorsRole(userSelect);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = false;
            }
        }
    }
    public static void printList(List<Movie> list) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        for (Movie m : list) {
            System.out.printf("%-42s | %-5s | %-11s | %-18s | %-14s |\n", m.getName(), m.getYear(), m.getDescription(), m.getDirector().getFullName(), m.getCast());
        }
    }
}
