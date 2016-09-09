package OfficeTasks1_4;

import lombok.*;

@AllArgsConstructor
@Getter
public class NoteBook implements Stationery {
    private String producerName;
    private String format;
    @Setter
    private double price;

    public NoteBook() {
        producerName = "notebookProducer";
        format = "A5";
        price = 5.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteBook noteBook = (NoteBook) o;

        if (Double.compare(noteBook.price, price) != 0) return false;
        if (producerName != null ? !producerName.equals(noteBook.producerName) : noteBook.producerName != null)
            return false;
        return format != null ? format.equals(noteBook.format) : noteBook.format == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = producerName != null ? producerName.hashCode() : 0;
        result = 31 * result + (format != null ? format.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "NoteBook: \n" +
                "  producerName - " + producerName + '\n' +
                "  format - " + format + '\n' +
                "  price - " + price;
    }
}
