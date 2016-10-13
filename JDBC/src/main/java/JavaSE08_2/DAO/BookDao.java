package JavaSE08_2.DAO;

import JavaSE08_1.Book;
import JavaSE08_2.ConnectionPool;
import JavaSE08_2.PooledConnection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("WeakerAccess")
class BookDao implements DAOFactory<Book, Long> {
    static final ConnectionPool pool = ConnectionPool.create("src\\main\\resources\\db.properties");
    private static final BookDao instance = new BookDao();
    private static final String SQL = "SELECT * FROM Book";
    private static final String SQL1 = "SELECT * FROM Book WHERE id = ?";

    static BookDao getInstance() {
        return instance;
    }

    @Override
    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        try (PooledConnection con = pool.get();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            while (rs.next()) {
                Book.BookBuilder builder = Book.builder();
                builder.id(rs.getLong("id"));
                builder.author(rs.getString("author"));
                builder.name(rs.getString("name"));
                builder.year(rs.getInt("year"));
                list.add(builder.build());
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Book getEntity(Long id) {
        try (PooledConnection con = pool.get();
             PreparedStatement prs = con.prepareStatement(SQL1)) {
            prs.setLong(1, id);
            try (ResultSet rs = prs.executeQuery()) {
                if (rs.next()) {
                    Book.BookBuilder builder = Book.builder();
                    builder.id(rs.getLong("id"));
                    builder.author(rs.getString("author"));
                    builder.name(rs.getString("name"));
                    builder.year(rs.getInt("year"));
                    return builder.build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book update(Long entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    public void createTable(String path) {
        try (Stream<String> st = Files.lines(Paths.get(path));
             PooledConnection con = pool.get();
             Statement statement = con.createStatement()) {
            Arrays.stream(st.collect(Collectors.joining())
                    .split(";"))
                    .forEachOrdered(sql -> {
                        try {
                            statement.addBatch(sql);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
            statement.executeBatch();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Book entity) {

    }
}
