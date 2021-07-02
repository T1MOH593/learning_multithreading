package myPractice.nextLesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        ListThread listThread1 = new ListThread(list);
        ListThread listThread2 = new ListThread(list);
        ListThread listThread3 = new ListThread(list);
        ListThread listThread4 = new ListThread(list);
        ListThread listThread5 = new ListThread(list);
        ListThread listThread6 = new ListThread(list);
        ListThread listThread7 = new ListThread(list);
        ListThread listThread8 = new ListThread(list);
        ListThread listThread9 = new ListThread(list);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();
        listThread8.start();
        listThread9.start();

        listThread1.join();
        listThread2.join();
        listThread3.join();
        listThread4.join();
        listThread5.join();
        listThread6.join();
        listThread7.join();
        listThread8.join();
        listThread9.join();
        System.out.println(list);
    }
}
