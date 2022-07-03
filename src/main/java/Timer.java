public class Timer implements Runnable {
    private int secondsLeft = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                synchronized (Messenger.class) {
                    increment();
                    Messenger.class.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void increment() throws InterruptedException {
        Thread.sleep(1000);

        secondsLeft++;
        System.out.println(secondsLeft + " seconds left");
        System.out.println(secondsLeft);

    }

}
