package Support;

import DataBase.Movie;
import DataBase.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileService {
    public final List<Movie> moviesList;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public FileService()  {
        try {
            JsonReader jsonReader = new JsonReader(new FileReader("./movies.json"));

            Movies movies = GSON.fromJson(jsonReader, Movies.class);
            moviesList = movies.getMovies();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Movie> getMovieList() {
        return moviesList;
    }




}
