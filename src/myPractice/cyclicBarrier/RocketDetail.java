package myPractice.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class RocketDetail implements Runnable{

    private RocketDetails rocketDetails;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetail(RocketDetails rocketDetails, CyclicBarrier cyclicBarrier) {
        this.rocketDetails = rocketDetails;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetails);
        try {
            Thread.sleep(1000L);
            System.out.println("Готова деталь и ожидает " + rocketDetails);
            cyclicBarrier.await();
            System.out.println("Деталь использована");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
