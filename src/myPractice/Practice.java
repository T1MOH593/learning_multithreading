package myPractice;

public class Practice {

    public static void main(String[] args) {
        var myThread = new MyThread();
        var runnableThread = new RunnableThread();
        myThread.start();
        var thread = new Thread(new RunnableThread());
        var thread1 = new Thread(() -> System.out.println("Runnable thread 2"));
        thread.start();
        thread1.start();
    }
}
