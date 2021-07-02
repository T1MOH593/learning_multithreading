public class ThreadBuyer extends Thread{

    private final Account accountTo;
    private final Account accountFrom;

    public ThreadBuyer(Account accountTo, Account accountFrom) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20_000; i++) {
            lockAccounts();
            try {
                if (accountTo.takeOff(10)) {
                    accountFrom.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            var resultOfLock1 = accountTo.getLock().tryLock();
            var resultOfLock2 = accountFrom.getLock().tryLock();
            if (resultOfLock1 && resultOfLock2) {
                break;
            }
            if (resultOfLock1) {
                accountTo.getLock().unlock();
            }
            if (resultOfLock2) {
                accountFrom.getLock().unlock();
            }
        }
    }
}
