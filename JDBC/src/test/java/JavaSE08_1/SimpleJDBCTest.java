package JavaSE08_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleJDBCTest {
    private static final String SQLINS = "INSERT INTO Book (author, name, year) " +
            "VALUES ('H. Schildt', 'Java 8', '2014')";
    private static final String SQLUPD = "UPDATE Book SET author = 'G. Korn T.Korn' " +
            "WHERE author = 'G. Korn'; ";
    private final String PATH_TO_CONFIG = "e:\\JavaPrograms\\JavaFundamentals\\JDBC" +
            "\\src\\main\\resources\\db.properties";
    private final String PATH_TO_INIT = "e:\\JavaPrograms\\JavaFundamentals\\JDBC" +
            "\\src\\main\\resources\\db.init.sql";

    private SimpleJDBC dao = new SimpleJDBC();

    @Before
    public void shouldCreateDB() throws SQLException {
        dao.create(PATH_TO_CONFIG);
        dao.initDB(PATH_TO_INIT);
    }

    @Test
    public void shouldFindBook() throws Exception {
        assertThat(dao.getBookByYear(1961).getId(), is(2));
    }

    @Test
    public void shouldAddBook() throws Exception {
        assertThat(dao.addBook(SQLINS), is(1));
    }
    @Test
    public void shouldChangeBookName() throws Exception {
        assertThat(dao.setBook(SQLUPD), is(1));
    }

    @Test
    public void shouldDeleteTable() throws Exception {
        dao.deleteTable("DROP TABLE Book");
    }

    @After
    public void close() {
        try {
            dao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}