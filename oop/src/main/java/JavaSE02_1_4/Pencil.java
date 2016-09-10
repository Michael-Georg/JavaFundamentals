package JavaSE02_1_4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pencil implements Stationery {
    private String producerName;
    private String color;
    private double price;

    public Pencil() {
        producerName = "pencilProducer";
        color = "gray";
        price = 7.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pencil pencil = (Pencil) o;

        if (Double.compare(pencil.price, price) != 0) return false;
        if (producerName != null ? !producerName.equals(pencil.producerName) : pencil.producerName != null)
            return false;
        return color != null ? color.equals(pencil.color) : pencil.color == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = producerName != null ? producerName.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Pencil: \n" +
                "  producerName - " + producerName + '\n' +
                "  color - " + color + '\n' +
                "  price - " + price;
    }
}
