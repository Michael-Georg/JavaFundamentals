package JavaSE07_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankSyncTest {

    private static final String PATH = "e:\\JavaPrograms\\JavaFundamentals\\threads" +
            "\\src\\main\\resources\\accounts.properties";
    private static final String PATH1 = "e:\\JavaPrograms\\JavaFundamentals\\threads" +
            "\\src\\main\\resources\\transactions.txt";

    @Test
    public void allTransactionsCorrect() throws Exception {
        BankSync accounts = new BankSync(PATH);
        accounts.transactions(PATH1);
        Thread.sleep(1000);
        assertThat(accounts.getAccounts().get(0).getBalance(), is(300));
        assertThat(accounts.getAccounts().get(1).getBalance(), is(300));
        assertThat(accounts.getAccounts().get(2).getBalance(), is(300));
        System.out.println(accounts.getAccounts());
    }
}