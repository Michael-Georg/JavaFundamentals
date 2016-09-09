package OfficeTasks1_4;

import java.util.LinkedList;
import java.util.List;

/**
 * Set of Stationery on individual workplace. Include methods for addition base set of items,
 * calculate the total price, add item to workplace,
 * print all items, sort items by price, producer name, price and producer name.
 */
public class PersonalStationery {
    private List<Stationery> list;

    public Stationery getItem(int i) {
        return list.get(i);
    }

    public PersonalStationery() {
        list = new LinkedList<>();
    }

    public PersonalStationery addBaseSet() {
        list.add(new Pen());
        list.add(new NoteBook());
        list.add(new Pencil());
        return this;
    }

    public double sumPrice() {
        double result = 0;
        for (Stationery st : list) {
            result += st.getPrice();
        }
        return result;
    }

    public void printStationery() {
        for (Stationery st : list) {
            System.out.println(st.toString());
        }
    }

    public <T extends Stationery> PersonalStationery addItem(T item) {
        list.add(item);
        return this;
    }

    public int getSize() {
        return list.size();
    }

    public PersonalStationery sortByPrice() {
        list.sort((Stationery o1, Stationery o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        });
        return this;

    }

    public PersonalStationery sortByProducerName() {
        list.sort((Stationery o1, Stationery o2) -> o1.getProducerName().compareTo(o2.getProducerName()));
        return this;
    }

    public PersonalStationery sortPriceThenProducer() {
        list.sort((Stationery o1, Stationery o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return o1.getProducerName().compareTo(o2.getProducerName());
        });
        return this;
    }
}
