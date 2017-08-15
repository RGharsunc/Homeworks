package threads;

/**
 * Created by Vardan on 11.06.2017.
 */
public class MultiThread implements Runnable {
    String name;
    Thread t;
    MultiThread(String threadname){
        name=threadname;
        t=new Thread(this,name);
        System.out.println("New thread: "+t);
        t.start();

    }
    public void run(){
        try{
            for (int i =0 ; i <5 ; i++) {
                System.out.println(name+": "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name+" interrupted");
        }
        System.out.println(name+" finished");
    }
}
class MultiThreadDemo{
    public static void main(String[] args) {

        new MultiThread("One");
        new MultiThread("Two");
        new MultiThread("Three");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("the main thread is interrupted");
        }
        System.out.println("the main thread is finished");


    }
}