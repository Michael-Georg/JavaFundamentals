package Java_SE01_6;


/**
 * Notebook is an array of notes {@link Note}
 * @author Georgievskii M
 * @version 1.0
 *
 */

class NoteBook {

    private Note[] notebook;
    private int last;

    NoteBook(Note note) {
        notebook = new Note[5];
        notebook[0] = note;
        last = 0;
    }

    public NoteBook() {
        notebook = new Note[5];
        last = -1;
    }
    /**
     * Add new note to the next index after last
     * If array is already full create a new one with increased size
     *
     */
    void addNote(Note note) {
        if (isFull()) increase();
        notebook[++last] = note;
    }

    private void increase() {
        Note[] a = new Note[notebook.length * 3 / 2];
        for (int i = 0; i < notebook.length; i++) {
            a[i] = notebook[i];
        }
        notebook = a;
    }

    private boolean isFull() {
        return last == notebook.length - 1;
    }

    /**
     * print all notes with indexes
     */
    void showAllNotes() {
        for (int i = 0; i <= last; i++) {
            System.out.println(i + " " + notebook[i].getTitle());
            System.out.println(notebook[i].getText());
            System.out.println();
        }
    }

    /**
     * Delete note by index
     * @param num index of removing note
     */

    void removeNote(int num) {
        if (num > last) {
            System.out.println("Can't find the note");
            return;
        }
        if (last == 0) {
            System.out.println("notebook is empty");
            last = -1;
            return;
        }
        for (int i = num; i < last; i++) {
            notebook[i] = notebook[i + 1];
        }
        last--;
    }

    /**
     * Change text field in note with index num
     */
    void editNote(int num, String text) {
        if (num > last) {
            System.out.println("Can't find the note");
            return;
        }
        notebook[num].setText(text);
    }
}