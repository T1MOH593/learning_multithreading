package hometask;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Night extends Thread {

    private static final int FIRST_NIGHT_NUMBER_OF_ELEMENTS = 20;
    public static volatile int counter;
    public static volatile List<Integer> bag1;
    public static volatile List<Integer> bag2;
    public static final int NUMBER_OF_NIGHTS = 100;
    public static Queue<Integer> currentDetails;

    public Night() {
    }

    @Override
    public void run() {

        currentDetails = new ArrayDeque<>(FIRST_NIGHT_NUMBER_OF_ELEMENTS);
        bag1 = new ArrayList<>();
        bag2 = new ArrayList<>();
        counter = 1;

        for (int i = 0; i < FIRST_NIGHT_NUMBER_OF_ELEMENTS; i++) {
            currentDetails.add(RandomUtil.getRandomDetail());
        }
        System.out.println("Ночь: детали добавлены");

        var collector1 = new Collector(bag1);
        var collector2 = new Collector(bag2);
        collector1.start();
        collector2.start();
        while (counter < NUMBER_OF_NIGHTS) {
            if (currentDetails.isEmpty()) {
                addDetails();
                System.out.println("Ночь: детали добавлены");
                counter++;
            }
        }
        collector1.interrupt();
        collector2.interrupt();
    }

    public static void addDetails() {
        for (int i = 0; i < RandomUtil.getRandomSize(); i++) {
            currentDetails.add(RandomUtil.getRandomDetail());
        }
    }
}
