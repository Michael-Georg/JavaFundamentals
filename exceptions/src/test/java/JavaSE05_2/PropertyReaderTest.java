package JavaSE05_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PropertyReaderTest {
    private static final String DIRECTORYPATH = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\exceptions\\src\\main\\resources";
    private static final String FILEPATH = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\exceptions\\src\\main\\resources\\test.properties";
    private static final String ANOTHERDIRECTORY = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\exceptions\\src\\main\\java";

    @Test
    public void shouldFindInFile() throws Exception {
        PropertyReader findInFile = new PropertyReader(FILEPATH);
        assertThat(findInFile.findKeyInPropertyFile("key1"), is("value"));
    }

    @Test
    public void shouldFindInDirectory() throws Exception {
        PropertyReader findInDirectory = new PropertyReader(DIRECTORYPATH);
        assertThat(findInDirectory.findKeyInPropertyFile("key1"), is("value"));
    }

    @Test(expected = KeyNotFoundException.class)
    public void couldNotFindProperty() throws Exception {
        PropertyReader couldNotFindInDirectory = new PropertyReader(ANOTHERDIRECTORY);
        couldNotFindInDirectory.findKeyInPropertyFile("");

    }
}