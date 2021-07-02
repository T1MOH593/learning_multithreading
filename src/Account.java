import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int id;
    private static int generator = 1;
    private int money;
    private final Lock lock = new ReentrantLock();

    public Account(int money) {
        id = generator++;
        this.money = money;
    }

    public void add(int sum) {
        money += sum;
    }

    public boolean takeOff(int sum) {
        if (sum <= money) {
            money -= sum;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

    public Lock getLock() {
        return lock;
    }
}
