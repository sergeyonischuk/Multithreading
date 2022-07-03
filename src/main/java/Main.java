public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        Messenger messenger = new Messenger();
        Thread thread = new Thread(timer);
        Thread thread2 = new Thread(messenger);
        thread.start();
        thread2.start();
        System.out.println(thread2.getState());
        Thread.sleep(1500);
        System.out.println(thread2.getState());
        Thread.sleep(6000);
        System.out.println(thread2.getState());
        Thread.sleep(15000);
        System.out.println(thread2.getState());
    }
}