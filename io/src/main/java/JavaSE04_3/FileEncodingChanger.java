package JavaSE04_3;

import java.io.*;

class FileEncodingChanger {
    private String pathIn;
    private String pathOut;

    FileEncodingChanger(String pathIn, String pathOut) {
        this.pathIn = pathIn;
        this.pathOut = pathOut;
    }

    void encodingChanger() {
        try (InputStreamReader fileIn = new InputStreamReader(new FileInputStream(pathIn), "UTF-8");
             OutputStreamWriter fileOut = new OutputStreamWriter(new FileOutputStream(pathOut), "UTF-16")) {
            int ch;
            while ((ch = fileIn.read()) != -1)
                fileOut.write(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
