package abstracts;

/**
 * Created by Vardan on 08.08.2017.
 */
public abstract class A {
    int i;
    static void printI(int j){
        System.out.println(j);
    }
    abstract void delete(int k);
}
class B{
    public static void main(String[] args) {
        A.printI(10);
    }

}
