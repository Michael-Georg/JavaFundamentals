package Java_SE01_6;

/**
 * Note is an element of {@link NoteBook}
 * @author Georgievskii M
 * @version 1.0
 */


class Note {

    private String title;
    private String text;

    Note(String title, String text) {
        this.text = text;
        this.title = title;
    }

    public Note(String text) {
        this("", text);
    }

    public Note() {
        this("","");
    }

    String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}

