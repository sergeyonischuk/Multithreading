public class Messenger implements Runnable {
    private final Object MONITOR;

    public Messenger(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    @Override
    synchronized public void run() {
        while (true) {
            synchronized (MONITOR) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String message = "test message";
            System.out.println(message);
        }
    }
}
