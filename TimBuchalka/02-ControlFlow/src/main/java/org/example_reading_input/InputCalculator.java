package org.example_reading_input;

import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long avg = 0;
        int count = 0;

        while(true) {
            System.out.println("Enter an integer (or non-integer to exit):");
            try {
                int number = scanner.nextInt();
                count++;
                sum += number;
                avg = Math.round((float) sum / count);
            } catch(Exception e) {
                break;
            }
        }

        System.out.println("SUM = " + sum + " AVG = " + (count == 0 ? 0 : avg));
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
