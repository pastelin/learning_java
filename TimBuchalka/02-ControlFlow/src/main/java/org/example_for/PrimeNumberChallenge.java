package org.example_for;

public class PrimeNumberChallenge {


    public static void main(String[] args) {

        int primeNumberCount = 0;
        for (int i = 2; primeNumberCount < 3 && i <= 500; i++) {
            if(isPrime(i)){
                primeNumberCount++;
                System.out.println(i + " is a prime number");
            }
        }

    }

    public static boolean isPrime(int wholeNumber) {

        if(wholeNumber <= 2) {
            return wholeNumber == 2; // 2 is prime, 0 and 1 are not prime
        }

        for(int divisor = 2; divisor <= wholeNumber / 2; divisor++) {
            if(wholeNumber % divisor == 0) {
                // If the number is divisible by any number other than 1 and itself, it's not prime
                return false;
            }
        }

        return true;
    }
}
