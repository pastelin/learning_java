package org.example_for.challenge;

public class FactorPrinter {

    public static void printFactors(int number) {
        // Validate input: number must be greater than or equal to 1
        if (number < 1) {
            System.out.println("Invalid Value");
            return; // Exit the method for invalid input
        }

        // Loop through all numbers from 1 to the given number
        for (int potentialFactor = 1; potentialFactor <= number; potentialFactor++) {
            // Check if the current number is a factor
            if (number % potentialFactor == 0) {
                System.out.println(potentialFactor); // Print the factor
            }
        }
    }

    public static void main(String[] args) {
        printFactors(10);
        printFactors(6);
    }
}
