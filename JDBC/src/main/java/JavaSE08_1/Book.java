package JavaSE08_1;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Book {
    private Long id;
    private String author;
    private String name;
    private int year;

    @Override
    public String toString() {
        return  name + " (" + id + ")" + '\n' +
                "  " + author + ", " + year;
    }
}
