package threads;

/**
 * Created by Vardan on 14.06.2017.
 */
public class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered into method A.foo()");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("class A is interrupted");
        }
        System.out.println(name + " Is trying to call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In the method A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered into method B.Bar()");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("class b is interrupted");
        }
        System.out.println(name + " trying to call method A.last()");
    }

    synchronized void last() {
        System.out.println("In the method A.last()");
    }
}

class DadLock implements Runnable {
    A a = new A();
    B b = new B();

    DadLock() {
        Thread.currentThread().setName("main thread");
        Thread t = new Thread(this, "Racing thread");
        t.start();
        a.foo(b);
        System.out.println("back to the main thread");

    }
    public void run(){
        b.bar(a);
        System.out.println("back to the next thread");
    }

    public static void main(String[] args) {
        new DadLock();
    }
}