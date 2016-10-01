package JavaSE05_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileSystemTest {
    private static final String DIRECTORYPATH = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\threads\\src\\main\\java\\JavaSE05_1";
    private FileSystem path1 = new FileSystem(DIRECTORYPATH);
    private FileSystem path2 = new FileSystem(DIRECTORYPATH);

    @Test
    public void createFile() {
        path1.changePath("test.txt").createFile();
        path1.reWriteFile("message!");
        path1.appendToFile("message2");
        assertThat(path1.readFile(), is("message!message2"));
        path1.deleteFile();
        path2.printCurrentDirectory();


    }
}