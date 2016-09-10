package JavaSE02_1_4;

import JavaSE02_1_4.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StationeryTest {
    PersonalStationery personalSet = new PersonalStationery();

    @Test
    public void sumPriceShouldCorrect() {
        personalSet.addItem(new Pen("", "", 10));
        personalSet.addItem(new NoteBook("", "", 2));
        personalSet.addItem(new Pencil("", "", 3));
        assertThat(personalSet.sumPrice(), is(15.0));
    }

    @Test
    public void addition3BaseItemsRight() {
        personalSet.addBaseSet();

        assertThat(personalSet.getSize(), is(3));
    }

    @Test
    public void shouldBeSortedByPrice() {
        personalSet.addItem(new Pen("", "Red", 7.000001)).addItem(new Pen("", "Red", 100.0)).addBaseSet().sortByPrice();
       assertThat(personalSet.getItem(0).getPrice(), is(5.0));
       assertThat(personalSet.getItem(1).getPrice(), is(7.0));
       assertThat(personalSet.getItem(2).getPrice(), is(7.000001));
       assertThat(personalSet.getItem(3).getPrice(), is(9.9));
       assertThat(personalSet.getItem(4).getPrice(), is(100.0));
    }

    @Test
    public void shouldBeSortedByProducer() {
        personalSet.addItem(new Pen("firstProducer", "Red", 100.0)).addBaseSet().sortByProducerName();
        assertThat(personalSet.getItem(0).getProducerName(), is("firstProducer"));
        assertThat(personalSet.getItem(1).getProducerName(), is("notebookProducer"));
        assertThat(personalSet.getItem(2).getProducerName(), is("parker"));
        assertThat(personalSet.getItem(3).getProducerName(), is("pencilProducer"));
    }
    @Test
    public void shouldBeSortedByPriceThenProducer() {
        personalSet.addItem(new Pen("uProducer", "Red", 5.0)).addBaseSet().sortPriceThenProducer().printStationery();
        assertThat(personalSet.getItem(0).getProducerName(), is("notebookProducer"));
        assertThat(personalSet.getItem(1).getProducerName(), is("uProducer"));
        assertThat(personalSet.getItem(2).getProducerName(), is("pencilProducer"));
        assertThat(personalSet.getItem(3).getProducerName(), is("parker"));
    }
}
