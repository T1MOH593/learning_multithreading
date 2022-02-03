package tsks;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class ConsumerThread extends Thread{

    private final List<Integer> list;

    public ConsumerThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                try {
                    long round = round(random() * 10);
                    list.wait(round);
                    if (!list.isEmpty()) {
                        Integer remove = list.remove(0);
                        System.out.println("Consumer removed " + remove + ". В хранилище мест: " + list.size());
                        list.notifyAll();
                    } else {
                        System.out.println("Consumer waits...");
                        list.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
