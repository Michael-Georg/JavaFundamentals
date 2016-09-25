package JavaSE04_4;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

class MovieCollection implements Serializable {
    private final List<Movie> collection;

    MovieCollection() {
        collection = new LinkedList<>();
    }

    MovieCollection addMovie(Movie movie) {
        collection.add(movie);
        return this;
    }

    MovieCollection removeMovie(String name) {
        for (Movie movie : collection) {
            if (movie.name.equals(name)) {
                collection.remove(movie);
                break;
            }
        }
        return this;
    }

    int movieCount(){
        return collection.size();
    }

    void printCollection() {
        for (Movie movie : collection) {
            System.out.println(movie);
        }
    }
}
