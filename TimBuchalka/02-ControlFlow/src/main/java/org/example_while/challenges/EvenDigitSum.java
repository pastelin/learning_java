package org.example_while.challenges;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {

        // Validate input: return -1 for negative numbers
        if (number < 0) {
            return -1;
        }

        int sumOfEvenDigits = 0;

        // Loop through each digit of the number
        while (number > 0) {
            int currentDigit = number % 10; // Extract the last digit
            number /= 10; // Remove the last digit

            // Check if the digit is even
            if (currentDigit % 2 == 0) {
                sumOfEvenDigits += currentDigit; // Add even digit to the sum
            }
        }

        return sumOfEvenDigits;
    }

    public static void main(String[] args) {
        int number = 123456789;
        int evenDigitSum = getEvenDigitSum(number);
        System.out.println("The sum of even digits in " + number + " is: " + evenDigitSum);
    }

}
