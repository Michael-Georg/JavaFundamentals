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
        String text = "<div>&nbsp;� ��������� ������� �������� �<sub>60</sub> - ������ ���������</div></body></html>";
        assertThat(parseText.delAllTags(text), is("� ��������� ������� �������� �60 - ������ ���������"));
    }

    @Test
    public void isLinksSequenceAscendingTest() throws Exception {
        System.out.println(parseText.isLinksSequenceAscending());

    }
}