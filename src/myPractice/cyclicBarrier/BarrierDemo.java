package myPractice.cyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        var cyclicBarrier = new CyclicBarrier(RocketDetails.values().length, () -> System.out.println("Пуск!!!"));

        var threadPool = Executors.newCachedThreadPool();

        Arrays.stream(RocketDetails.values())
                .map(detail -> new RocketDetail(detail, cyclicBarrier))
                .forEach(threadPool::submit);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);

    }
}
