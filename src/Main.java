import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Старт.");
        Cash cash = new Cash();
        cashierDepositor first = new cashierDepositor(cash,"first");
        cashierDepositor second = new cashierDepositor(cash,"second");
        cashierDepositor third = new cashierDepositor(cash,"third");
        cashierDrawer fourth = new cashierDrawer(cash,"fourth");
        cashierDrawer fifth = new cashierDrawer(cash,"fifth");
        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();

        first.join();
        second.join();
        third.join();
        fourth.join();
        fifth.join();

        Cash balance = cashierDrawer.getBalance();
        System.out.println("Баланс " + balance.getBalance());
        System.out.println("Конец.");


    }
}