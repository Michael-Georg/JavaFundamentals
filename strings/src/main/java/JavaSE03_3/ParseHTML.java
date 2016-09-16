package JavaSE03_3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHTML {
    private File file;

    public ParseHTML(String filePath) {
        file = new File(filePath);
    }

    public ParseHTML() {
        this("E:\\JavaPrograms\\JavaFundamentals" +
                "\\strings\\src\\main\\java\\JavaSE03_3\\Text.html");
    }

    public String delAllTags(String text) {
        Pattern delTeg = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>|&nbsp;");
        Matcher mDel = delTeg.matcher(text);
        return mDel.replaceAll("");
    }

    public void separateSentences(String text, BufferedWriter writer) throws IOException {
        Pattern getPhrase = Pattern.compile("[А-Я]([^.?!]+\\([Рр]ис\\.[ \\dи]+\\))+[^.?!]*[?.!]");
        Matcher phrase = getPhrase.matcher(text);
        while (phrase.find()) {
            writer.write(phrase.group(0) + "\n");
        }
    }

    public boolean isLinksSequenceAscending() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "cp1251"))) {
            String str;
            while (null != (str = reader.readLine())) {
                Pattern pattern = Pattern.compile(" \\([Рр]ис\\. (\\d+)( и (\\d+))*\\)");
                Matcher m = pattern.matcher(str);
                int number = 0;
                while (m.find()) {
//                    writer.write(m.group(0) + " " + m.group(1) + " " + m.group(3) + '\n');
                    if ((m.group(1) != null) && number > Integer.parseInt(m.group(1))) return false;
                    else number = Integer.parseInt(m.group(1));
                    if ((m.group(3) != null) && number > Integer.parseInt(m.group(3))) return false;
                    else number = Integer.parseInt(m.group(1));
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return true;
    }

    public void printSentencesWithLinks() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "cp1251"));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream("ResultForJavaSE03_3.txt"), "cp1251"))) {
            String str;
            while (null != (str = reader.readLine())) {
                Pattern pattern = Pattern.compile(" (.*\\([Рр]ис\\.[ \\dи]+\\).*)");
                Matcher m = pattern.matcher(str);
                if (m.find()) {
                    separateSentences(delAllTags(str), writer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
