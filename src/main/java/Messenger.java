public class Messenger implements Runnable {
    private final String message = "test message";

    @Override
    synchronized public void run() {
        while (true) {
            System.out.println(message);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
