import java.util.Random;

public class QuickSort {

    private static int arrayLength = 10;
    private static int[] array = new int[arrayLength];
    private static Random generator = new Random();


    public static void main(String[] args) {
        initArray();
        printArray();
        quickSort();
        printArray();
    }


    public static void initArray() {
        for (int i = 0; i <= arrayLength - 1; i++) {
            array[i] = generator.nextInt(10);
        }
    }

    public static void printArray() {
        for (int i = 0; i <= arrayLength - 1; i++) {
            System.out.print(i + "_" + array[i] + " ,");
        }
        System.out.println();
        System.out.println("*********************************");
    }

    public static void quickSort() {
        int startIndex = 0;
        int endIndex = arrayLength - 1;
        doSort(startIndex, endIndex);
    }

    private static void doSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int cur = i + (j - i) / 2;  // arrays middle index;

        while (i < j) {                                         // when first element is before the middle of array and second is after;
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {       //  i <= cur <= j ,  array[i] <= array[cur]  <= array[j];
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur) {
                    cur = j;
                } else if (j == cur) {
                    cur = i;
                }
            }


            doSort(start, cur);
            doSort(cur + 1, end);

        }
    }

}
