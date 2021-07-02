package myPractice.vol;

public class VolatileDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread still_false = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });
        still_false.start();
        Thread.sleep(3L);

        Thread thread = new Thread(() -> {
            flag = true;
            System.out.println("it's true!");
        });
        thread.start();
    }
}
