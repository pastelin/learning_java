package org.example_reading_input;

import java.util.Scanner;

public class MinAndMaxChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 1;

        while (true) {

            System.out.println("Enter number #" + count + ": ");
            try {

                int number = scanner.nextInt();
                min = Math.min(min, number);
                max = Math.max(max, number);
            } catch (Exception e) {
                System.out.println("Finished");
                scanner.nextLine(); // clear the invalid input
                break;
            }
            count++;

        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);

    }
}
