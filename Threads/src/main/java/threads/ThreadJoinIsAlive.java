package threads;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.plaf.InternalFrameUI;

/**
 * Created by Vardan on 12.06.2017.
 */
public class ThreadJoinIsAlive implements Runnable {
    Thread t;
    String name;

    ThreadJoinIsAlive(String threadname) {
        name = threadname;
        t = new Thread(this,name);
        System.out.println("new thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            System.out.println(name + " interrupted");
            System.out.println(name+" "+this.t.isAlive());
        }
        System.out.println(name + " finished");
    }

}

class DemoJoin {
    public static void main(String[] args) {
        ThreadJoinIsAlive ob1=new ThreadJoinIsAlive("One");
//        ThreadJoinIsAlive ob2=new ThreadJoinIsAlive("Two");
//        ThreadJoinIsAlive ob3=new ThreadJoinIsAlive("Three");



        System.out.println("Thread One started: "+ob1.t.isAlive());
//        System.out.println("Thread Two started: "+ob2.t.isAlive());
//        System.out.println("Thread Three started: "+ob3.t.isAlive());
        try {
            System.out.println("waiting for threads finishing");
            ob1.t.interrupt();
//            System.out.println(ob1.t.isInterrupted());
            System.out.println(ob1.t.isAlive());
            ob1.t.join();
            System.out.println(ob1.t.isAlive());
//            ob2.t.join();
//            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("Main thread is finished");
        }
        System.out.println("Thread one is started "+ob1.t.isAlive());
//        System.out.println("Thread Two is started "+ob2.t.isAlive());
//        System.out.println("Thread Three is started "+ob3.t.isAlive());
        System.out.println("Main thread is finished");

    }
}
