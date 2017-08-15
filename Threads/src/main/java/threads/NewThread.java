package threads;

/**
 * Created by Vardan on 11.06.2017.
 */
public class NewThread implements Runnable {
    private Thread t;

    NewThread() {
        t = new Thread(this, "DemoThread");
        System.out.println("Child thread is ready:  " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("child thread:  " + i);
                Thread.sleep(500, 1000);
            }
        } catch (InterruptedException e) {
            System.out.println("child thread stopped");
        }
        System.out.println("child thread finished");
    }
}


class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(0);
            }
        } catch (InterruptedException e) {
            System.out.println("child thread stopped");
        }
        System.out.println("Main thread is finished");
    }
}
