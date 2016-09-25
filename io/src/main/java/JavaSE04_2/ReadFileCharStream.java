package JavaSE04_2;

import JavaSE04_1.FindJavaKeyWords;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCharStream extends FindJavaKeyWords {

    public ReadFileCharStream(String pathIn, String pathOut) {
        super(pathIn, pathOut);
    }

    @Override
    public void parseFile() {
        try (FileReader fileIN = new FileReader(new File(filePathIn))) {
            char[] buffer = new char[1024];
            StringBuilder word = new StringBuilder();
            int len;
            while ((len = fileIN.read(buffer)) > 0) {
                for (int i = 0; i < len; i++) {
                    if (buffer[i] >= 'A' & buffer[i] <= 'z')
                        word.append(buffer[i]);
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

