package org.example_for;

public class Main {


    public static void main(String[] args) {

        for(int counter = 1; counter <= 10; counter++) {
            System.out.println("Counter: " + counter);

        }

        for(double rate = 2.0; rate <= 5.0; rate++) {
            double interestAmount = calculateInterest(10000.0, rate);
            System.out.println("10,000 at " + rate + "% interest = " + interestAmount);
        }

        calculateInterest();


    }

    public static void calculateInterest() {

        for (double rate = 7.5; rate <= 10.0; rate+=.25) {
            System.out.println("100 at " + rate + "% interest = " + calculateInterest(100.0, rate));
        }
    }


    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }

}
