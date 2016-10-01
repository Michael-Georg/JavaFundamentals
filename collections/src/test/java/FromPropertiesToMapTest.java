import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FromPropertiesToMapTest {
    private static final String FILEPATH = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\collections\\src\\test\\resources\\test.properties";
    @Test
    public void mapLodedCorrect() throws Exception {
        FromPropertiesToMap map = new FromPropertiesToMap(FILEPATH);
        map.create();
        assertThat(map.getValue("one"), is("123"));
    }
}