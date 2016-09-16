package JavaSE03_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResourcePropertyTest {
    ResourceProperty demo = new ResourceProperty();
    @Test
    public void CorrectNumberOfQuestion() throws Exception {
        demo.setLocale("en");
        assertThat(demo.answerOnQuestions(1), is("you"));
        demo.setLocale("ru");
        assertThat(demo.answerOnQuestions(1), is("Ты"));
    }

    @Test
    public void LocaleChanged() throws Exception {
        demo.setLocale("en");
        assertThat(demo.localeInfo(), is("en"));
        demo.setLocale("ru");
        assertThat(demo.localeInfo(), is("ru"));
    }
}