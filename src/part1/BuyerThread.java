package part1;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<Cashbox> cashboxes;

    public BuyerThread(BlockingQueue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            var cashbox = cashboxes.take();
            System.out.println(Thread.currentThread().getName() + ": занял кассу " + cashbox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + ": освобождаю кассу " + cashbox);
            cashboxes.add(cashbox);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}