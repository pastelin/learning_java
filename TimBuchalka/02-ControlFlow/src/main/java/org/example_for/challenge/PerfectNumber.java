package org.example_for.challenge;

public class PerfectNumber {

    public static boolean isPerfectNumber(int number) {

        if(number < 1) {
            return false; // Perfect numbers are positive integers
        }

        int sumOfDivisors = 0;

        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                sumOfDivisors += i; // Add the divisor to the sum
            }

        }

        return sumOfDivisors == number; // Check if the sum of divisors equals the number

    }
}
