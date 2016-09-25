package JavaSE04_4;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieCollectionTest {

    private static final String FILEPATH = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\test\\java\\JavaSE04_4\\Ser01.txt";
    private MovieCollection movies = new MovieCollection();

    @Before
    public void collectionInit(){
        movies.addMovie(new Movie("Avatar", "Sam Worthington", "Zoe Saldana"));
        movies.addMovie(new Movie("The Fast and the Furious", "Vin Diesel", "Paul Walker"));
        movies.addMovie(new Movie("Back to the future", "Michael J. Fox", "Christopher Lloyd"));
    }
// add 3 items serialized and remove 1 then load serializable object
    @Test
    public void serializableTest() throws Exception {
        try(ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(FILEPATH));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILEPATH))){

            out.writeObject(movies);
            movies.removeMovie("Avatar");
            movies = (MovieCollection) in.readObject();

            assertThat(movies.movieCount(), is(3));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}