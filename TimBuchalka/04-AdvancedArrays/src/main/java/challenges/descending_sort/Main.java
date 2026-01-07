package challenges.descending_sort;

import java.util.Arrays;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        int[] randomArray = generatedRandomArray(5);
        System.out.println("Unsorted Array: " + Arrays.toString(randomArray));

        Arrays.sort(randomArray);
        for (int i = 0; i < randomArray.length / 2; i++ ) {
            int firstTemp = randomArray[i];
            randomArray[i] = randomArray[randomArray.length - 1 - i];
            randomArray[randomArray.length - 1 - i] = firstTemp;
        }

        System.out.println("Sorted Array (Descending): " + Arrays.toString(randomArray));
    }

    private static int[] generatedRandomArray(int length) {

        int[] newArray = new int[length];
        Random random = new Random();

        for(int i = 0; i < length; i++) {
            newArray[i] = random.nextInt(100);
        }

        return newArray;
    }
}
