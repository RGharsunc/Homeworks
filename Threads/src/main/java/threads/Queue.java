package threads;

/**
 * Created by Vardan on 14.06.2017.
 */
public class Queue {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException ttpe exception caught");
            }
        System.out.println("Received: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException ttpe exception caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("sent: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Provider").start();
    }

    public void run() {
        int i = 0;
        while (true && i<100) {
            queue.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this,"Customer").start();
    }
    public void run(){
        while (true){
            queue.get();
        }
    }
}
class PCFixed{
    public static void main(String[] args) {
       Queue queue=new Queue();
        new Producer(queue);
        new Consumer(queue);
        System.out.println("To stop the process press Ctrl-C.");
    }
}