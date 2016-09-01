package Java_SE01_6;

public class Main {
    public static void main(String[] args) {
        Note note = new Note("FIRST", "timeo");
        NoteBook noteBook = new NoteBook(note);
        noteBook.addNote(new Note("SECOND", "danaos"));
        noteBook.addNote(new Note("THIRD", "et"));
        noteBook.addNote(new Note("FOURTH", "dona"));
        noteBook.addNote(new Note("FIFTH", "ferentes"));
        noteBook.editNote(5, "changed");
        noteBook.showAllNotes();
        noteBook.removeNote(0);
        noteBook.removeNote(6);

    }
}
