import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class cashierDrawer extends Thread {
    private static Cash balance;
    private String name;
    private ReentrantLock lock = new ReentrantLock();
    Random random = new Random();
    private List<Integer> drawList = List.of(random.nextInt(100, 500),
            random.nextInt(100, 500),
            random.nextInt(100, 500));

    public static Cash getBalance() {
        return balance;
    }


    public cashierDrawer(Cash balance, String name) {
        this.balance = balance;
        this.name = name;
    }


    public void run() {

        drawList.stream().forEach(n -> {
            try {
                balance.withDraw(n, name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
