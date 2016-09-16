package JavaSE02_6;

import org.junit.Test;
import java.time.LocalDate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubmarineTest {
    @Test
    public void submarineEngineStarted() throws Exception {
        Submarine submarine = new Submarine();
        System.out.println(submarine.getStartDate());
        assertThat(submarine.getStartDate(), is(LocalDate.now().toString()));

    }
}
