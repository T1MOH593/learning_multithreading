package myPractice;

public class CounterThreadRunner {

    public static void main(String[] args) throws InterruptedException {
        var counter = new Counter();
        var counterThread = new Thread(new CounterThread(counter));
        var counterThread1 = new Thread(new CounterThread(counter));
        var counterThread2 = new Thread(new CounterThread(counter));
        var counterThread3 = new Thread(new CounterThread(counter));
        counterThread.start();
        counterThread1.start();
        counterThread2.start();
        counterThread3.start();
        counterThread3.join();
        System.out.println(counter.getCount());
    }
}