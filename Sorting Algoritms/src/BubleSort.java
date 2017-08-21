import java.util.Random;

/**
 * Created by Vardan on 21.08.2017.
 */
public class BubleSort {
    private static int arrayLength = 10;
    private static int array[] = new int[arrayLength];
    private static Random generator = new Random();

    public static void main(String[] args) {

        array = initArray(array);
        printArray(array);
        System.out.println();
        System.out.println("*****************************");

        array = doSort(array);
        printArray(array);
        System.out.println();
        System.out.println("*****************************");


    }

    private static void printArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private static int[] initArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(20);
        }
        return array;
    }


    private static int[] doSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
