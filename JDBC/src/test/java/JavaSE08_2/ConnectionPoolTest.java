package JavaSE08_2;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class ConnectionPoolTest {
    private final String PATH_TO_CONFIG = "src\\main\\resources\\db.properties";
    private final String PATH_TO_INIT = "src\\main\\resources\\db.init.sql";

    @Test
    public void connectionPoolTest() throws Exception {
       ConnectionPool pool = ConnectionPool.create(PATH_TO_CONFIG);
        try (Stream<String> st = Files.lines(Paths.get(PATH_TO_INIT));
             Connection connection = pool.get();
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
            ResultSet rs = statement.executeQuery("SELECT name FROM Book WHERE year = 1961");
            if (rs.next())
                assertTrue(rs.getString("name") != null);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println(pool.getActiveConnections());
    }
}