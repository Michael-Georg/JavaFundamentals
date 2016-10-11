package JavaSE07_1_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    private static final String PATH = "e:\\JavaPrograms\\JavaFundamentals\\threads" +
            "\\src\\main\\resources\\accounts.properties";
    private static final String PATH1 = "e:\\JavaPrograms\\JavaFundamentals\\threads" +
            "\\src\\main\\resources\\transactions.txt";

    @Test
    public void allTransactionsCorrect() throws Exception {
        Bank accounts = new Bank(PATH);
        accounts.transactions(PATH1);
        System.out.println(Thread.activeCount());
        Thread.sleep(1000);

        assertThat(accounts.getAccounts().get(0).getBalance(), is(300));
        assertThat(accounts.getAccounts().get(1).getBalance(), is(300));
        assertThat(accounts.getAccounts().get(2).getBalance(), is(300));
    }

}