package JavaSE04_3;

import org.junit.Test;

public class FileEncodingChangerTest {

    private static final String PATHIN = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\main\\java\\JavaSE04_1\\ReadFileByteStream.java";
    private static final String PATHOUT1 = "E:\\JavaPrograms\\JavaFundamentals" +
            "\\io\\src\\test\\resources\\JavaSE04_3Result.txt";

    private FileEncodingChanger fec = new FileEncodingChanger(PATHIN,PATHOUT1);
    @Test
    public void encodingChangedCorrect() throws Exception {
        fec.encodingChanger();
    }
}

