package JavaSE07_1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@SuppressWarnings("WeakerAccess")
@AllArgsConstructor
@ToString
public class AccountSync {
    private long id;
    private int balance;

    public void deposit(int i) {
        synchronized (this) {
            balance += i;
        }
    }

    public void withdraw(int i) {
        synchronized (this) {
            balance -= i;
        }
    }

    public int getBalance() {
        return balance;
    }
}
