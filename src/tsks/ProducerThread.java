package tsks;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class ProducerThread extends Thread{

    private final List<Integer> list;

    public ProducerThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                try {
                    if (list.size() <= 10) {
                        int number = (int) round(random() * 10);
                        list.add(number);
                        System.out.println("Producer added " + number + ". В хранилище мест: " + list.size());
                        list.notifyAll();
                        list.wait();
                    } else {
                        System.out.println("Producer waits...");
                        list.notifyAll();
                        list.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
