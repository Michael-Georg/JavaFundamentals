package JavaSE03_3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class parseHTMLTest {
    private ParseHTML parseText = new ParseHTML();

    @Test
    public void delAllTagsTest() throws Exception {
        parseText.printSentencesWithLinks();
    }

    @Test
    public void delTagsTest() throws Exception {
        String text = "<div>&nbsp;В плоскости сечения молекулы С<sub>60</sub> - трубки фуллерена</div></body></html>";
        assertThat(parseText.delAllTags(text), is("В плоскости сечения молекулы С60 - трубки фуллерена"));
    }

    @Test
    public void isLinksSequenceAscendingTest() throws Exception {
        System.out.println(parseText.isLinksSequenceAscending());

    }
}