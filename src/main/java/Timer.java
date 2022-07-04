public class Timer implements Runnable {
    private int secondsLeft = 0;
    private final Object MONITOR;
    private final Messenger messenger;

    public Timer(Object MONITOR, Messenger messenger) {
        this.MONITOR = MONITOR;
        this.messenger = messenger;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MONITOR) {
                if (secondsLeft % 5 == 0) {
                    messenger.setFlag(true);
                    MONITOR.notifyAll();
                }
            }
        }
    }

    synchronized public void increment() throws InterruptedException {
        Thread.sleep(1000);
        secondsLeft++;
        System.out.println(secondsLeft);
    }

}
