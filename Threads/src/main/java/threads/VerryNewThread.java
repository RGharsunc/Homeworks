package threads;

import java.beans.IntrospectionException;

/**
 * Created by Vardan on 14.06.2017.
 */
public class VerryNewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    VerryNewThread(String threadName){
        name=threadName;
        t=new Thread(this,name);
        System.out.println("VerryNewThread: "+t);
        suspendFlag=false;
        t.start();
    }
    public void run(){
        try{
            for (int i = 15; i>0 ; i--) {
                System.out.println(name+": "+i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch(InterruptedException e){
            System.out.println(name+ "interrupted");
        }
        System.out.println(name+"finished");
    }
    synchronized void mysuspend(){
        suspendFlag=true;
    }
    synchronized void myresume(){
        suspendFlag=false;
        notify();
    }
}
//class