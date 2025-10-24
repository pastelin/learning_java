package org.example_reading_input;

import java.util.Scanner;

public class UserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         int sum = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter number #" + i + ": ");
            try {
                sum += scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid number");
                scanner.nextLine(); // clear the invalid input
                i--; // decrement i to repeat this iteration
            }
        }

        System.out.println("Sum = " + sum);


    }

}
