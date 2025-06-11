import java.util.List;
import java.util.Random;

public class cashierDepositor extends Thread {
    private Cash balance;
    private String name;
    Random random = new Random();

    public Cash getBalance() {
        return balance;
    }

    public cashierDepositor(Cash balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    private List<Integer> depositList = List.of(random.nextInt(100, 500),
            random.nextInt(100, 500),
            random.nextInt(100, 500));


    @Override
    public void run() {
        depositList.stream().forEach(n -> {
            try {
                balance.deposit(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
