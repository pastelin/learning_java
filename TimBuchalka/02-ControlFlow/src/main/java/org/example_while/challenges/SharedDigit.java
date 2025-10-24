package org.example_while.challenges;

public class SharedDigit {

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {

        // Validate input: numbers must be between 10 and 99 (inclusive)
        if (firstNumber < 10 || firstNumber > 99 || secondNumber < 10 || secondNumber > 99) {
            return false;
        }

        // Convert the second number to a string for easier digit comparison
        String secondNumberString = String.valueOf(secondNumber);

        // Loop through each digit of the first number
        while (firstNumber > 0) {
            int currentDigit = firstNumber % 10; // Extract the last digit of the first number
            firstNumber /= 10; // Remove the last digit

            // Check if the current digit exists in the second number
            if (secondNumberString.contains(String.valueOf(currentDigit))) {
                return true; // Shared digit found
            }
        }

        return false; // No shared digit found
    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 24454653)); // true
        System.out.println(hasSharedDigit(9, 99)); // true
        System.out.println(hasSharedDigit(15, 55)); // false
        System.out.println(hasSharedDigit(123, 456)); // false
    }
}
