public class Messenger implements Runnable {
    private final Object MONITOR;

    public Messenger(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    @Override
    synchronized public void run() {
        while (true) {
            synchronized (MONITOR) {
                System.out.println("test message");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MONITOR.notifyAll();
            }
        }
    }
}
