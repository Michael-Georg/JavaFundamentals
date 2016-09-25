package JavaSE04_4;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Movie implements Serializable {
    String name;
    private List<String> artists;

    Movie(String name, String... artists) {
        this.name = name;
        this.artists = new LinkedList<>();
        Collections.addAll(this.artists, artists);
    }

    @Override
    public String toString() {
        return "Movie: " + name +
                "; Starring:" + artists;
    }
}
