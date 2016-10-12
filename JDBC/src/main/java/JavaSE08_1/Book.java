package JavaSE08_1;

import lombok.Data;

@SuppressWarnings("WeakerAccess")
@Data
public class Book {
    private int id;
    private String author;
    private String name;
    private int year;

    @Override
    public String toString() {
        return  name + " (" + id + ")" + '\n' +
                "  " + author + ", " + year;
    }
}
