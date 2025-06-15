import java.util.concurrent.locks.ReentrantLock;

public class Cash {
    int MAX_BALANCE = 1000;
    int MIN_BALANCE = 0;
    static int balance = 0;

    private ReentrantLock lock = new ReentrantLock();

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount, String cashierName) throws InterruptedException {
        lock.lock();
        if (balance + amount < MAX_BALANCE) {
            balance += amount;
            System.out.println(cashierName + ": Внес " + amount + ". Баланс: " + balance);
            lock.unlock();
            notify();
        } else {
            System.out.println(cashierName + ": Касса переполнена, ожидаю...");
            lock.unlock();
            wait();
            deposit(amount, cashierName);
        }
    }

    public synchronized void withDraw(int amount, String cashierName) throws InterruptedException {
        lock.lock();
        if (balance - amount > MIN_BALANCE) {
            balance -= amount;
            System.out.println(cashierName + ": Выдал " + amount + ". Баланс: " + balance);
            lock.unlock();
            notify();
        } else {
            System.out.println(cashierName + ": Недостаточно средств, ожидаю...");
            lock.unlock();
            wait();
            withDraw(amount, cashierName);

        }
    }
}
