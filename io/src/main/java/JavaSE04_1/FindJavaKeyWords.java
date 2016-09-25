package JavaSE04_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class FindJavaKeyWords {

    private final Map<String, Integer> keyWords = new HashMap<String, Integer>() {{
        put("abstract", 0); put("assert", 0); put("boolean", 0); put("break", 0);
        put("byte", 0); put("case", 0); put("class", 0); put("char", 0);
        put("catch", 0); put("const", 0); put("continue", 0); put("default", 0);
        put("else", 0); put("double", 0); put("do", 0); put("enum", 0);
        put("extends", 0); put("final", 0); put("goto", 0); put("if", 0);
        put("implements", 0); put("int", 0); put("instanceof", 0); put("import", 0);
        put("interface", 0); put("long", 0); put("native", 0); put("private", 0);
        put("package", 0); put("new", 0); put("protected", 0); put("public", 0);
        put("return", 0); put("strictfp", 0); put("static", 0); put("short", 0);
        put("super", 0); put("switch", 0); put("synchronized", 0); put("throws", 0);
        put("throw", 0); put("this", 0); put("transient", 0); put("try", 0);
        put("void", 0); put("while", 0); put("volatile", 0); put("for", 0);
        put("float", 0); put("finally", 0);
    }};

    protected final String filePathIn;
    private final String filePathOut;

    protected FindJavaKeyWords(String fileIn, String fileOut) {
        filePathIn = fileIn;
        filePathOut = fileOut;

    }

    protected abstract void parseFile();

    protected void searchInMap(String str) {
       if (keyWords.containsKey(str)) keyWords.replace(str, keyWords.get(str)+1);
    }

    public void printResults() {
        try (FileOutputStream fileOUT = new FileOutputStream(new File(filePathOut))) {
            for (Map.Entry<String, Integer> pair : keyWords.entrySet()) {
                fileOUT.write(pair.getKey().getBytes());
                fileOUT.write(" - ".getBytes());
                fileOUT.write(pair.getValue().toString().getBytes());
                fileOUT.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
