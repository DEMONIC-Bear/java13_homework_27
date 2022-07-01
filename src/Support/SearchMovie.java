package Support;
import DataBase.Movie;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMovie {
    public FileService fileService = new FileService();
    public List<Movie> moviesList;
    public SearchMovie() {
        moviesList = fileService.getMovieList();
    }
    public void searchMovieByName(String name) {
        PrintMovieList printMovieList = new PrintMovieList();
        for (Movie movie : moviesList) {
            if (movie.getName().contains(name)) {
                System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
                System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
                printMovieList.printSomeMovie(movie);
            }
        }
    }

    public void searchMovieByActorName(String name) {
        PrintMovieList printMovieList = new PrintMovieList();
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        for(Movie movie : moviesList) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (movie.getCast().get(i).getFullName().contains(name)) {
                    printMovieList.printSomeMovie(movie);
                }
            }
        }
    }

    public void searchMovieByDirector(String name) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        for (Movie movie : moviesList) {
            if (movie.getDirector().getFullName().contains(name)) {
                PrintMovieList printMovieList = new PrintMovieList();
                printMovieList.printSomeMovie(movie);
            }
        }
    }
    public void searchMovieByYear(int year) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        for(Movie movie : moviesList) {
            if(movie.getYear() == year) {
                PrintMovieList printMovieList = new PrintMovieList();
                printMovieList.printSomeMovie(movie);
            }
        }
    }

    public void searchMovieByActorRole(String role) {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        PrintMovieList printMovieList = new PrintMovieList();
        for(Movie movie : moviesList) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (movie.getCast().get(i).getRole().contains(role)) {
                    printMovieList.printSomeMovie(movie);
                }
            }
        }
    }

    public void searchActorAndActorsRole(int userNum)  {
        System.out.printf("%-42s | %-5s | %-11s | %-18s | %-23s | %-21s | %-23s | %-18s |\n", "Movie name", "Year", "Description", "Director", "Actor name", "Role", "Actor name", "Role");
        System.out.println("-------------------------------------------|-------|-------------|--------------------|-------------------------|-----------------------|-------------------------|---------------------------------");
        PrintMovieList printMovieList = new PrintMovieList();
        List<String> defaultList = new ArrayList<>();
        for (Movie movie : moviesList) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                if (!defaultList.contains(movie.getCast().get(i).getFullName())) {
                    defaultList.add(movie.getCast().get(i).getFullName());
                }
            }
        }

        System.out.printf("%-42s | %-20s |\n", "Movie name", "Actor role");
        System.out.println("-------------------------------------------|----------------------|");
        switch (userNum) {
            case 13 -> Collections.sort(defaultList);
            case 14 -> defaultList.sort(Collections.reverseOrder());
        }
        if (userNum == 13 || userNum == 14) {
            for (String s : defaultList) {
                for (Movie m : moviesList) {
                    for (int i = 0; i < m.getCast().size(); i++) {
                        if (m.getCast().get(i).getFullName().equals(s)) {
                            printMovieList.printActorAndActorRoles(m.getName(), m.getCast().get(i).getFullName(), m.getCast().get(i).getRole());
                        }
                    }
                }
            }

        }
    }
}
