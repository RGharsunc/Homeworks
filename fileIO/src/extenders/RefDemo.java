package extenders;

/**
 * Created by Vardan on 07.08.2017.
 */
public class RefDemo {
    public static void main(String[] args) {
        BoxWeight boxWeight=new BoxWeight(3,5,7,8.37);
        Box plainBox=new Box();
        double vol;

        vol=boxWeight.volume();
        System.out.println("volume of weightBox is "+vol);
        System.out.println("weight  of weightBox is "+boxWeight.weight);
        System.out.println();

        plainBox=boxWeight;
        vol=plainBox.volume();
        System.out.println("volume of plainBox is "+vol);

//        System.out.println("Weight of plainBox is "+plainBox.weght);
    }
}
