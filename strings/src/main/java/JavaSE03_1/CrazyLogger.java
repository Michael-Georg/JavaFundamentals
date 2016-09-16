package JavaSE03_1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {
    private Pattern pattern;
    private StringBuilder log;

    public CrazyLogger() {
        pattern = Pattern.compile("([\\d\\-: ]{21})(.+)\\u000A");
        log = new StringBuilder();
    }

    public CrazyLogger addMessage(String message) {
        if (!message.equals(""))
            log.append(getDataTime()).append(" - ").append(message).append("\n");
        return this;
    }

    public String getDataTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm"));
    }

    public String getLog() {
        return log.toString();
    }



    public String findMessageByWords(String text) {
        String result = "";
        Matcher m = pattern.matcher(getLog());
        while (m.find()) {
            if (m.group(2).toLowerCase().contains(text.toLowerCase()))
                result+=m.group(0);
        }
        return result;
    }

    public String findMessageByData(String data) {
        String result = "";
        Matcher m = pattern.matcher(getLog());
        while   (m.find()){
            if (m.group(1).contains(data))
                result+=m.group(0);
        }
        return result;
    }
}
