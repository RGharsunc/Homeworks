package threads;

/**
 * Created by Vardan on 11.06.2017.
 */
public class CurrentThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("current thread: " + t);

        t.setName("MyThread");
        System.out.println("New name of currentThread -----------" + t);

        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread was stopped");
        }
        System.out.println(t.getName());

    }
}


