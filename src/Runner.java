public class Runner {

    public static void main(String[] args) throws InterruptedException {
        var accountFrom = new Account(20000);
        var accountTo = new Account(20000);

        var threadBuyer1 = new ThreadBuyer(accountTo, accountFrom);
        var threadBuyer2 = new ThreadBuyer(accountFrom, accountTo);

        threadBuyer1.start();
        threadBuyer2.start();

        threadBuyer1.join();
        threadBuyer2.join();

        System.out.println(accountFrom);
        System.out.println(accountTo);
    }
}
