package JavaSE07_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("WeakerAccess")
public class BankSync {
    private List<AccountSync> accounts;

    public BankSync(String path) {
        if (accounts == null)
            synchronized (this) {
                if (accounts == null)
                    try (Stream<String> stream = Files.lines(Paths.get(path))) {
                        accounts = stream.map(s -> s.split(" "))
                                .map(str -> new AccountSync(Long.parseLong(str[0]), Integer.parseInt(str[1])))
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
    }

    public void transactions(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.map(s -> s.split(" "))
                    .forEach(str -> {
                        new Thread(() -> accounts.get(Integer.parseInt(str[0]))
                                .deposit(Integer.parseInt(str[2])))
                                .start();
                        new Thread(() -> accounts.get(Integer.parseInt(str[1]))
                                .withdraw(Integer.parseInt(str[2])))
                                .start();
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<AccountSync> getAccounts() {
        return accounts;
    }
}