package rocket;

import java.util.concurrent.CountDownLatch;

public class RocketDetail implements Runnable{

    private RocketDetails rocketDetails;
    private final CountDownLatch countDownLatch;

    public RocketDetail(RocketDetails rocketDetails, CountDownLatch countDownLatch) {
        this.rocketDetails = rocketDetails;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetails);
        try {
            Thread.sleep(1000L);
            System.out.println("Готова деталь " + rocketDetails);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
