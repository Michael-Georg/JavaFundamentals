package JavaSE04_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileByteStream extends FindJavaKeyWords {

    public ReadFileByteStream(String pathIn, String pathOut){
        super(pathIn,pathOut);
    }
    @Override
    public void parseFile() {
        try (FileInputStream fileIN = new FileInputStream(new File(filePathIn))) {
            byte[] buffer = new byte[1024];
            StringBuilder word = new StringBuilder();
            int len;
            while ((len = fileIN.read(buffer)) > 0) {
                for (int i = 0; i < len; i++) {
                    if (buffer[i] >= 'A' & buffer[i] <= 'z')
                        word.append((char) buffer[i]);
                    else {
                        searchInMap(word.toString());
                        word.setLength(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

