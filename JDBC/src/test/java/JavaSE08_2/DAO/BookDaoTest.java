package JavaSE08_2.DAO;

import org.junit.Test;

public class BookDaoTest {
    private final String PATH_TO_INIT = "src\\main\\resources\\db.init.sql";
    private BookDao books = BookDao.getInstance();

    @Test
    public void name() throws Exception {
        books.createTable(PATH_TO_INIT);
        System.out.println( books.getEntity(1L));
    }

}

