public class Main {
    final static Object MONITOR = new Object();
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer(MONITOR);
        Messenger messenger = new Messenger(MONITOR);
        Thread thread = new Thread(timer);
        Thread thread2 = new Thread(messenger);
        thread.start();
        thread2.start();
        Thread.sleep(7000);
        System.out.println(thread.getState());
        System.out.println(thread2.getState());
    }
}