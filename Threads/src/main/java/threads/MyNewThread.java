package threads;

/**
 * Created by Vardan on 11.06.2017.
 */
public class MyNewThread extends Thread {
    MyNewThread(){
        super("DemoThread");
        System.out.println("child thread: "+this);
        start();
    }
    public void run(){
        try {
            for (int i = 5; i>0 ; i--) {
                System.out.println("child thread: "+i);
                Thread.sleep(1500);
            }
        }catch (InterruptedException e){
            System.out.println("child thread is interrupted:");
        }
        System.out.println("child thread is finished");
    }
}

class ExtendThread{
    public static void main(String[] args) {
        new MyNewThread();
    try{
        for (int i =5; i >0; i--) {
            System.out.println("main Thread: "+i);
            Thread.sleep(1000);
        }
    }catch (InterruptedException e){
        System.out.println("main Thread is interrupted");
    }
        System.out.println("main thread is finished");
    }
}
