package extenders;

/**
 * Created by Vardan on 08.08.2017.
 */
public class A {
    private int i;

    A(int i) {
        this.i = i;
    }
}

class B extends A {

    int j;

    //    B(int a,int b){
//    super.i=a;
//    i=b;
//    }
    B(int i, int j) {
        super(j);
        this.j = j;
    }
}