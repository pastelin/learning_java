package org.example_while.challenges;

public class LastDigitChecker {

    // write code here
    public static boolean hasSameLastDigit(int firstNumber, int secondNumber, int thirdNumber) {

        if (!isValid(firstNumber) || !isValid(secondNumber) || !isValid(thirdNumber)) {
            return false; // If any number is invalid, return false
        }

        int lastDigitFirst = firstNumber % 10;
        int lastDigitSecond = secondNumber % 10;
        int lastDigitThird = thirdNumber % 10;

        return (lastDigitFirst == lastDigitSecond ||
                lastDigitFirst == lastDigitThird ||
                lastDigitSecond == lastDigitThird);

    }

    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }

    public static void main(String[] args) {

        System.out.println(hasSameLastDigit(41, 22, 71)); // true
        System.out.println(hasSameLastDigit(23, 32, 42)); // false
        System.out.println(hasSameLastDigit(9, 99, 999)); // false
        System.out.println(hasSameLastDigit(10, 20, 30)); // true
        System.out.println(hasSameLastDigit(1001, 2000, 3000)); // false

    }
}
