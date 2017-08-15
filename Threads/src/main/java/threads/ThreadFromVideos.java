package threads;

/**
 * Created by Vardan on 15.06.2017.
 */
public class ThreadFromVideos {
    public static void main (String[] args)throws InterruptedException {
        Thread worker = new WorkerThread();
        Thread sleeper = new SleeperThread();

        System.out.println("Thread-starting");
        worker.start();
        sleeper.start();


           Thread.sleep(100l,10);


        System.out.println("Interrupting threads");
        worker.interrupt();
        sleeper.interrupt();

    }


    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1000000000; ++i) {
                sum += i;
                if (i % 100 == 0 && isInterrupted()) {
                    System.out.println("Loop interrupted at i=" + i);
                    break;
                }
            }
        }
    }

    private static class SleeperThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100000l);
            } catch (InterruptedException e) {
                System.out.println("Sleeper interrupted");
            }
        }
    }
}
