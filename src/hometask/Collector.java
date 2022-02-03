package hometask;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static hometask.Night.*;

public class Collector extends Thread{

    protected List<Integer> bag;

    public Collector(List<Integer> bag) {
        this.bag = bag;
    }

    @Override
    public void run() {
            while (true) {
                synchronized (currentDetails) {
                try {
                    if (counter >= NUMBER_OF_NIGHTS) {
                        break;
                    }
                    if (!currentDetails.isEmpty()) {
                        var detail = currentDetails.poll();
                        bag.add(detail);
                        System.out.println(getName() + " взял деталь " + detail);
                        currentDetails.notifyAll();
                    } else {
                        currentDetails.notifyAll();
                        currentDetails.wait(100L);
                        System.out.println(getName() + " засыпает на 100 мс");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }
}
