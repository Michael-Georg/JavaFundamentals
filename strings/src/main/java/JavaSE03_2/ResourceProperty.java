package JavaSE03_2;


import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProperty {
    private Locale locale;
    private ResourceBundle bundle;

    ResourceProperty() {
        locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("prop", locale);
    }

    public void setLocale(String str) {
        locale = new Locale(str);
        bundle = ResourceBundle.getBundle("prop", locale);
    }

    public String localeInfo() {
        return locale.getLanguage();
    }


    public String answerOnQuestions(int i) {
        try {
            return bundle.getString("Answer" + i);
        } catch (Exception e) {
            System.out.println("choose another question number");
        }
        return "";
    }

    public void questions() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(bundle.getString("Question" + i));
        }
    }
}
