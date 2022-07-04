public class Main {
    final static Object MONITOR = new Object();
    public static void main(String[] args) throws InterruptedException {


        Messenger messenger = new Messenger(MONITOR);
        Timer timer = new Timer(MONITOR, messenger);
        Thread thread = new Thread(timer);
        Thread thread2 = new Thread(messenger);
        thread.start();
        thread2.start();
    }
}