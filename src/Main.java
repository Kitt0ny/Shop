import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Старт.");
        Cash cash = new Cash();
        cashierDepositor first = new cashierDepositor(cash,"Дима");
        cashierDepositor second = new cashierDepositor(cash,"Катя");
        cashierDepositor third = new cashierDepositor(cash,"Данил");
        cashierDrawer fourth = new cashierDrawer(cash,"Ваня");
        cashierDrawer fifth = new cashierDrawer(cash,"Аня");
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