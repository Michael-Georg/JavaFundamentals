package OfficeTasks1_4;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code Pen} class include three fields:
 * Price (double) - must be zero or more;
 * ProducerName(String) - contain a name of producer of the item;
 * Color(String) - Color of the pen;
 *
 * ProducerName and Color cannot be changed after they
 * are created.

 * The class {@code Pen} includes Getter methods for all fields, implemented through the method
 * {@code toString}, {@code equals}, {@code hashCode} defined by {@code Object} and
 * inherited by all classes in Java.
 */

@AllArgsConstructor
@Getter
public class Pen implements Stationery {

    private String producerName;
    private String color;
    private double price;

    public Pen() {
        producerName = "parker";
        color = "Blue";
        price = 9.9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Double.compare(pen.price, price) != 0) return false;
        if (producerName != null ? !producerName.equals(pen.producerName) : pen.producerName != null) return false;
        return color != null ? color.equals(pen.color) : pen.color == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (producerName != null ? producerName.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen:\n " +
                "  producerName - " + producerName + '\n' +
                "  color - " + color + '\n' +
                "  price - " + price;
    }
}
