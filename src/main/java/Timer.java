public class Timer implements Runnable {
    private int secondsLeft = 0;
    private final Object MONITOR;

    public Timer(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (MONITOR) {
                try {
                    increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (secondsLeft == 5) {
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    MONITOR.notifyAll();
                }
            }
        }
    }

    synchronized public void increment() throws InterruptedException {
        Thread.sleep(1000);
        secondsLeft++;
        System.out.println(secondsLeft + " seconds left");
    }

}
