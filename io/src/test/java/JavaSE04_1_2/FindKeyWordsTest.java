package JavaSE04_1_2;

import JavaSE04_1.ReadFileByteStream;
import org.junit.Test;
import JavaSE04_2.ReadFileCharStream;

import java.io.File;
import java.io.FileInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FindKeyWordsTest {

    private static final String PATHIN = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\main\\java\\JavaSE04_1\\ReadFileByteStream.java";
    private static final String PATHOUT1 = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\test\\resources\\Result1.txt";
    private static final String PATHOUT2 = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\test\\resources\\Result2.txt";

    private ReadFileByteStream stream1 = new ReadFileByteStream(PATHIN, PATHOUT1);
    private ReadFileCharStream stream2 = new ReadFileCharStream(PATHIN, PATHOUT2);

    @Test
    public void resultsOfBothStreamAreEquals() throws Exception {
        stream1.parseFile();
        stream1.printResults();
        stream2.parseFile();
        stream2.printResults();
        FileInputStream in1 = new FileInputStream(new File(PATHOUT1));
        FileInputStream in2 = new FileInputStream(new File(PATHOUT2));

        byte[] buffer1 = new byte[in1.available()];
        byte[] buffer2 = new byte[in2.available()];
        in1.read(buffer1);
        in2.read(buffer2);
        assertTrue(in1.available() == in2.available());
        assertThat(new String(buffer1), is(new String(buffer2)));
    }
}