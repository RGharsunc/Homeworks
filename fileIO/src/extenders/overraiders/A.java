package extenders.overraiders;

/**
 * Created by Vardan on 08.08.2017.
 */
public class A implements GH{
    int i, j;
   public int dget(int i){
      return i;
    }
    //    A(){};
    A(int a, int b) {
        i = a;
        j = b;
    }

    void show() {
        System.out.println("i & j: " + i + " " + j);
    }
}

class B extends A {
    int k;

    B(int a, int b, int k) {
        super(a, b);
        this.k = k;
    }

    void show() {
        System.out.println("k: " + k);
    }
}
class C extends B{
    int l;
    C(int a, int b, int k, int l){
        super(a,b,k);
        this.l=l;
    }

    void show() {
        System.out.println("l: "+l);
    }
}
class Test{
    public static void main(String[] args) {
        B subOB=new B(1,2,3);
        subOB.show();

        A subOAB=new B(4,12,45);
        subOAB.show();

        A subOA= new A(1,2);
        subOA.show();

        A subOAC=new C(10,20,30, 40);
        subOAC.show();
        System.out.println(subOAC.getClass());

    }
}
interface GH{
    public int dget(int i);
}
