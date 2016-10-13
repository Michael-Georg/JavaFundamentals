package JavaSE08_1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("WeakerAccess")
public class SimpleJDBC {
    private Connection connection = null;

    public void create(String pathToConfig) throws SQLException {
        Properties properties = new Properties();
        try (InputStream config = Files.newInputStream(Paths.get(pathToConfig))) {
            properties.load(config);
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"));
    }

    public void initDB(String pathToInit) {
        try (Stream<String> st = Files.lines(Paths.get(pathToInit));
             Statement statement = connection.createStatement()) {
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

    public int addBook(String sql){
        try(Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int setBook(String sql){
        try(Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Book getBookByYear(int year) {
        Book.BookBuilder builder = Book.builder();
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT id, author, name, year FROM Book WHERE year = ?")) {
            preparedStatement.setInt(1, year);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                rs.next();
                builder.id(rs.getLong("id"));
                builder.author(rs.getString("author"));
                builder.name(rs.getString("name"));
                builder.year(rs.getInt("year"));
                return builder.build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteTable(String sql){
        try(Statement st = connection.createStatement()){
             st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        connection.close();
    }

}
