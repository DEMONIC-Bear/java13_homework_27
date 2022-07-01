package Support;
import DataBase.Movie;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class SortMovie {
    public FileService fileService = new FileService();
    public List<Movie> moviesList;
    public SortMovie() throws FileNotFoundException {
        moviesList = fileService.getMovieList();
    }
    public List<Movie> sortMovieByName(int sort) {
        if (sort == 3) {
            return moviesList.stream()
                    .sorted(Comparator.comparing(Movie::getName))
                    .toList();
        } else {
            return moviesList.stream()
                    .sorted(Comparator.comparing(Movie::getName)
                            .reversed())
                    .toList();
        }
    }

    public List<Movie> sortMovieByYear(int sort) {
        if (sort == 5) {
            return moviesList.stream()
                    .sorted(Comparator.comparing(Movie::getYear))
                    .toList();
        } else {
            return moviesList.stream().sorted(Comparator.comparing(Movie::getYear)
                    .reversed()).toList();
        }
    }

    public List<Movie> sortMovieByDirector(int sort) {
        if (sort == 7) {
            moviesList.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
                }
            });
        } else {
            moviesList.sort(new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getDirector().getFullName().compareTo(o1.getDirector().getFullName());
                }
            });
        }
        return moviesList;
    }
}
