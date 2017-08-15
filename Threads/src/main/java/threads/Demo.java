package threads;

/**
 * Created by Vardan on 15.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            new Thread(new HelloRunable()).start();
            new HelloThread().start();
        }
        System.out.println("Hello from main thread");
    }

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello from " + this.getName());
        }
    }

    private static class HelloRunable implements Runnable {

        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
