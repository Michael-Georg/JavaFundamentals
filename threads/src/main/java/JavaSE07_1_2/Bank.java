package JavaSE07_1_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("WeakerAccess")
public class Bank {
    private List<Account> accounts;

    public Bank(String path) throws IOException {
        if (accounts == null)
            synchronized (this) {
                if (accounts == null)
                    try (Stream<String> stream = Files.lines(Paths.get(path))) {
                        accounts = stream.map(s -> s.split(" "))
                                .map(str -> new Account(Long.parseLong(str[0]), Integer.parseInt(str[1])))
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
    }

    public void transactions(String path) {
        Executor ex = Executors.newFixedThreadPool(10);
        try (Stream<String> stream = Files.lines((Paths.get(path)))) {
            stream.map(s -> s.split(" "))
                    .forEach(str -> {
                        ex.execute(() -> accounts.get(Integer.parseInt(str[0]))
                                .deposit(Integer.parseInt(str[2])));
                        ex.execute(() -> accounts.get(Integer.parseInt(str[1]))
                                .withdraw(Integer.parseInt(str[2])));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}