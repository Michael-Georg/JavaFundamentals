package JavaSE03_1;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CrazyLoggerTest {
    CrazyLogger log = new CrazyLogger();
    String dataTime = log.getDataTime();

    @Test
    public void addSimpleMessage() throws Exception {
        String s = "Hello";
        log.addMessage(s);
        assertThat(log.getLog(), is(dataTime + " - " + s + '\n')); // dataTime + " - " + message + '\n'
    }

    @Test
    public void getEmptyLog() throws Exception {
        log.addMessage("");
        assertThat(log.getLog(), is(""));
    }

    @Test
    public void messageSizeCorrect() throws Exception {
        String s = "Hello";
        log.addMessage(s);
        assertThat(log.getLog().length(), is(dataTime.length() + s.length() + 4)); // dataTime + " - " + message + '\n'
    }

        @Test
    public void findMessageInLogByData$Time() throws Exception {
            log.addMessage("world")
                    .addMessage("15-08-2016 : 18-30 - Hello JaVa");
            assertThat(log.findMessageByData(dataTime), is(dataTime + " - world" + "\n" +
                    dataTime + " - 15-08-2016 : 18-30 - Hello JaVa\n"));
    }

    @Test
    public void findMessageInLogByWords() throws Exception {
        log.addMessage("Hello J world AVA")
                .addMessage("world")
                .addMessage("java")
                .addMessage("15-08-2016 : 18-30 - Hello JaVa");
//        System.out.println(log.findMessageByWords("java"));
        assertThat(log.findMessageByWords("java"), is(dataTime + " - java" + "\n" +
                                                      dataTime + " - 15-08-2016 : 18-30 - Hello JaVa\n"));
    }
}
