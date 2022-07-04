public class Messenger implements Runnable {
    private final Object MONITOR;
    private boolean flag = false;

    public Messenger(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    System.out.println("5 seconds left");
                    flag = false;
                }
            }
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
