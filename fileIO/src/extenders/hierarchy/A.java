package extenders.hierarchy;

/**
 * Created by Vardan on 08.08.2017.
 */
public class A {
    A() {
        System.out.println("A");
    }

    A(int i) {
        System.out.println("intA");
    }
}

class B extends A {
    B(){
        System.out.println("B");
    }
    B(int j){
        System.out.println("intB");
    }
}
class C extends B{
    C(){
        System.out.println("C");
    }

    C(int k){
        System.out.println("intK");
    }
}
class Test{
    public static void main(String[] args) {
        C c=new C(10);

    }
}
