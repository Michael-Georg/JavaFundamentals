package JavaSE07_1_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("WeakerAccess")
public class Account {
    private long id;
    private int balance;
    private Lock lock = new ReentrantLock();

    public Account(long id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(int i) {
        lock.lock();
            balance += i;
        lock.unlock();
    }

    public void withdraw(int i) {
        lock.lock();
            balance -= i;
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    public int getBalance() {
        return balance;
    }
}
