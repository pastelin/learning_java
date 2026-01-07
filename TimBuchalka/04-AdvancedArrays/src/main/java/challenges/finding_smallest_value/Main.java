package challenges.finding_smallest_value;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] numbers = readIntegers(5);
        int min = findMin(numbers);
        System.out.println("The smallest number is: " + min);

    }

    private static int[] readIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++) {
            System.out.println("Enter number #" + (i + 1) + ":");
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        System.out.println(Arrays.toString(numbers));
        return numbers;
    }

    private static int findMin(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);

        return copyArr[0];
    }
}
