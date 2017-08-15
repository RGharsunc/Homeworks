package threads;

/**
 * Created by Vardan on 12.06.2017.
 */
public class CallMe {
    synchronized void  call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}

class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "WellCome");
        Caller ob3 = new Caller(target, "Into synchronized");
        Caller ob2 = new Caller(target, "World");

        try {
            ob1.t.join();
            ob3.t.join();
            ob2.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }


}